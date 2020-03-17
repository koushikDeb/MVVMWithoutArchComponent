package com.example.mvvmwithoutarch.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mvvmwithoutarch.CommonActivityState;
import com.example.mvvmwithoutarch.R;
import com.example.mvvmwithoutarch.commonOvserver;
import com.example.mvvmwithoutarch.notes.MainActivity;

import java.util.Observable;
import java.util.Observer;

public class LoginActivity extends AppCompatActivity {

EditText username,password;
ProgressBar  progress;
LoginViewModel viewModel=new LoginViewModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        password=findViewById(R.id.password);
        username=findViewById(R.id.username);
        progress=findViewById(R.id.progress);

        viewModel.commonOvserver.addObserver(new Observer() {
            @Override
            public void update(Observable observable, Object o) {
                updateUI((commonOvserver)observable);
            }
        });


    }

    private void updateUI(commonOvserver observable) {//do progress & popup related stuff here
        progress.setVisibility(observable.getState() == CommonActivityState.Loading ? View.VISIBLE : View.INVISIBLE);
        if(observable.getState()== CommonActivityState.Success) {
            Toast.makeText(getApplicationContext(),"Successfully Loged in",Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, MainActivity.class));
        }else {
            password.setError(observable.getState() == CommonActivityState.WrongPassword ? "Wrong password" : null);
            username.setError(observable.getState() == CommonActivityState.WrongUserName ? "Wrong userName" :null);
            return;
        }
    }

    public void loginClicked(View view) {
        viewModel.setLoginClicked(username.getText().toString(),password.getText().toString());
    }
}
