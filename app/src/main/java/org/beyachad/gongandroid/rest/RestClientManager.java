package org.beyachad.gongandroid.rest;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClientManager {
    private static GongsRestService gongsRestService;

    public static GongsRestService getMovieServiceInstance() {
        if (RestClientManager.gongsRestService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(GongsRestService.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(RestClientManager.provideOkHttpClient())
                    .build();

            RestClientManager.gongsRestService = retrofit.create(GongsRestService.class);
        }

        return RestClientManager.gongsRestService;
    }

    private static OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(30, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(30, TimeUnit.SECONDS);
        okHttpClientBuilder.writeTimeout(30, TimeUnit.SECONDS);

        // okHttpClientBuilder.addInterceptor(new TokenInterceptor());
        // okHttpClientBuilder.authenticator(new TokenRenewInterceptor());

        return okHttpClientBuilder.build();
    }
}
