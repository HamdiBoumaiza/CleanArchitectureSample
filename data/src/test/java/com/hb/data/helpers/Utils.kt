package com.hb.data.helpers


import com.google.common.io.Resources.getResource
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

/**
 * Helper function which will load JSON from
 * the path specified
 *
 * @param path : Path of JSON file
 * @return json : JSON from file at given path
 */

internal fun getJson(path: String): String {
    val uri = getResource(path)
    val file = File(uri.path)
    return String(file.readBytes())
}

/**
 * inline function to convert json string to a TypeToken generic type
 * can be used in two ways like in the example below
 * val case1 = Gson().fromJsonToObjectType<SharedResponse<List<FuelPriceEntity>>>(result.data.toString())
 * val case2 : SharedResponse<List<FuelPriceEntity>> = Gson().fromJsonToObjectType(result.data.toString())
 */
inline fun <reified T> Gson.fromJsonToObjectType(json: String): T =
    fromJson(json, object : TypeToken<T>() {}.type)

