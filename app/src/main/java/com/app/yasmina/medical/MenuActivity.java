package com.app.yasmina.medical;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Get access to our TextView
        TextView txt = (TextView) findViewById(R.id.textView);
        TextView txt2 = (TextView) findViewById(R.id.textView2);
        TextView txt3 = (TextView) findViewById(R.id.textView3);
        TextView txt4 = (TextView) findViewById(R.id.textView4);

        // Create the TypeFace from the TTF asset
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Font-Bold.ttf");
        Typeface font2 = Typeface.createFromAsset(getAssets(), "fonts/Font-Logo.ttf");
        Typeface font3 = Typeface.createFromAsset(getAssets(), "fonts/Font-Medium.ttf");
        Typeface font4 = Typeface.createFromAsset(getAssets(), "fonts/Font-Regular.ttf");

        // Assign the typeface to the view
        txt.setTypeface(font);
        txt2.setTypeface(font2);
        txt3.setTypeface(font3);
        txt4.setTypeface(font4);
    }
}
