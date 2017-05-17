package com.example.goofygoober.ta;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
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
import android.util.Log;
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

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Calendar;

import static android.R.attr.data;

public class addpet extends AppCompatActivity {

    Spinner tipekucing,genderkucing,breed,isibath1,isibath2, isiVaccine1, isiVaccine2, isiFleas1, isiFleas2;
    Button pilih,cancel,btnNext;
    //int RESULT_LOAD_IMAGE = 1;
    private static int RESULT_LOAD_IMAGE = 1;
    ImageView img;
    EditText dob, isiName, color;
    DatePickerDialog dpd;
    private Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addpet);

        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.cat);

        tipekucing = (Spinner) findViewById(R.id.isiType);
        genderkucing = (Spinner) findViewById(R.id.isiGender);
        breed = (Spinner) findViewById(R.id.isiBreed);
        pilih = (Button) findViewById(R.id.btnpilihfoto);
        isibath1 = (Spinner) findViewById(R.id.isiBath1);
        isibath2 = (Spinner) findViewById(R.id.isiBath2);
        dob = (EditText) findViewById(R.id.isiDoB);
        isiName = (EditText) findViewById(R.id.isiName);
        color = (EditText) findViewById(R.id.isiColor);
        cancel = (Button) findViewById(R.id.btnCancel);
        isiVaccine1 = (Spinner) findViewById(R.id.isiVaccine1);
        isiVaccine2 = (Spinner) findViewById(R.id.isiVaccine2);
        isiFleas1 = (Spinner) findViewById(R.id.isiFleas1);
        isiFleas2 = (Spinner) findViewById(R.id.isiFleas2);
        btnNext = (Button) findViewById(R.id.btnNext);


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

        //dropdown isiVaccine1
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(addpet.this, R.array.bath1, android.R.layout.simple_dropdown_item_1line);
        adapter7.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        isiVaccine1.setAdapter(adapter4);

        //dropdown isiVaccine2
        ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(addpet.this, R.array.bath2, android.R.layout.simple_dropdown_item_1line);
        adapter8.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        isiVaccine2.setAdapter(adapter5);

        //dropdown isiFleas1
        ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(addpet.this, R.array.bath1, android.R.layout.simple_dropdown_item_1line);
        adapter9.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        isiFleas1.setAdapter(adapter4);

        //dropdown isiFleas2
        ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(addpet.this, R.array.bath2, android.R.layout.simple_dropdown_item_1line);
        adapter10.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        isiFleas2.setAdapter(adapter5);

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

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bmp.compress(Bitmap.CompressFormat.PNG, 90, stream);
                byte[] image_byte = stream.toByteArray();
                PetData petData = new PetData(isiName.getText().toString(), tipekucing.getSelectedItem().toString(), genderkucing.getSelectedItem().toString(), dob.getText().toString(), breed.getSelectedItem().toString(), color.getText().toString().toString(), Integer.parseInt(isibath1.getSelectedItem().toString()), Integer.parseInt(isiVaccine1.getSelectedItem().toString()), Integer.parseInt(isiFleas1.getSelectedItem().toString()), isibath2.getSelectedItem().toString(), isiVaccine2.getSelectedItem().toString(), isiFleas2.getSelectedItem().toString(), image_byte);
                petData.save();

                createAlarm(petData.getBath(), petData.getBathPer(), "Bath");
                createAlarm(petData.getVaccine(), petData.getVaccinePer(), "Vaccine");
                createAlarm(petData.getFleas(), petData.getFleasPer(), "Flea");

                finish();
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

    public void createAlarm(Integer intensity, String per, String type) {
        Integer multipler = 1;
        if(per.equals("Week")) {
            multipler = 7;
        } else if(per.equals("Month")) {
            multipler = 30;
        }

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent alarmIntent = new Intent(addpet.this, AlarmReceiver1.class); // AlarmReceiver1 = broadcast receiver
        PendingIntent pendingIntent = PendingIntent.getBroadcast(addpet.this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmIntent.setData((Uri.parse("custom://"+System.currentTimeMillis())));
        alarmManager.cancel(pendingIntent);

        Calendar alarmStartTime = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        alarmStartTime.set(Calendar.HOUR_OF_DAY, 8);
        alarmStartTime.set(Calendar.MINUTE, 00);
        alarmStartTime.set(Calendar.SECOND, 0);
        if (now.after(alarmStartTime)) {
            Log.d("Hey","Added a day");
            alarmStartTime.add(Calendar.DATE, 1);
        }

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, alarmStartTime.getTimeInMillis(), intensity * multipler * AlarmManager.INTERVAL_DAY, pendingIntent);
        Log.d("Alarm","Alarms set for everyday 8 am.");
    }

}


