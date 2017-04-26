package com.app.yasmina.medical.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.yasmina.medical.R;

public class WelcomeActivity extends AppCompatActivity {

    //private final Class<MenuActivity> GOTO_ACTIVITY = MenuActivity.class;
    private final Class<DrawerActivity> GOTO_ACTIVITY = DrawerActivity.class;

    /* public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    } */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        TextView txt = (TextView) findViewById(R.id.welcome_title);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Font-Bold.ttf");
        txt.setTypeface(font);

        startAnimations(4000);
    }

    private void startAnimations(final int pauseTime) {
        Animation anim;

        anim = startAlphaAnimations();
        startTranslateAnimations(anim, pauseTime);
    }

    private Animation startAlphaAnimations() {
        Animation anim;

        anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();

        return anim;
    }

    private void startTranslateAnimations(Animation anim, final int pauseTime) {
        Thread splashTread;
        RelativeLayout relativeLayout;
        TextView textView;

        relativeLayout = (RelativeLayout) findViewById(R.id.rel_lay);
        relativeLayout.clearAnimation();
        relativeLayout.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();

        textView = (TextView) findViewById(R.id.welcome_title);
        textView.clearAnimation();
        textView.startAnimation(anim);

        splashTread = new Thread() {

            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < pauseTime) {
                        sleep(100);
                        waited += 100;
                    }

                    Intent intent = new Intent(WelcomeActivity.this, GOTO_ACTIVITY);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    WelcomeActivity.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    WelcomeActivity.this.finish();
                }

            }
        };
        splashTread.start();
    }
}
