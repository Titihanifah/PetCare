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
    //    String[] list1 ={"Dota", "CS GO"};
//    String[] list2 = {"PES 2017","WARFRAME"};
    ListView listView;
    private ArrayList<String> data = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.professional);

        breeder = (Spinner) findViewById(R.id.isiTypeProf);
        location = (Spinner) findViewById(R.id.isiLocation);
        listView = (ListView) findViewById(R.id.listView1);
        //listView.setAdapter(new MylistadapterBJakarta(professional.this, R.layout.tampung_pro, data));

        generateListContent();

        //spinner typeprofessional
        final ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(professional.this, R.array.typepro, android.R.layout.simple_dropdown_item_1line);
        adapter7.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        breeder.setAdapter(adapter7);


        //lokasi lokasi
        final ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(professional.this, R.array.location, android.R.layout.simple_dropdown_item_1line);
        adapter8.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        //lokasi berdasarkan breeder
        final ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(professional.this, R.array.lokasibreeder, android.R.layout.simple_dropdown_item_1line);
        adapter9.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);


        //final ArrayAdapter adapter2 = new MylistadapterBJakarta(professional.this, R.layout.tampung_pro, data);
//        final ArrayAdapter adapter3 = new MylistadapterBBandung(professional.this, R.layout.tampung_pro, data);
//        final ArrayAdapter adapter4 = new MylistadapterBSurabaya(professional.this, R.layout.tampung_pro, data);
//        final ArrayAdapter adapter5 = new MylistadapterBYogyakarta(professional.this, R.layout.tampung_pro, data);
        //exception untuk pilihan berdasarkan breeder dan menampilkan jenis adapternya
        breeder.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (breeder.getSelectedItem().equals("Breeder")) {
                    //jika berdasarkan breed

                    location.setAdapter(adapter9);

                    if (breeder.getSelectedItem().equals("Breeder") && location.getSelectedItem().equals("Jakarta")){
                        location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                                listView.setAdapter(new MylistadapterBJakarta(professional.this, R.layout.tampung_pro, data));
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                    } else if (breeder.getSelectedItem().equals("Breeder") && location.getSelectedItem().equals("Bandung")){
                        location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                                listView.setAdapter(new MylistadapterBJakarta(professional.this, R.layout.tampung_pro, data));
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                    } else if (breeder.getSelectedItem().equals("Breeder") && location.getSelectedItem().equals("Yogyakarta")){
                        location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                                listView.setAdapter(new MylistadapterBJakarta(professional.this, R.layout.tampung_pro, data));
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                    } else {
                        location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                                listView.setAdapter(new MylistadapterBJakarta(professional.this, R.layout.tampung_pro, data));
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                    }





                } else {
                    //berdasarkan vet
                    location.setAdapter(adapter8);
//                    if (breeder.getSelectedItem().equals("Breeder") && location.getSelectedItem().equals("Yogyakarta")){
//                       location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                            @Override
//                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                                listView = (ListView) findViewById(R.id.listView1);
//                                listView.setAdapter(new MylistadapterBJakarta(professional.this, R.layout.tampung_pro, data));
//                            }
//
//                            @Override
//                            public void onNothingSelected(AdapterView<?> adapterView) {
//
//                          }
//                       });
//                   }
                }

            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




