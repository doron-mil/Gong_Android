package org.beyachad.gongandroid.rest;

import org.beyachad.gongandroid.model.BasicServerData;
import org.beyachad.gongandroid.model.LoginData;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GongsRestService {
    String BASE_URL = "http://10.100.102.4:8081";

    String LOGIN_QUERY = "/login";
    String GET_NEXTGONG_QUERY =  "/nextgong";

    String BASE_DATA_QUERY = "/data/";
    String GET_AREAS_DATA_QUERY = BASE_DATA_QUERY + "areas";

    @FormUrlEncoded
    @POST(GongsRestService.LOGIN_QUERY)
    Call<String> login(@Field("username") String username,
                       @Field("password") String password);

    @POST(GongsRestService.LOGIN_QUERY)
    Call<ResponseBody> login2(@Body LoginData loginData);

    @GET(GongsRestService.GET_NEXTGONG_QUERY)
    Call<BasicServerData> getNextGong();

    // @GET(GongsRestService.GET_AREAS_DATA_QUERY)
    // Call<VideosListResult> getAreas();

}
