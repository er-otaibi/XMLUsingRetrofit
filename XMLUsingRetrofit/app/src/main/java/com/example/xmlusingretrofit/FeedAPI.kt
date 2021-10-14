package com.example.xmlusingretrofit

import retrofit2.Call
import retrofit2.http.GET

interface FeedAPI {

    @get:GET("garden-grove/feed")
    val feed: Call<Feed?>?

    companion object {
        const val BASE_URL = "https://www.ocregister.com/location/california/orange-county/"
    }
}