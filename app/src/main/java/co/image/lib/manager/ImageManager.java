package co.image.lib.manager;

import android.support.annotation.NonNull;

import java.util.HashMap;

/**
 * We can handle caching here
 */
public class ImageManager {

    private static ImageManager INSTANCE;

    private HashMap<String, ImageLoader> reference = new HashMap<String, ImageLoader>();

    private static final Object object = new Object();

    private ImageManager() {
    }

    public static ImageManager get() {
        if (INSTANCE == null) {
            synchronized (object) {
                if (INSTANCE == null) {
                    INSTANCE = new ImageManager();
                }
            }
        }
        return INSTANCE;
    }

    public ImageLoader load(@NonNull String url) {
        if (reference.containsKey(url)) {
            return reference.get(url);
        } else {
            ImageLoader loader = new ImageLoader(url);
            reference.put(url, loader);
            return loader;
        }
    }

}
