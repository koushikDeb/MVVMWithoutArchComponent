package com.example.mvvmwithoutarch.notes;

import com.example.mvvmwithoutarch.login.LoginInteractor;
import com.example.mvvmwithoutarch.commonOvserver;
import com.example.mvvmwithoutarch.CommonActivityState;

import java.util.ArrayList;

public class MainViewModel implements  NotesInteractor.notesListner{

    public commonOvserver commonOvserver =new commonOvserver();

    public void setLoginClicked(String imei) {
        commonOvserver.setState(CommonActivityState.Loading);
        new NotesInteractor().add(uname,pass,this);

    }


    @Override
    public void noteFetched(ArrayList<String> notes) {

    }

    @Override
    public void notefetchfail() {

    }

    @Override
    public void NoteadddedCallback() {

    }

    @Override
    public void loadingstatechanged() {

    }
}
