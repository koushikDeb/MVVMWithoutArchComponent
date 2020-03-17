package com.example.mvvmwithoutarch;

import com.example.mvvmwithoutarch.CommonActivityState;

import java.util.ArrayList;
import java.util.Observable;

public class commonOvserver extends Observable {


  Object state;

    public void setState(Object state,boolean isActivityState) {
        this.state = state;
        setChanged();
        notifyObservers(isActivityState);

    }


    public Object getState() {
        return state;
    }
}
