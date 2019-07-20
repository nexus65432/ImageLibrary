package co.image.lib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import co.image.lib.manager.ImageLoader;
import co.image.lib.manager.ImageManager;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    private static final String URL = "https://pbs.twimg.com/profile_images/630285593268752384/iD1MkFQ0.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image_view);

        try {
            ImageManager.get().load(URL).into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
