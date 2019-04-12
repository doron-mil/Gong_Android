package org.beyachad.gongandroid.rest;


import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder builder = original.newBuilder()
                .header("Authorization","Bearer:4345555");
        Log.i("Doron 2", "************ " + original.body().contentLength());
        //String.format("Bearer %s", jwtToken));

        Request request = builder.build();
        return chain.proceed(request);
    }
}
