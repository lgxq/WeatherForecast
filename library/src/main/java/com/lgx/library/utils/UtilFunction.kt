package com.lgx.library.utils

import kotlin.reflect.KAnnotatedElement
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.jvm.isAccessible
import kotlin.reflect.jvm.javaField

/**
 * Created by liugaoxin on 2018/8/25.
 * 顶部函数
 */

//定义辅助内联函数
inline fun <reified T> KAnnotatedElement.findAnnotation(): T? = annotations.filterIsInstance<T>().firstOrNull()

//顶层函数，解析BindView的注解
fun parseFind(obj: Any) {
    //val kFunction = obj.javaClass.kotlin.functions.firstOrNull { it.name == "findViewById" }
    val method = obj.javaClass.getMethod("findViewById", Int::class.java)

    obj.javaClass.kotlin.declaredMemberProperties
            .filter { it.findAnnotation<BindView>() != null }
            .forEach {
                var id = 0
                it.annotations.forEach {
                    it as BindView
                    id = it.id
                }

                it.isAccessible = true
                it.javaField?.set(obj, method?.invoke(obj, id))
            }
}
