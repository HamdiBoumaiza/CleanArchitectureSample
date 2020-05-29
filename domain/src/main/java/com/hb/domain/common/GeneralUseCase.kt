package com.hb.domain.common

interface GeneralUseCase<Type, in Request> {

    operator fun invoke(request: Request): Type

}