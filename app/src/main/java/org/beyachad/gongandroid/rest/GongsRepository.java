package org.beyachad.gongandroid.rest;

import android.util.Log;

import org.beyachad.gongandroid.model.LoginData;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GongsRepository {
    public static void login(String aUser, String aPassword, final GongsListener aListener) {
        Call<ResponseBody> login =
                RestClientManager.getMovieServiceInstance().login2(new LoginData(aUser, aPassword));

        login.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ResponseBody result = response.body();
                if (result != null) {
                    try {
                        JSONObject jsonObject = new JSONObject(result.string());
                        String token = ((JSONObject) jsonObject.get("data")).getString("token").toString();
                        Log.e("Doron Login2", token);
                        aListener.onSuccess(token);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        aListener.onFailure(e);
                    } catch (IOException e) {
                        e.printStackTrace();
                        aListener.onFailure(e);
                    }

                } else {
                    Log.i("Doron Login failed", "failed");
                    aListener.onFailure(new Exception("Response Body is null"));
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.i("Doron Login onFailure", "failed");
                aListener.onFailure(new Exception("GongsRepository.login.onFailure", t));
                t.printStackTrace();
            }

        });
    }
}
