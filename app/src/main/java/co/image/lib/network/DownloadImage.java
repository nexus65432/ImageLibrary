package co.image.lib.network;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.lang.ref.WeakReference;


public class DownloadImage extends AsyncTask<String, Void, Bitmap> {

    private WeakReference<ImageView> mImageView;

    public DownloadImage(WeakReference<ImageView> view) {
        mImageView = view;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Bitmap doInBackground(String... URL) {

        String imageURL = URL[0];

        Bitmap bitmap = null;
        try {
            // Download Image from URL
            InputStream input = new java.net.URL(imageURL).openStream();
            // Decode Bitmap
            bitmap = BitmapFactory.decodeStream(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        // If the view in the list is not available then the view will be null.
        if (mImageView.get() != null) {
            // Set the bitmap into ImageView
            (mImageView.get()).setImageBitmap(result);
        }
    }
}