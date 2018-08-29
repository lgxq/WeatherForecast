package com.lgx.weatherforecast

import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView

/**
 * Created by liugaoxin on 2018/8/25.
 * 入口页面
 */
class WelcomeActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        setImage()

        Handler().postDelayed({
            startActivity(Intent(this@WelcomeActivity, MainActivity::class.java))
            finish()
        }, 2 * 1000)
    }

    //透明度属性动画
    private fun setImage() {
        val icon = findViewById<ImageView>(R.id.welcome_image)
        icon.setImageResource(R.drawable.welcome_image)
        val animation = ObjectAnimator.ofFloat(icon, "alpha", 0f, 1f)
        animation.duration = 2 * 1000
        animation.start()
    }
}