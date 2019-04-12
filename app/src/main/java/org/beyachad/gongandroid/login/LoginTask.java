package org.beyachad.gongandroid.login;

import android.os.AsyncTask;
import android.util.Log;

import org.beyachad.gongandroid.R;
import org.beyachad.gongandroid.model.LoginData;
import org.beyachad.gongandroid.rest.RestClientManager;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Represents an asynchronous login/registration task used to authenticate
 * the user.
 */
public class LoginTask extends AsyncTask<Void, Void, Boolean> {
    private final String mEmail;
    private final String mPassword;

    LoginTask(String email, String password) {
        mEmail = email;
        mPassword = password;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        // TODO: attempt authentication against a network service.

        Log.i("Doron", mEmail + ":" + mPassword);
        Call<ResponseBody> login =
                RestClientManager.getMovieServiceInstance().login2(new LoginData(mEmail, mPassword));
        // Call<String> login =
        //         RestClientManager.getMovieServiceInstance().login(mEmail, mPassword);

        login.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ResponseBody result = response.body();
                if (result != null) {
                    try {
                        JSONObject jsonObject = new JSONObject(result.string());
                        String token = "aaa";
                        this.saveToken(token);
                        Log.e("Doron Login", ((JSONObject) jsonObject.get("data")).getString("token").toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    Log.i("Doron Login failed", "failed");
                }
            }

            private void saveToken(String aToken) {
                // SharedPreferences sharedPref =
                //         PreferenceManager.getDefaultSharedPreferences(context);
                // SharedPreferences.Editor editor = sharedPref.edit();
                // editor.putString("KEY_STRING","Android Academy is awesome!");
                // editor.putInt("KEY_INT",1);
                // editor.putFloat("KEY_FLOAT",1F);
                // editor.putBoolean("KEY_BOOLEAN",true);
                // editor.putLong("KEY_LONG",1L);
                // editor.putStringSet("KEY_SET",new ArraySet<String>());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.i("Doron Login onFailure", "failed");
                t.printStackTrace();
            }
        });
        // try {
        //     // Simulate network access.
        //     Thread.sleep(2000);
        // } catch (InterruptedException e) {
        //     return false;
        // }

        // for (String credential : DUMMY_CREDENTIALS) {
        //     String[] pieces = credential.split(":");
        //     if (pieces[0].equals(mEmail)) {
        //         // Account exists, return true if the password matches.
        //         return pieces[1].equals(mPassword);
        //     }
        // }

        // TODO: register the new account here.
        return true;
    }

    @Override
    protected void onPostExecute(final Boolean success) {
        // mAuthTask = null;
        // showProgress(false);
        //
        // if (success) {
        //     finish();
        // } else {
        //     mPasswordView.setError(getString(R.string.error_incorrect_password));
        //     mPasswordView.requestFocus();
        // }
    }

    @Override
    protected void onCancelled() {
        // mAuthTask = null;
        // showProgress(false);
    }
}
