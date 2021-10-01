package com.example.dagger.model

import androidx.room.Entity
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

@Entity(tableName = "owner")
data class Owner (val avatar_url:String?)

class TypeConverterOwner {
    val gson: Gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String): Owner? {
        if (data == null) return null
        val listType: Type = object : TypeToken<Owner?>() {}.type
        return gson.fromJson<Owner?>(data, listType)
    }

    @TypeConverter
    fun someObjectToString(someobject: Owner?): String? {
        return gson.toJson(someobject)
    }
}