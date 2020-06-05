package com.yidao.module_lib.anotation;


import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.yidao.module_lib.anotation.FragmentId.Friend_Fragment;
import static com.yidao.module_lib.anotation.FragmentId.Info_Fragment;
import static com.yidao.module_lib.anotation.FragmentId.Message_Fragment;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.CLASS;


@IntDef({Info_Fragment, Message_Fragment,Friend_Fragment})
@Retention(CLASS)
@Target({METHOD, PARAMETER, FIELD, LOCAL_VARIABLE})
public @interface FragmentId {

    int Info_Fragment = 0;
    int Message_Fragment = 1;
    int Friend_Fragment = 2;
}
