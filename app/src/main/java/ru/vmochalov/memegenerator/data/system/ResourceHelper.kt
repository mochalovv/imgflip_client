package ru.vmochalov.memegenerator.data.system

import android.content.Context
import androidx.annotation.ArrayRes
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Helps to get resources without importing the context.
 */
@Singleton
class ResourceHelper @Inject constructor(
    private val context: Context
) {

    fun getString(@StringRes stringRes: Int): String =
        context.getString(stringRes)

    fun getString(@StringRes stringRes: Int, vararg formatArgs: Any): String =
        context.getString(stringRes, *formatArgs)

    fun getStringsList(@ArrayRes arrayRes: Int) =
        context.resources.getStringArray(arrayRes).toList()

    fun getColor(@ColorRes colorRes: Int): Int {
        return ContextCompat.getColor(context, colorRes)
    }
}