package ru.vmochalov.memegenerator.di

import dagger.Module
import dagger.Provides
import ru.vmochalov.memegenerator.data.gateway.MemeParamsGateway
import ru.vmochalov.memegenerator.data.gateway.MemesGateway
import ru.vmochalov.memegenerator.data.network.ServerApi
import ru.vmochalov.memegenerator.data.storage.MemeParamsStorage
import ru.vmochalov.memegenerator.data.storage.MemeTemplatesStorage
import javax.inject.Singleton

@Module
class GatewayModule {

    @Provides
    @Singleton
    fun provideMemesGateway(
        serverApi: ServerApi,
        memeTemplatesStorage: MemeTemplatesStorage
    ): MemesGateway = MemesGateway(serverApi, memeTemplatesStorage)

    @Provides
    @Singleton
    fun providesMemeParamsGateway(
        memeParamsStorage: MemeParamsStorage
    ): MemeParamsGateway = MemeParamsGateway(
        memeParamsStorage
    )
}