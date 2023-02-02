package com.example.jetpack_compose.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

private const val SERVER_API = "https://rickandmortyapi.com"

object RetrofitAPI {

    private val retrofit = Retrofit.Builder()
        .client(
            OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().also {
                it.level = HttpLoggingInterceptor.Level.BODY
            }).build()
        )
        .baseUrl(SERVER_API)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    suspend fun getDataFormApiPaging(page: Int): MyDataDTO {
        val dataApi: GetAPI = retrofit.create(GetAPI::class.java)
        return dataApi.getPageData(page)
    }
    suspend fun getDataFormApiPagingLocation(page: Int): LocationDTO {
        val dataApi: GetAPI = retrofit.create(GetAPI::class.java)
        return dataApi.getPageDataLocation(page)
    }
}

interface GetAPI {
    @Headers("Accept: application/json", "Content-type: application/json")
    @GET("/api/character")
    suspend fun getPageData(@Query("page") page: Int): MyDataDTO
    @GET("/api/location")
    suspend fun getPageDataLocation(@Query("page") page: Int): LocationDTO
}
