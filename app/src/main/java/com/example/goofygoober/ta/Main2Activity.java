package com.example.goofygoober.ta;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Main2Activity extends AppCompatActivity {
    ImageView pets,pro,article;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        pets = (ImageView) findViewById(R.id.img1);
        pro = (ImageView) findViewById(R.id.img2);
        article = (ImageView) findViewById(R.id.img3);
        pets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, pets.class);
                startActivity(intent);
            }
        });
        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(Main2Activity.this, professional.class);
                startActivity(b);
            }
        });
        article.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Main2Activity.this, article.class);
                startActivity(a);
            }
        });
    }
}
