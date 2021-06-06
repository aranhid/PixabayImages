package com.aranhid.pixabayimages;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface PixabayApi {
    String KEY = "20630450-fc0bd6303079aeedf2b5eadd2";
    String API_URL = "https://pixabay.com/";

    @GET("/api")
    Call<Response> search(@Query("q") String q, @Query("key") String key, @Query("image_type") String image_type);

//    @GET("")
//    Call<Res> getImage (@Url String pictureUrl);
}