//        location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//                if (location.getSelectedItem().equals("Jakarta")){
//                    listView.setAdapter(adapter2);
//                } else if (location.getSelectedItem().equals("Bandung")){
//                    listView.setAdapter(adapter3);
//                } else if (location.getSelectedItem().equals("Surabaya")){
//                    listView.setAdapter(adapter4);
//                } else {
//                    listView.setAdapter(adapter5);
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

    }

    private void generateListContent() {
        for (int i = 0; i < 4; i++) {
            data.add("This is row number " + i);
        }
    }
  //Custom ListView breederjakarta
    private class MylistadapterBJakarta extends ArrayAdapter<String> {
        private int layout;

        public MylistadapterBJakarta(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<String> objects) {
            super(context, resource, objects);
            layout = resource;

        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder1 mainViewholder = null;
            if(convertView == null){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout, parent, false);
                final ViewHolder1 viewHolder1 = new ViewHolder1();
                viewHolder1.textView = (TextView) findViewById(R.id.textview);
                viewHolder1.btn = (Button) findViewById(R.id.btnGOOGLE);

                if (breeder.getSelectedItem().equals("Breeder") && location.getSelectedItem().equals("Jakarta")){
                    String text1 = String.valueOf(position);
                    if (text1 == "0"){
                        viewHolder1.textView.setText("Golden Top Kennel");
                    } else if (text1 == "1"){
                        viewHolder1.textView.setText("Manggala Cattery");
                    } else if (text1 == "2"){
                        viewHolder1.textView.setText("Kichi Kennel");
                    } else {
                        viewHolder1.textView.setText("Prabu Cattery");
                    }

                    viewHolder1.btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String get = String.valueOf(position);
                            if (get == "0"){
                                Intent i = new Intent(Intent.ACTION_VIEW);
                                i.setData(Uri.parse("geo:-6.240142, 106.843620"));

                                startActivity(i);

                            } else if (get == "1"){
                                Intent b = new Intent(Intent.ACTION_VIEW);
                                b.setData(Uri.parse("geo:-6.198197, 106.860359"));

                                startActivity(b);

                            } else if (get == "2"){
                                Intent c = new Intent(Intent.ACTION_VIEW);
                                c.setData(Uri.parse("geo:-6.214736, 106.720169"));

                                startActivity(c);

                            } else {
                                Intent x = new Intent(Intent.ACTION_VIEW);
                                x.setData(Uri.parse("geo:-6.280126, 106.865667"));

                                startActivity(x);

                            }
                        }
                    });
                }

                if (breeder.getSelectedItem().equals("Breeder") && location.getSelectedItem().equals("Bandung")){
                    String text1 = String.valueOf(position);
                    if (text1 == "0"){
                        viewHolder1.textView.setText("Anastasia Kennel");
                    } else if (text1 == "1"){
                        viewHolder1.textView.setText("Von Machine Kennel");
                    } else if (text1 == "2"){
                        viewHolder1.textView.setText("46Cats");
                    } else {
                        viewHolder1.textView.setText("Koperasi Peternakan Bandung");
                    }

                    viewHolder1.btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String get = String.valueOf(position);
                            if (get == "0"){
                                Intent i = new Intent(Intent.ACTION_VIEW);
                                i.setData(Uri.parse("geo:-6.914101, 107.673873"));

                                startActivity(i);
                            } else if (get == "1"){
                                Intent b = new Intent(Intent.ACTION_VIEW);
                                b.setData(Uri.parse("geo:-6.930319, 107.576856"));

                                startActivity(b);
                            } else if (get == "2"){
                                Intent c = new Intent(Intent.ACTION_VIEW);
                                c.setData(Uri.parse("geo:-6.940423, 107.586886"));

                                startActivity(c);
                            } else {
                                Intent x = new Intent(Intent.ACTION_VIEW);
                                x.setData(Uri.parse("geo:-7.171410, 107.571854"));

                                startActivity(x);
                            }
                        }
                    });
                }

                if (breeder.getSelectedItem().equals("Breeder") && location.getSelectedItem().equals("Yogyakarta")){
                    String text1 = String.valueOf(position);
                    if (text1 == "0"){
                        viewHolder1.textView.setText("Sweet Robo Cattery");
                    } else if (text1 == "1"){
                        viewHolder1.textView.setText("Descola Cat Lover");
                    } else if (text1 == "2"){
                        viewHolder1.textView.setText("Kayana Cattery");
                    } else {
                        viewHolder1.textView.setText("ONION Cattery");
                    }

                    viewHolder1.btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String get = String.valueOf(position);
                            if (get == "0"){
                                Intent i = new Intent(Intent.ACTION_VIEW);
                                i.setData(Uri.parse("geo:-7.764300, 110.403899"));

                                startActivity(i);
                            } else if (get == "1"){
                                Intent b = new Intent(Intent.ACTION_VIEW);
                                b.setData(Uri.parse("geo:-7.766470, 110.405616"));

                                startActivity(b);
                            } else if (get == "2"){
                                Intent c = new Intent(Intent.ACTION_VIEW);
                                c.setData(Uri.parse("geo:-7.808771, 110.349855"));

                                startActivity(c);
                            } else {
                                Intent x = new Intent(Intent.ACTION_VIEW);
                                x.setData(Uri.parse("geo:-7.790097, 110.388684"));

                                startActivity(x);
                            }
                        }
                    });
                }

                if (breeder.getSelectedItem().equals("Breeder") && location.getSelectedItem().equals("Surabaya")){
                    String text1 = String.valueOf(position);
                    if (text1 == "0"){
                        viewHolder1.textView.setText("Gen X cattery");
                    } else if (text1 == "1"){
                        viewHolder1.textView.setText("Surabayapets Pet Salon And Care");
                    } else if (text1 == "2"){
                        viewHolder1.textView.setText("Agro Fauna Kertosari. PT - Surabaya Office");
                    } else {
                        viewHolder1.textView.setText("Ar'raya Cattery ICA-FIFe Persian And Exotic Breeder");
                    }

                    viewHolder1.btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String get = String.valueOf(position);
                            if (get == "0"){
                                Intent i = new Intent(Intent.ACTION_VIEW);
                                i.setData(Uri.parse("geo:-7.277429, 112.707898"));

                                startActivity(i);
                            } else if (get == "1"){
                                Intent b = new Intent(Intent.ACTION_VIEW);
                                b.setData(Uri.parse("geo:-7.306290, 112.781712"));

                                startActivity(b);
                            } else if (get == "2"){
                                Intent c = new Intent(Intent.ACTION_VIEW);
                                c.setData(Uri.parse("geo:-7.228089, 112.731454"));

                                startActivity(c);
                            } else {
                                Intent x = new Intent(Intent.ACTION_VIEW);
                                x.setData(Uri.parse("geo:-7.235231, 112.632577"));

                                startActivity(x);
                            }
                        }
                    });
                }

                convertView.setTag(viewHolder1);
            } else {
                mainViewholder = (ViewHolder1) convertView.getTag();
                mainViewholder.textView.setText(getItem(position));
            }
         return convertView;
        }
    }
    public class ViewHolder1{
        TextView textView;
        Button btn;
    }
}
