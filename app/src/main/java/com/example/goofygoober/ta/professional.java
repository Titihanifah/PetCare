package com.example.goofygoober.ta;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class professional extends AppCompatActivity {
    Spinner breeder,location;
    String[] list1 ={"Golden Top Kennel\nJakarta", "Manggala Cattery\nJakarta" , "Anastasia Kennel\nBandung", "Von Machine Kennel\nBandung", "Sweet Robo Cattery\nYogyakarta", "Descola Cat Lover\nYogyakarta", "Gen X cattery\nSurabaya", "Surabayapets Pet Salon And Care\nSurabaya"};
    String[] list2 = {"Jakarta Vet Cempaka Putih\nJakarta", "Ragunan Animal Hospital\nJakarta", "UPT. Klinik Hewan\nBandung", "Klinik Hewan Happiness - Drh Alexander Saba\nBandung" , "Klinik Hewan Kayu Manis\nYogyakarta" , "Sunshine Pet Vet\nYogyakarta", "Klinik Hewan (Pet Clinic Intimedipet)\nSurabaya", "Klinik Hewan Zoo\nSurabaya"};
    ListView listView;
    private ArrayList<String> data = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.professional);

        breeder = (Spinner) findViewById(R.id.isiTypeProf);
        //location = (Spinner) findViewById(R.id.isiLocation);
        listView = (ListView) findViewById(R.id.listView1);
        //listView.setAdapter(new MylistadapterBJakarta(professional.this, R.layout.tampung_pro, data));

        //generateListContent();

        //spinner typeprofessional
        final ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(professional.this, R.array.typepro, android.R.layout.simple_dropdown_item_1line);
        adapter7.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        breeder.setAdapter(adapter7);

        final ArrayAdapter adapter1 = new ArrayAdapter(professional.this, R.layout.coba, list1);
        final ArrayAdapter adapter2 = new ArrayAdapter(professional.this, R.layout.coba, list2);

        //lokasi lokasi
//        final ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(professional.this, R.array.location, android.R.layout.simple_dropdown_item_1line);
//        adapter8.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        //lokasi berdasarkan breeder
//        final ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(professional.this, R.array.lokasibreeder, android.R.layout.simple_dropdown_item_1line);
//        adapter9.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);



        breeder.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (breeder.getSelectedItem().equals("Breeder")){
                    listView.setAdapter(adapter1);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String get = String.valueOf(position);
                            if (get == "0"){
                                Uri gmmIntentUri = Uri.parse("geo:0,0?q=JL . Pancoran Buntu 2, No. 19, South Jakarta, RT.2/RW.2, Pancoran, South Jakarta City, Jakarta 12780");
                                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                mapIntent.setPackage("com.google.android.apps.maps");
                                startActivity(mapIntent);
                            } else if (get == "1") {
                                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Jalan Kayu Manis Barat, RT.11/RW.5, RT.11/RW.5, Kayu Manis, Matraman, East Jakarta City, Jakarta 13130");
                                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                mapIntent.setPackage("com.google.android.apps.maps");
                                startActivity(mapIntent);
                            } else if (get == "2") {
                                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Jl. Sepak Bola No.6, Sukamiskin, Arcamanik, Kota Bandung, Jawa Barat 40293");
                                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                mapIntent.setPackage("com.google.android.apps.maps");
                                startActivity(mapIntent);
                            } else if (get == "3") {
                                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Jl. Sumber Hurip No.26-7, Babakan Ciparay, Kota Bandung, Jawa Barat, Jl. Sumber Hurip Blok 26 No.8, Babakan Ciparay, Kota Bandung, Jawa Barat 40223");
                                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                mapIntent.setPackage("com.google.android.apps.maps");
                                startActivity(mapIntent);
                            } else if (get == "4") {
                                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Jl. Ngelaren Sari, Condongcatur, Kec. Depok, Kabupaten Sleman, Daerah Istimewa Yogyakarta 55281");
                                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                mapIntent.setPackage("com.google.android.apps.maps");
                                startActivity(mapIntent);
                            } else if (get == "5") {
                                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Jl. Perumnas No.40 B, Caturtunggal, Kec. Depok, Kabupaten Sleman, Daerah Istimewa Yogyakarta 55281");
                                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                mapIntent.setPackage("com.google.android.apps.maps");
                                startActivity(mapIntent);
                            } else if (get == "6") {
                                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Dukuh Kupang Barat I/158, Surabaya, Dukuh Kupang, Dukuh Pakis, Surabaya City, East Java 60189");
                                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                mapIntent.setPackage("com.google.android.apps.maps");
                                startActivity(mapIntent);
                            } else {
                                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Jl. Semolowaru Elok Blk. V No.11, Semolowaru, Sukolilo, Kota SBY, Jawa Timur 60119");
                                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                mapIntent.setPackage("com.google.android.apps.maps");
                                startActivity(mapIntent);
                            }
                        }
                    });
                } else {
                    listView.setAdapter(adapter2);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String get = String.valueOf(position);
                            if (get == "0") {
                                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Jl. Cempaka Putih Tengah XXX No.5, RT.9/RW.7, Cemp. Putih Tim., Cemp. Putih, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta 10510, Indonesia");
                                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                mapIntent.setPackage("com.google.android.apps.maps");
                                startActivity(mapIntent);
                            } else if (get == "1") {
                                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Jl. Harsono RM No. 28, RT. 9 / RW. 4, Ps.Minggu, Ragunan, RT.9/RW.4, Ragunan, Ps. Minggu, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12560, Indonesia");
                                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                mapIntent.setPackage("com.google.android.apps.maps");
                                startActivity(mapIntent);
                            } else if (get == "2") {
                                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Jl. Pelindung Hewan No. 44, Kec. Astana Anyar, Pelindung Hewan, Astanaanyar, Kota Bandung, Jawa Barat 40243, Indonesia");
                                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                mapIntent.setPackage("com.google.android.apps.maps");
                                startActivity(mapIntent);
                            } else if (get == "3") {
                                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Jl. Matra Persada No.10, Pasirkaliki, Cimahi Utara, Kota Bandung, Jawa Barat 40514, Indonesia");
                                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                mapIntent.setPackage("com.google.android.apps.maps");
                                startActivity(mapIntent);
                            } else if (get == "4") {
                                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Jl. Gambiran No.52, Pandeyan, Umbulharjo, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55161, Indonesia");
                                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                mapIntent.setPackage("com.google.android.apps.maps");
                                startActivity(mapIntent);
                            } else if (get == "5") {
                                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Jl. Monjali No.25, Sinduadi, Mlati, Kabupaten Sleman, Daerah Istimewa Yogyakarta 55241, Indonesia");
                                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                mapIntent.setPackage("com.google.android.apps.maps");
                                startActivity(mapIntent);
                            } else if (get == "6") {
                                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Jl. Barata Jaya II No.52, Baratajaya, Gubeng, Kota SBY, Jawa Timur 60284, Indonesia");
                                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                mapIntent.setPackage("com.google.android.apps.maps");
                                startActivity(mapIntent);
                            } else {
                                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Jl. Tenggilis Tim. II No.51, Tenggilis Mejoyo, Kota SBY, Jawa Timur 60292, Indonesia");
                                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                mapIntent.setPackage("com.google.android.apps.maps");
                                startActivity(mapIntent);
                            }
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
