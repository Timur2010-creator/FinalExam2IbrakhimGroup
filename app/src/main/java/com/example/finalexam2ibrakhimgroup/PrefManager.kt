package com.example.finalexam2ibrakhimgroup

import android.content.Context

class PrefManager(context: Context) {

    val pref  = context.getSharedPreferences("key", Context.MODE_PRIVATE)

    fun getCount():Int{
        return pref.getInt("jkk",0);


    }

    fun saveCount(value:Int){
        pref.edit().putInt("jkk",value).apply()
    }
}