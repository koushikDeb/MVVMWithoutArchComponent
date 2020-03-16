package com.example.mvvmwithoutarch;

import com.example.mvvmwithoutarch.CommonActivityState;

import java.util.ArrayList;
import java.util.Observable;

public class commonOvserver extends Observable {

    CommonActivityState state;
    ArrayList<String> notes=new ArrayList<>();

    public void setState(CommonActivityState state) {
        this.state = state;
        setChanged();
        notifyObservers(state);

    }

    public void setNotes(ArrayList<String> notes) {
        this.notes = notes;
        setChanged();
        notifyObservers(notes);
    }

    public ArrayList<String> getNotes() {
        return notes;
    }

    public CommonActivityState getState() {
        return state;
    }
}
