package com.lgx.weatherforecast

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.lgx.library.BaseActivity

/**
 * Created by liugaoxin on 2018/8/25.
 * 入口页面
 */
class WelcomeActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        Handler().postDelayed({
            startActivity(Intent(this@WelcomeActivity, MainActivity::class.java))
            finish()
        }, 2 * 1000)
    }
}