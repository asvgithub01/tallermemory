package com.talleres.asv.tallermemory;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import java.util.List;

/**
 * Created by nubor on 16/12/2015.
 */
public class ExampleApplication extends Application {

    public static ImageView imgGato;
    public static Bitmap bitmap;
    public static List<Bitmap> bitmapList;

    public static RefWatcher getRefWatcher(Context context) {
        ExampleApplication application = (ExampleApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    private RefWatcher refWatcher;

    @Override public void onCreate() {
        super.onCreate();
        refWatcher = LeakCanary.install(this);
    }
}
