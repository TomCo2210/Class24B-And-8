package dev.tomco.class24b_and_8;

import android.app.Application;

import dev.tomco.class24b_and_8.Utilities.ImageLoader;
import dev.tomco.class24b_and_8.Utilities.MyBackgroundMusic;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoader.init(this);
        MyBackgroundMusic.init(this);
        MyBackgroundMusic.getInstance().setResourceId(R.raw.lifelike);
    }
}
