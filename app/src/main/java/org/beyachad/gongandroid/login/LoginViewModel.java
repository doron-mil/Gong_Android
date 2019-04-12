package org.beyachad.gongandroid.login;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import org.beyachad.gongandroid.rest.GongsListener;
import org.beyachad.gongandroid.rest.GongsRepository;

public class LoginViewModel extends ViewModel {
    private MutableLiveData<LoginState> viewState = new MutableLiveData<LoginState>();

    LiveData<LoginState> getViewState() {
        return viewState;
    }


    public void login(String aUser, String aPassword) {
        this.updateViewState(false,true,null);

        GongsRepository.login(aUser, aPassword, new GongsListener<String>() {
            @Override
            public void onSuccess(String aToken) {
                updateViewState(true,false,aToken);
            }

            @Override
            public void onFailure(Exception error) {

            }
        });
    }

    private void updateViewState(
            boolean aIsLogedIn,
            boolean aIsInLogInProcess,
            String aToken) {
        LoginState newLoginState = new LoginState();
        newLoginState.setLogedIn(aIsLogedIn);
        newLoginState.setInLogInProcess(aIsInLogInProcess);
        newLoginState.setToken(aToken);
        Log.e("Doron Login3", String.valueOf(aIsLogedIn));
        viewState.setValue(newLoginState);
    }

}
