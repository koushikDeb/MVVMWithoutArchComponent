package com.example.mvvmwithoutarch.login;

import android.os.CountDownTimer;

import com.example.mvvmwithoutarch.CommonActivityState;

public class LoginInteractor {
    public interface OnLoginFinishedListener {
        void onUsernameError();
        void onPasswordError();
        void onSuccess();
    }
    public void login(final String uname, final String pass, final LoginViewModel loginViewModel)
    {
        CountDownTimer cn = new CountDownTimer(2000,500) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                if(uname.equals(""))
                {
                    loginViewModel.commonOvserver.setState(CommonActivityState.WrongUserName);

                }
                else if(pass.equals(""))
                {
                    loginViewModel.commonOvserver.setState(CommonActivityState.WrongPassword);
                }
                else
                {
                    loginViewModel.commonOvserver.setState(CommonActivityState.Success);
                }
            }
        };
        cn.start();
    }

}
