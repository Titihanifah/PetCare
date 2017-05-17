package com.example.goofygoober.ta;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import java.nio.ByteBuffer;

import io.nlopez.smartadapters.views.BindableFrameLayout;

/**
 * Created by Faldy on 18/05/2017.
 */

public class PetListView extends BindableFrameLayout<PetData> {
    TextView name;
    TextView breed;
    TextView age;
    ImageView picture;

    public PetListView(Context context) {
        super(context);
    }

    public PetListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PetListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public PetListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayoutId() {
        return R.layout.pet_item;
    }

    @Override
    public void bind(PetData petData) {
        name.setText(petData.getName());
        breed.setText(petData.getBreed());
        age.setText(petData.getDateOfBirth());

        Bitmap bitmap = BitmapFactory.decodeByteArray(petData.getImage(), 0, petData.getImage().length);
        picture.setImageBitmap(bitmap);
    }

    @Override
    public void onViewInflated() {
        super.onViewInflated();
        name = (TextView) this.findViewById(R.id.nama_pet);
        breed = (TextView) this.findViewById(R.id.date_of_birth);
        age = (TextView) this.findViewById(R.id.breed_pet);
        picture = (ImageView) this.findViewById(R.id.gambar_pet);
    }
}
