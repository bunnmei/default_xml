package space.webkombinat.defaultviewnavigation.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class MyCanvasView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private val paint = Paint().apply{
        color = Color.RED
        strokeWidth = 8f
        style = Paint.Style.STROKE
        isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 線を描く (x1, y1) → (x2, y2)
        canvas.drawLine(50f, 50f, 300f, 300f, paint)

        // 円を描く (中心 x, 中心 y, 半径)
        canvas.drawCircle(200f, 200f, 80f, paint)
    }
}