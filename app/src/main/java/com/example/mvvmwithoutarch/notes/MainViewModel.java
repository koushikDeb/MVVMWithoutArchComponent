package com.example.mvvmwithoutarch.notes;

import com.example.mvvmwithoutarch.login.LoginInteractor;
import com.example.mvvmwithoutarch.commonOvserver;
import com.example.mvvmwithoutarch.CommonActivityState;

import java.util.ArrayList;

public class MainViewModel implements  NotesInteractor.notesListner{

    public commonOvserver commonOvserver =new commonOvserver();
    ArrayList<String> notes=new ArrayList();
    public void addclickedmodel() {
        commonOvserver.setState(CommonActivityState.Loading,true);
        new NotesInteractor().add(this,notes);
    }

    @Override
    public void noteFetched(ArrayList<String> notes) {
        this.notes=notes;
        commonOvserver.setState(CommonActivityState.Success,true);
        commonOvserver.setState(notes,false);
    }

    @Override
    public void notefetchfail() {
        commonOvserver.setState(CommonActivityState.FAILED,true);
    }

    @Override
    public void NoteadddedCallback() {

    }

    @Override
    public void loadingstatechanged() {

    }
}
