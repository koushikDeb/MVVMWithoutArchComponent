package com.example.mvvmwithoutarch.notes;

import android.os.CountDownTimer;

import java.util.ArrayList;

public class NotesInteractor {


    interface notesListner {
        void noteFetched(ArrayList<String> notes);

        void notefetchfail();

        void NoteadddedCallback();

        void loadingstatechanged();
    }

    public void add(final notesListner mainViewModel, final ArrayList<String> notes) {
        CountDownTimer cu = new CountDownTimer(2000, 500) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                notes.add("item added:: " + (notes.size() + 1));
                mainViewModel.noteFetched(notes);
            }
        };
        cu.start();


    }


}
