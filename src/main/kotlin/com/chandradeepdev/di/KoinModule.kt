package com.chandradeepdev.di

import com.chandradeepdev.repository.HeroRepository
import com.chandradeepdev.repository.HeroRepositoryImpl
import org.koin.dsl.module

val koinModule = module {
    single<HeroRepository> {
        HeroRepositoryImpl()
    }
}