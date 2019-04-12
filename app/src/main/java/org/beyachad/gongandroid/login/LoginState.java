package org.beyachad.gongandroid.login;

public class LoginState {
    public boolean isLogedIn = false;
    public boolean isInLogInProcess = false;
    public String token ;

    public boolean isLogedIn() {
        return isLogedIn;
    }

    public void setLogedIn(boolean logedIn) {
        isLogedIn = logedIn;
    }

    public boolean isInLogInProcess() {
        return isInLogInProcess;
    }

    public void setInLogInProcess(boolean inLogInProcess) {
        isInLogInProcess = inLogInProcess;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
