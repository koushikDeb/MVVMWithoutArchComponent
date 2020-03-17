package com.example.mvvmwithoutarch.login;

import com.example.mvvmwithoutarch.CommonActivityState;

import com.example.mvvmwithoutarch.commonOvserver;
public class LoginViewModel implements  LoginInteractor.OnLoginFinishedListener{

    public commonOvserver commonOvserver =new commonOvserver();


    public void setLoginClicked(String uname, String pass) {
        commonOvserver.setState(CommonActivityState.Loading,true);
        new LoginInteractor().login(uname,pass, this);

    }

    @Override
    public void onUsernameError() {
        commonOvserver.setState(CommonActivityState.WrongUserName,true);
    }

    @Override
    public void onPasswordError() {
       commonOvserver.setState(CommonActivityState.WrongPassword,true);
    }

    @Override
    public void onSuccess() {
      commonOvserver.setState(CommonActivityState.Success,true);
    }
}
