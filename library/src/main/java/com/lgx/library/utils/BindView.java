package com.lgx.library.utils;

import android.support.annotation.IdRes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by liugaoxin on 2018/8/22.
 * 自定义注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME) //kotlin默认是runtime
public @interface BindView {
    @IdRes int id() default 0;
}
