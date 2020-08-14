package com.example.pictureinpicture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goPip(View view) {
        enterPictureInPictureMode();
    }

    /** What to do when in/out PIP mode **/
    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);

        TextView textView = findViewById(R.id.textView);
        Button pipButton = findViewById(R.id.pipButton);

        if(isInPictureInPictureMode) { /** Going into Picture-in-Picture mode **/
            pipButton.setVisibility(View.INVISIBLE);
            getSupportActionBar().hide(); //hide action bar
            textView.setText("Picture-in-Picture mode!");
        } else { /** Going out of Picture-in-Picture mode **/
            pipButton.setVisibility(View.VISIBLE);
            getSupportActionBar().show();
            textView.setText("Full screen mode");
        }
    }
}