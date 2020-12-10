package com.magic.androidcore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Presentation extends AppCompatActivity {

    Animation topAnim , bottonAnim;
    ImageView imagen;
    TextView  logo , slogan ;

    private static int Splash_Screen=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_presentation);

        //animation
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottonAnim= AnimationUtils.loadAnimation(this,R.anim.botton_animation);

        imagen = findViewById(R.id.imgPresentation);
        logo = findViewById(R.id.tvTitulo);
        slogan = findViewById(R.id.tvSlogan);

        imagen.setAnimation(topAnim);
        logo.setAnimation(bottonAnim);
        slogan.setAnimation(bottonAnim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent inten = new Intent(Presentation.this , MainActivity.class);
                startActivity(inten);
                finish();
            }
        }  ,Splash_Screen) ;

    }
}