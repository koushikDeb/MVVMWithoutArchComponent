package com.example.mvvmwithoutarch.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.mvvmwithoutarch.CommonActivityState;
import com.example.mvvmwithoutarch.R;
import com.example.mvvmwithoutarch.commonOvserver;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    MainAdapter adapter;
    ProgressBar progress;
    MainViewModel viewmodel=new MainViewModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv= findViewById(R.id.list);
        progress=findViewById(R.id.progress);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);


        viewmodel.commonOvserver.addObserver(new Observer() {
            @Override
            public void update(Observable observable, Object o) {
                if (!(Boolean) o) {
                    ArrayList<String> itemlist = (ArrayList) ((commonOvserver) observable).getState();
                    adapter = new MainAdapter(itemlist);
                    rv.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
                else
                {
                    progress.setVisibility(((commonOvserver)observable).getState() == CommonActivityState.Loading ? View.VISIBLE : View.INVISIBLE);
                }
            }
        });


    }

    public void addclicked(View view) {
    viewmodel.addclickedmodel();
    }
}
