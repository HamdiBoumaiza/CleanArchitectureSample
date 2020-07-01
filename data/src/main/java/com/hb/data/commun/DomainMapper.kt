package com.hb.data.commun

interface DomainMapper<T : Any> {
    fun mapToDomainModel(): T
}