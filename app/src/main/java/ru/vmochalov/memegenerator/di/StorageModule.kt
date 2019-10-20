package ru.vmochalov.memegenerator.di

import dagger.Module
import dagger.Provides
import ru.vmochalov.memegenerator.data.storage.MemeParamsStorage
import ru.vmochalov.memegenerator.data.storage.MemeTemplatesStorage
import javax.inject.Singleton

@Module
class StorageModule {

    @Provides
    @Singleton
    fun providesMemeTemplatesStorage(): MemeTemplatesStorage = MemeTemplatesStorage()

    @Provides
    @Singleton
    fun providesMemeParamsStorage(): MemeParamsStorage = MemeParamsStorage()
}