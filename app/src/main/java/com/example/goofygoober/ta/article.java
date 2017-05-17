package com.example.goofygoober.ta;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class article extends AppCompatActivity {

    String[] values;
    ListView listView;

    String urlDataRss ;
    ArrayList<ItemData> valuesItemData;
    ItemsAdapter itemsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article);

        Intent intent = getIntent() ;
        urlDataRss = intent.getStringExtra("dataUrl") ;

        values = new String[]{"Smartphone","Laptop","Kamera","Tablet","Jam tangan"};
        listView = (ListView) findViewById(R.id.listBerita);

        valuesItemData = new ArrayList<ItemData>();

        ItemData item1 = new ItemData();
        item1.itemTitle = "Loading...";
        item1.itemDesc = "Jual smartphone kualitas";
        //item1.itemImgId = R.mipmap.ic_launcher;
        item1.itemImg = "https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Smartphone_icon_-_Noun_Project_283536.svg/200px-Smartphone_icon_-_Noun_Project_283536.svg.png";

        valuesItemData.add(item1);

        itemsAdapter = new ItemsAdapter(this, valuesItemData);
        listView.setAdapter(itemsAdapter);

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                //android.R.layout.simple_list_item_1, // ini pengaturan bawaan dari adroid studio
//                R.layout.list_item, //kalo yang ini custom sendiri
//                R.id.textJudul, values); //text1 merupakan id dari text yang udah diatur warna, dll didalam layout list_item
//
//        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {
                ItemData item = (ItemData) listView.getItemAtPosition(position);
                Intent intent = new Intent(article.this, DetailBeritaActivity.class);
                String dataUrl = null; //baru
                intent.putExtra("item", item);
                startActivity(intent);
                //Toast.makeText(getApplicationContext(), item.itemTitle, Toast.LENGTH_SHORT).show();


            }
        });

        HttpDownloadTask htask = new HttpDownloadTask();
        htask.execute(urlDataRss);
    }

    private class  HttpDownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
          //  String urlstr ="http://feeds.feedburner.com/avma/fOlV";
            String urlstr ="http://petcarepapb.blogspot.com/feeds/posts/default?alt=rss";
            String resultText = "";

            try{
                URL url = new URL(urlstr);
                //untuk membuka akses url butuh connection dengan menggunakan HttpURLConnection
                HttpURLConnection conection = (HttpURLConnection) url.openConnection();
                conection.setRequestMethod("GET"); //ambil data cukup GET pake POST kalo ngga cuma ambil data
                conection.connect();
                int response = conection.getResponseCode();//kalo berhasil connect codenya 200 itu yang bagus tp tergantung FPI (lihat code response code web)
                Log.d("DEBUG1", "Reponse Code: " + response);
                if(response == 200){

                    BufferedReader r = new BufferedReader(new InputStreamReader(conection.getInputStream()));
                    //penampung string performa lebih bagus dan lebih cepat
                    StringBuilder resultTextBuilder = new StringBuilder(); // performa lebih nbaik dr pd String, mrpkn class sebelum String
                    String line;

                    while ((line=r.readLine()) != null){
                        resultTextBuilder.append(line);
                    }
                    Log.d("DEBUG1", "Result Text: " + resultTextBuilder.toString());
                    resultText = resultTextBuilder.toString();

                }else{
                    Log.e("ERROR", "Response Fail"); // ketika gak berhasil connect maka akan muncul pesan ini
                }
            } catch (MalformedURLException e) {
                Log.e("ERROR", "URL ada masalah dia gak valid");
            } catch (IOException e) {
                Log.e("ERROR", "Open Connection Gagal"); //ketika manifest bermasalah belum ada ijin koneksi
                //pastikan dlm catch pake Log.e untuk mengetahui bagian mana yang error jangan cuma print
                //Log berguna untuk melihat prosesnya sampai mana gitu yg berjalan
            }

            return resultText;
        }


        private ArrayList<ItemData> parseXML(String text){
            ArrayList<ItemData> arrResult = new ArrayList<ItemData>();
            try {
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(true);
                XmlPullParser xpp = factory.newPullParser();
                xpp.setInput(new StringReader(text));
                ItemData data = null;
                String currentTag = ""; //Variabel Checker pembacaan xml
                int eventType = xpp.getEventType();

                while ( eventType != XmlPullParser.END_DOCUMENT){ //Pembacaan pembaris didalam xml
                    if(eventType == XmlPullParser.START_DOCUMENT){

                    } else if (eventType == XmlPullParser.START_TAG){
                        if(xpp.getName().equals("item")){
                            data = new ItemData();
                            currentTag = "item";
                        }else if (xpp.getName().equals("title")){
                            currentTag = "title";
                        } else if (xpp.getName().equals("link")){
                            currentTag = "link";
                        } else if (xpp.getName().equals("description")) {
                            currentTag = "description";
                        } else if (xpp.getName().equals("pubDate")) {
                            currentTag = "pubDate";
                        } else if (xpp.getName().equals("enclosure")) {
                            currentTag = "enclosure";
                            data.itemImg = xpp.getAttributeValue(null, "url");
                        } else {
                            currentTag="";
                        }
                    } else if (eventType == XmlPullParser.TEXT){
                        String content = xpp.getText();
                        content = content.trim();
                        if(data != null && content.length() > 0){
                            switch (currentTag){
                                case "title":
                                    data.itemTitle = content;
                                    break;
                                case "link":
                                    data.itemLink = content;
                                    break;
                                case "description":
                                    data.itemDesc = content;
                                    break;
                                case "pubDate":
                                    data.itemDate = content;
                                    break;
                            }
                        }

                    }else if (eventType == XmlPullParser.END_TAG){
                        if(xpp.getName().equals("item")){
                            arrResult.add(data);
                        }
                    }

                    eventType = xpp.next();
                }
            } catch (XmlPullParserException e) {
                Log.e("ERROR XML", "Error pull parser");
            } catch (IOException e) {
                Log.e("ERROR XML", "Error next data di xml");
            }
            return arrResult;
        }
        @Override
        protected void onPostExecute(String s) {
            if(s != ""){
                ArrayList<ItemData> arrItemData = parseXML(s);
                Log.d("Result", "Value Berhasil");

                valuesItemData.clear();
                valuesItemData.addAll(arrItemData);
                itemsAdapter.notifyDataSetChanged();
            }

            super.onPostExecute(s);
        }
