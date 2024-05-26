/*
 *
 * Copyright (C) 2014  Antoine Vianey
 * Copyright (C) 2021- woheller69
 * Copyright 2024 The Old Autumn Project
 * An Android Bubble Level application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Level is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Level. If not, see <http://www.gnu.org/licenses/>
 *
 */
package me.greenrobot.apps.level.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatSeekBar

class VerticalSeekBar : AppCompatSeekBar {
    private var mOnSeekBarChangeListener: OnSeekBarChangeListener? = null

    constructor(context: Context?) : super(context!!)

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(
        context!!,
        attrs,
        defStyle,
    )

    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!,
        attrs,
    )

    override fun onSizeChanged(
        width: Int,
        height: Int,
        oldWidth: Int,
        oldHeight: Int,
    ) {
        super.onSizeChanged(height, width, oldHeight, oldWidth)
    }

    @Synchronized
    override fun onMeasure(
        widthMeasureSpec: Int,
        heightMeasureSpec: Int,
    ) {
        super.onMeasure(heightMeasureSpec, widthMeasureSpec)
        setMeasuredDimension(measuredHeight, measuredWidth)
    }

    override fun onDraw(c: Canvas) {
        c.rotate(ROTATION_ANGLE.toFloat())
        c.translate(-height.toFloat(), 0f)

        super.onDraw(c)
    }

    override fun setOnSeekBarChangeListener(l: OnSeekBarChangeListener) {
        mOnSeekBarChangeListener = l
        super.setOnSeekBarChangeListener(l)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (!isEnabled) {
            return false
        }

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                progress = max - (max * event.y / height).toInt()
                mOnSeekBarChangeListener!!.onStartTrackingTouch(this)
            }

            MotionEvent.ACTION_MOVE -> progress = max - (max * event.y / height).toInt()
            MotionEvent.ACTION_UP -> {
                progress = max - (max * event.y / height).toInt()
                mOnSeekBarChangeListener!!.onStopTrackingTouch(this)
            }

            MotionEvent.ACTION_CANCEL -> mOnSeekBarChangeListener!!.onStopTrackingTouch(this)
            else -> {}
        }
        return true
    }

    override fun setProgress(progress: Int) {
        super.setProgress(progress)
        onSizeChanged(width, height, 0, 0)
    }

    companion object {
        private const val ROTATION_ANGLE = -90
    }
}
