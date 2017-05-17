package com.example.goofygoober.ta;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.VoiceInteractor;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Calendar;

import static android.R.attr.data;

public class addpet extends AppCompatActivity {

    Spinner tipekucing,genderkucing,breed,isibath1,isibath2;
    Button pilih,cancel;
    //int RESULT_LOAD_IMAGE = 1;
    private static int RESULT_LOAD_IMAGE = 1;
    ImageView img;
    EditText dob;
    DatePickerDialog dpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addpet);

        tipekucing = (Spinner) findViewById(R.id.isiType);
        genderkucing = (Spinner) findViewById(R.id.isiGender);
        breed = (Spinner) findViewById(R.id.isiBreed);
        pilih = (Button) findViewById(R.id.btnpilihfoto);
        isibath1 = (Spinner) findViewById(R.id.isiBath1);
        isibath2 = (Spinner) findViewById(R.id.isiBath2);
        dob = (EditText) findViewById(R.id.isiDoB);
        cancel = (Button) findViewById(R.id.btnCancel);


        //balik lagi ke layout pets
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent out = new Intent(addpet.this, pets.class);
                startActivity(out);
            }
        });

        //method edit text date of birth show tanggal/calendar
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                dpd = new DatePickerDialog(addpet.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                dob.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                dpd.show();
            }
        });

        //dropdown tipe
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(addpet.this, R.array.tipe_kucing, android.R.layout.simple_dropdown_item_1line);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        tipekucing.setAdapter(adapter);

        //dropdown gender
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(addpet.this, R.array.gender_kucing, android.R.layout.simple_dropdown_item_1line);
        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        genderkucing.setAdapter(adapter2);


        //dropdown breed
        final ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(addpet.this, R.array.breed, android.R.layout.simple_dropdown_item_1line);
        adapter3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        final ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(addpet.this, R.array.breedanjing, android.R.layout.simple_dropdown_item_1line);
        adapter6.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        //exception cat and dog
        tipekucing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(tipekucing.getSelectedItem().equals("Dog")){
                   breed.setAdapter(adapter6);
               } else {
                   breed.setAdapter(adapter3);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        //dropdown isibath1
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(addpet.this, R.array.bath1, android.R.layout.simple_dropdown_item_1line);
        adapter4.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        isibath1.setAdapter(adapter4);

        //dropdown isibath2
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(addpet.this, R.array.bath2, android.R.layout.simple_dropdown_item_1line);
        adapter5.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        isibath2.setAdapter(adapter5);

        //pilih image dari gallery
        pilih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent();
//                intent.setType("image/*");
//                intent.setAction(Intent.ACTION_GET_CONTENT);
                Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });
    }

    //nyimpen gambar yang udah ke select ke imageview
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView img = (ImageView) findViewById(R.id.kucing);
            Bitmap bmp = null;
            try {
                bmp = getBitmapFromUri(selectedImage);

            } catch (IOException e){
                e.printStackTrace();
            }
            img.setImageBitmap(bmp);
        }

        }
        //get bitmap buat set ke imageview
    private Bitmap getBitmapFromUri(Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor =
                getContentResolver().openFileDescriptor(uri, "r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();
        return image;
    }

}


