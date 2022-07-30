package com.ewind.newsapi.data.source.remote.apis


import com.ewind.newsapi.data.source.remote.model.Response
import com.ewind.newsapi.data.source.remote.model.forecast.Weather
import com.ewind.newsapi.util.Constant
import com.ewind.newsapi.util.network.QueryConst
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines")
    fun getTopNews(
        @Query(QueryConst.PAGE) page: Int,
        @Query(QueryConst.PAGE_SIZE) pageSize: Int = Constant.PER_PAGE,
        @Query(QueryConst.COUNTRY) country: String? = "us"
    ): Observable<Response>

    @GET("everything")
    fun getNews(
        @Query(QueryConst.Q) keyword: String? = null,
        @Query(QueryConst.PAGE) page: Int,
        @Query(QueryConst.PAGE_SIZE) pageSize: Int = Constant.PER_PAGE
    ): Observable<Response>

    @GET("forecast.json")
    fun getWeather(
        @Query(QueryConst.KEY) key: String? = null,
        @Query(QueryConst.Q) q: String? = null,
        @Query(QueryConst.DAYS) days: String? = null,
        @Query(QueryConst.AQI) aqi: String? = null,
        @Query(QueryConst.ALERTS) alerts: String? = null
    ): Observable<Weather>
}