package com.lgx.library.utils

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.lgx.library.BaseApplication

/**
 * Created by liugaoxin on 2018/9/7.
 * sp工具类
 */
object SpUtil {
    private var mPreferences: SharedPreferences

    init {
        //sp默认名字用应用包名
        val context: Application = BaseApplication.sApplication
        mPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    }

    fun putData(key: String, value: Any) {
        when(value) {
            is Int -> mPreferences.edit().putInt(key, value).apply()
            is String -> mPreferences.edit().putString(key, value).apply()
            is Float -> mPreferences.edit().putFloat(key, value).apply()
            is Boolean -> mPreferences.edit().putBoolean(key, value).apply()
            is Long -> mPreferences.edit().putLong(key, value).apply()
            else -> throw IllegalArgumentException("sp类型不对")
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> getData(key: String, default: T): T {
        val tClass: Class<T>

        return when(default) {
            is Int -> {
                tClass = Int::class.java as Class<T>
                tClass.cast(mPreferences.getInt(key, default))
            }

            is String -> {
                tClass = String::class.java as Class<T>
                tClass.cast(mPreferences.getString(key, default))
            }

            is Float -> {
                tClass = Float::class.java as Class<T>
                tClass.cast(mPreferences.getFloat(key, default))
            }

            is Boolean -> {
                tClass = Boolean::class.java as Class<T>
                tClass.cast(mPreferences.getBoolean(key, default))
            }

            is Long -> {
                tClass = Long::class.java as Class<T>
                tClass.cast(mPreferences.getLong(key, default))
            }

            else -> throw IllegalArgumentException("sp类型不对")
        }
    }
}