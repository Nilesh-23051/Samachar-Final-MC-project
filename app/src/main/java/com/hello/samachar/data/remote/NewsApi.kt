//Creating NewsAPIs

package com.hello.samachar.data.remote

import com.hello.samachar.data.remote.dto.NewsResponse
import com.hello.samachar.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    suspend fun getNews(
        @Query("page") page:Int,
        @Query("sources") sources : String,
        @Query("apiKey") apiKey : String=API_KEY
    ):NewsResponse

    //For searching news
    @GET("everything")
    suspend fun searchNews(
        @Query("q") searchQuery: String,
        @Query("sources") sources: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse


    @GET("everything")
    suspend fun locationNews(
        @Query("sources") sources: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = API_KEY,
        @Query("country") country: String
    ): NewsResponse

}
