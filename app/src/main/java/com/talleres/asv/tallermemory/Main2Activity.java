package com.talleres.asv.tallermemory;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.squareup.leakcanary.RefWatcher;

public class Main2Activity extends AppCompatActivity {


    private static ImageView imgGatoo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imgGatoo=(ImageView) findViewById(R.id.imggatoo);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Creating Memory Leak", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent vufoIntent = new Intent(Main2Activity.this, MainActivity.class);
                Main2Activity.this.startActivity(vufoIntent);
                Main2Activity.this.finish();
            }
        });
    }

    @Override public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = ExampleApplication.getRefWatcher(this);
        refWatcher.watch(this);
    }


}
