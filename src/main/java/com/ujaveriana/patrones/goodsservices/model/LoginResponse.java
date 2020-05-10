package com.ujaveriana.patrones.goodsservices.model;

public class LoginResponse {

    private boolean validCredentials;
    private UserApp user;

    public boolean isValidCredentials() {
        return validCredentials;
    }

    public void setValidCredentials(boolean validCredentials) {
        this.validCredentials = validCredentials;
    }

    public UserApp getUser() {
        return user;
    }

    public void setUser(UserApp user) {
        this.user = user;
    }
}
