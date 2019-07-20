package co.image.lib.manager;

import android.view.View;
import android.widget.ImageView;

import java.lang.ref.WeakReference;

import co.image.lib.network.DownloadImage;

/**
 * This will hold the URL and Image reference to individual request
 */
public class ImageLoader {

    private String imgUrl;

    private WeakReference<ImageView> imageViewWeakReference;

    public ImageLoader(String url) {
        this.imgUrl = url;
    }

    public void into(View view) throws Exception {
        if (view instanceof ImageView) {
            this.imageViewWeakReference = new WeakReference<ImageView>((ImageView) view);
            downloadAndUpdateImage();
        } else {
            throw new Exception("Invalid view");
        }
    }

    // Download image from Server
    private void downloadAndUpdateImage() {
        if (imageViewWeakReference != null) {
            new DownloadImage(imageViewWeakReference).execute(imgUrl);
        }
    }

}
