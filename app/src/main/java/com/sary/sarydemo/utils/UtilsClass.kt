package com.sary.sarydemo.utils

import android.content.Context
import java.util.*

class UtilsClass {
    private lateinit var lang: String


    fun getLang(): String {
        if (Locale.getDefault().getDisplayLanguage().equals("English")) {
            lang = "en"
        } else {
            lang = "ar"
        }
        return lang
    }
}