//        final Intent intent = new Intent(this, DetailBeritaActivity.class);
//        list
////        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////            @Override
////        public void onItemClick(AdapterView<?> adapterView, View view,
////                                int position, long id) {
//            int item = position;
//
//            String dataUrl = null;
//            switch (item){
//                case 0 :
//                    dataUrl = "http://www.voaindonesia.com/api/zmgqoe$moi" ;
//                    break;
//                case 1 :
//                    dataUrl = "http://www.voaindonesia.com/api/zvjqieoyop";
//                    break;
//                case 2 :
//                    dataUrl = "http://www.voaindonesia.com/api/ztgq_ei_ov";
//                    break;
//                case 3 :
//                    dataUrl = "http://www.voaindonesia.com/api/zggqre__oq";
//                    break;
//                case 4 :
//                    dataUrl = "http://www.voaindonesia.com/api/z-jqtevyoq";
//                    break;
//            }
//            intent.putExtra("dataUrl",dataUrl) ;
//            startActivity(intent);
//        }
//    });

    }

    //public class DetailBeritaActivity extends AppCompatActivity {
    //
    //    @Override
    //    protected void onCreate(Bundle savedInstanceState) {
    //        super.onCreate(savedInstanceState);
    //        setContentView(R.layout.activity_detail_berita);
    //    }
    //}
    public static class DetailBeritaActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.detail_berita);

            Intent i = getIntent();
            ItemData item = (ItemData) i.getSerializableExtra("item");

            WebView webView = (WebView)findViewById(R.id.webView);

            //webView.loadData(item.itemDesc, "text/html", "UTF-8");

            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl(item.itemLink);
        }
    }
}
