package com.hb.domain.commun

interface GeneralUseCase<in Request, out Type> {

    suspend operator fun invoke(request: Request): Type

}