package com.lgx.library.utils

import kotlin.reflect.KAnnotatedElement

/**
 * Created by liugaoxin on 2018/8/25.
 * 顶层函数
 */

//定义辅助内联函数
inline fun <reified T> KAnnotatedElement.findAnnotation(): T? = annotations.filterIsInstance<T>().firstOrNull()

//顶层函数，解析BindView的注解
fun parseFind(obj: Any) {
    val method = obj.javaClass.getMethod("findViewById", Int::class.java)

    obj.javaClass.declaredFields
            .filter { it.isAnnotationPresent(BindView::class.java) }
            .forEach {
                val id = it.getAnnotation(BindView::class.java).id
                it.isAccessible = true
                it.set(obj, method?.invoke(obj, id))
            }
}






/*
    * 使用kotlin的反射第一次调用会非常耗时，原因未知
    * 同时如果解析使用上面java的形式而注解的定义如果kotlin的形式，
    * 则Filed拿不到Annotations，只有Filed对应的kotlin的declaredMemberProperties才能拿到
    * 所以注解的定义也只能用java的形式,关于kotlin的反射待学习
    * */


/*    val kFunction = obj.javaClass.kotlin.functions.firstOrNull { it.name == "findViewById" }

    obj.javaClass.kotlin.declaredMemberProperties
            .filter { it.findAnnotation<BindView>() != null }
            .forEach {
                var id = 0
                it.annotations.forEach {
                    it as BindView
                    id = it.id
                }

                it.isAccessible = true
                it.javaField?.set(obj, kFunction?.javaMethod?.invoke(obj, id))
            }*/