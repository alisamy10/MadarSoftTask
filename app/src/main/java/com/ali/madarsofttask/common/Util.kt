package com.ali.madarsofttask.common

import com.ali.madarsofttask.entity.source.model.User

import java.util.Locale

fun String.searchQuery( responseList: List<User>?): MutableList<User> {
    val responses: MutableList<User> = ArrayList()
    if (responseList == null || responseList.isEmpty())
        return responses
    for (response in responseList) {
        /*
    Useful constant for the root locale. The root locale is the locale whose language, country, and variant are empty ("") strings.
    This is regarded as the base locale of all locales, and is used as the language/country neutral locale for the locale sensitive operations.
     */
        val name: String? = response.name?.toLowerCase(Locale.ROOT)
        if (this.toLowerCase(Locale.ROOT)?.let { name?.contains(it) }!!)
            responses.add(response)
    }

    return responses
}