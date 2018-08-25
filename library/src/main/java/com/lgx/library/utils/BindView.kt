package com.lgx.library.utils

/**
 * Created by liugaoxin on 2018/8/22.
 * 自定义注解
 */
@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME) //kotlin默认是runtime
annotation class BindView(val id: Int)