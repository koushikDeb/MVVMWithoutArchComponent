package com.example.mvvmwithoutarch.notes;

import java.util.ArrayList;

public class NotesInteractor {
    interface notesListner{
        void noteFetched(ArrayList<String> notes);
        void notefetchfail();
        void NoteadddedCallback();
        void loadingstatechanged();
    }

}
