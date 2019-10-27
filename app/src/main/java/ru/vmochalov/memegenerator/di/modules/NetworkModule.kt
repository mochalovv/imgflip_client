package ru.vmochalov.memegenerator.di.modules

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import ru.vmochalov.memegenerator.BuildConfig
import ru.vmochalov.memegenerator.data.MoshiFactory
import ru.vmochalov.memegenerator.data.network.CurlLoggingInterceptor
import ru.vmochalov.memegenerator.data.network.ServerApi
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesServerApi(client: OkHttpClient, moshi: Moshi): ServerApi {
        return createApi(
            client,
            moshi,
            BuildConfig.API_BASE_URL
        )
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return createOkHttpClient()
    }

    @Provides
    @Singleton
    fun prodivesMoshiFacotry(): Moshi = MoshiFactory().create()

    private inline fun <reified T> createApi(
        client: OkHttpClient,
        moshi: Moshi,
        baseUrl: String
    ): T {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(T::class.java)
    }

    private fun createOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        with(builder) {
            connectTimeout(30, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(30, TimeUnit.SECONDS)

            addInterceptor(loggingInterceptor())
            addInterceptor(curlLoggingInterceptor())
        }
        return builder.build()
    }

    private fun loggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor { message ->
            Timber.tag("OkHttp").d(message)
        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private fun curlLoggingInterceptor(): Interceptor {
        return CurlLoggingInterceptor { message ->
            Timber.tag("Curl").d(message)
        }
    }

}