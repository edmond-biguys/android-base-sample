package com.cym.customerview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.TextView
import com.cym.utilities.dp2px

/**
 * Created by caoj on 2024/4/17.
 */
private const val TAG = "CustomerCircle"
class CustomerCircle : View {

    //Simple constructor to use when creating a view from code.
    //通过Java、kotlin代码创建时，使用的构造函数
    constructor(context: Context): super(context) {
        init(null)
    }

    //Constructor that is called when inflating a view from XML.
    //当你在xml文件里使用控件时，系统会调用这个构造函数，如果没有，程序会闪退。
    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet) {
        init(attributeSet)
    }

    /*
    三个参数的构造函数：一般系统不会主动调用，需要手动调用，可以手动传入defStyleAttr并调用，
    即时在view中定义了them，style，也不会调用三参构造函数。
    */
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int): super(context, attributeSet, defStyleAttr) {
        init(attributeSet)
    }

    /*
    四个参数的构造函数，如果第三个参数为0或者没有定义defStyleAttr时，第四个参数才起作用，
    它是style的引用，高版本才支持，所以一般不会用到。
    */
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int): super(context, attrs, defStyleAttr, defStyleRes) {
        init(attrs)
    }

    private val paint = Paint()

    private fun init(attributeSet: AttributeSet?) {
        paint.color = Color.CYAN
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        Log.i(TAG, "onDraw: ")
        canvas.drawCircle(100.dp2px(context).toFloat(), 100.dp2px(context).toFloat(), 100.dp2px(context).toFloat(), paint)
    }
}