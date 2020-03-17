package com.example.mvvmwithoutarch.login;

import android.os.CountDownTimer;


public class LoginInteractor {
    public interface OnLoginFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onSuccess();
    }

    public void login(final String uname, final String pass, final OnLoginFinishedListener listner) {
        CountDownTimer cn = new CountDownTimer(2000, 500) {
            @Override
            public void onTick(long l) {
            }

            @Override
            public void onFinish() {
                if (uname.equals("")) {
                    listner.onUsernameError();


                } else if (pass.equals("")) {
                    listner.onPasswordError();

                } else {
                    listner.onSuccess();

                }
            }
        };
        cn.start();
    }

}
