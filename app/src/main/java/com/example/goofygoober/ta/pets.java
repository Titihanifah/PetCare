package com.example.goofygoober.ta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import io.nlopez.smartadapters.SmartAdapter;

public class pets extends AppCompatActivity {
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pets);

        add = (Button) findViewById(R.id.btnAdd);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(pets.this, addpet.class);
                startActivity(a);
            }
        });

        ListView listView = (ListView) findViewById(R.id.list_pet);
        List<PetData> petDatas = PetData.listAll(PetData.class);
        SmartAdapter.items(petDatas).map(PetData.class, PetListView.class).into(listView);
    }
}
