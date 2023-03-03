package br.com.mywishkart.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoryItem(
    val categoryTitle: String,
    val items: List<WishItem>
): Parcelable

@Parcelize
data class WishItem(
    val title: String,
    val date: String,
    val value: Double
): Parcelable