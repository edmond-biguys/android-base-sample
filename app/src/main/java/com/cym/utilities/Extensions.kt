package com.cym.utilities

import android.content.Context
import android.util.TypedValue

/**
 * Created by caoj on 2024/4/19.
 */
fun Float.dp2px(context: Context): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        context.resources.displayMetrics
    ).toInt()
}

fun Int.dp2px(context: Context): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        context.resources.displayMetrics
    ).toInt()
}