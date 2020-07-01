package com.hb.domain.commun

interface GeneralUseCase<Type, in Request> {

    suspend operator fun invoke(request: Request): Type

}