package br.com.mywishkart.firebase

import br.com.mywishkart.di.appModule
import br.com.mywishkart.network.moshi
import com.google.firebase.FirebaseApp
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Types
import org.koin.core.component.KoinComponent
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import java.lang.reflect.Type

object RemoteConfigManager : KoinComponent {
    private const val FETCH_TIMEOUT = 60L
    private val instance get() = Firebase.remoteConfig(FirebaseApp.getInstance())

    init {
        instance.setConfigSettingsAsync(
            remoteConfigSettings {
                fetchTimeoutInSeconds = FETCH_TIMEOUT
            }
        )
    }

    fun fetch(onFinished: (Boolean) -> Unit) = instance.fetchAndActivate()
        .addOnCompleteListener {
            unloadKoinModules(appModule)
            loadKoinModules(appModule)
            onFinished(it.isSuccessful)
        }
        .addOnFailureListener { it.printStackTrace() }

    fun getString(key: String): String = instance.getString(key)

    fun getLong(key: String): Long = instance.getLong(key)

    fun getBoolean(key: String): Boolean = instance.getBoolean(key)

    private inline fun <reified T : Any> getList(key: String): List<T> = try {
        val json = getString(key)
        val type: Type = Types.newParameterizedType(MutableList::class.java, T::class.java)
        val adapter: JsonAdapter<MutableList<T>> = moshi.adapter(type)
        adapter.fromJson(json)!!
    } catch (e: Exception) {
        listOf()
    }
}