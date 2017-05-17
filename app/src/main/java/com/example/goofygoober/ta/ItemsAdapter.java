package com.example.goofygoober.ta;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by titih on 17/05/2017.
 */

public class ItemsAdapter extends ArrayAdapter<ItemData> {
    private ArrayList<ItemData> values;
    private Context context;

    public ItemsAdapter(Context context, ArrayList<ItemData> values) {

        //super (context, R.layout.list_item,values);
        super(context, R.layout.list_item, values);
        this.context = context;
        this.values = values;
    }



    @NonNull
    public android.view.View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_item,parent, false);
        //pengesetan data dalam ArrayAdapter

        //mengambil layout(tampilan)
        TextView textJudul = (TextView)view.findViewById(R.id.textJudul);
        TextView textDesc = (TextView)view.findViewById(R.id.pubDate);
        ImageView imgView = (ImageView)view.findViewById(R.id.itemImg);

        //mengambil data
        textJudul.setText(values.get(position).itemTitle);
        textDesc.setText(values.get(position).itemDate);
        //imgView.setImageResource(values.get(position).itemImgId);

        ImageDownloader imgDownloader = new ImageDownloader(imgView); //imgView : kontainer gambar
        imgDownloader.execute(values.get(position).itemImg); //itemImg : string

        return view;
    }
    public class ImageDownloader extends AsyncTask<String, String, Bitmap> {

        ImageView imageDownl;

        public ImageDownloader(ImageView iv){ //ImageView untuk menampung gambar
            imageDownl = iv;
        }

        @Override
        protected void onPreExecute() {
            //status.setText("Downloading Image"); // ini ngga bisa ditulisin kalo class ini bukan merupakan sub class MainActivity

            super.onPreExecute();
        }

        @Override //Function untuk pengambilan gambar
        protected Bitmap doInBackground(String... strings) {
            URL url = null;
            Bitmap bmp = null;

            try {
                url = new URL(strings[0]); // pada awalnya merah krn biasanya saat memasukkan itu error biasanya shng perlu pake Try Catch
                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                //untuk menangkap ketika url yg dimasukkan salah
            } catch (MalformedURLException e) {
                System.out.println("URL Salah");
                //untuk menangkap ketika bmp salah (tdk ada gambar, koneksi jelek)
            } catch (IOException e) {
                System.out.println("Error Download");
            }


            return bmp;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if(bitmap != null){
                imageDownl.setImageBitmap(bitmap);
                // status.setText("Download Completed");
            }else{
                //status.setText("Download Failed");
            }

        }

        //untuk melihat proses2 atau function lain bisa ctrl+spasi -> "protected"
        //function onProgressUpdate : u/ menampilkan proses pendownloadan (berapa persen)
    }
}
