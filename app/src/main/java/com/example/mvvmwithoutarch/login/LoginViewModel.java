package com.example.mvvmwithoutarch.login;

import com.example.mvvmwithoutarch.CommonActivityState;
import com.example.mvvmwithoutarch.commonOvserver;

public class LoginViewModel implements  LoginInteractor.OnLoginFinishedListener{

    public com.example.mvvmwithoutarch.commonOvserver commonOvserver =new commonOvserver();

    public void setLoginClicked(String uname, String pass) {
        commonOvserver.setState(CommonActivityState.Loading);
        new LoginInteractor().login(uname,pass,this);

    }

    @Override
    public void onUsernameError() {
        commonOvserver.setState(CommonActivityState.WrongUserName);
    }

    @Override
    public void onPasswordError() {
       commonOvserver.setState(CommonActivityState.WrongPassword);
    }

    @Override
    public void onSuccess() {
      commonOvserver.setState(CommonActivityState.Success);
    }
}
