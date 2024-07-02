package dev.tomco.class24b_and_8.Utilities;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import dev.tomco.class24b_and_8.R;

public class ImageLoader {
    private static Context context;
    private static volatile ImageLoader instance;

    private ImageLoader(Context context) {
        this.context = context;
    }

    public static ImageLoader getInstance() {
        return instance;
    }

    public static ImageLoader init(Context context){
        if (instance == null){
            synchronized (ImageLoader.class){
                if (instance == null){
                    instance = new ImageLoader(context);
                }
            }
        }
        return getInstance();
    }

    public void load (String source, ImageView imageView){
        Glide
                .with(context)
                .load(source)
                .placeholder(R.drawable.unavailable_photo)
                .centerInside()
                .into(imageView);
    }
    public void load (Drawable source, ImageView imageView){
        Glide
                .with(context)
                .load(source)
                .placeholder(R.drawable.unavailable_photo)
                .centerInside()
                .into(imageView);
    }

}
