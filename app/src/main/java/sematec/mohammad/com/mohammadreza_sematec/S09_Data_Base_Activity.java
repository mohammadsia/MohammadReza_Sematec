package sematec.mohammad.com.mohammadreza_sematec;


import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import sematec.mohammad.com.mohammadreza_sematec.Application.App;
import sematec.mohammad.com.mohammadreza_sematec.Pray_Pack.PrayPack;

public class S09_Data_Base_Activity extends AppCompatActivity implements View.OnClickListener {

    Button btn_getPray;
    TextView txt_Pray_Data, txt_City_Name;
    EditText edt_Pray;
    private String Api_Url, Api_UrlCity_Name, Pry_Fajr, Pry_Sunrise, Pry_Dhuhr, Pry_Asr, Pry_Sunset, Pry_Maghrib, Pry_Isha, Pry_Imsak, Pry_Midnight;

    S09_DB s09_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s09_data_base_activity);


        init();

    }

    private void init() {

        btn_getPray = findViewById(R.id.btn_Pray);
        txt_Pray_Data = findViewById(R.id.txt_Pray);
        edt_Pray = findViewById(R.id.edit_City);
        txt_City_Name = findViewById(R.id.txt_City_Name);


        btn_getPray.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v == btn_getPray) {


            GsonObject();


//            txt_Pray_Data.setText("Fajr :" + Pry_Fajr);
//            txt_Pray_Data.append("\n\n" + "Sunrise :" + Pry_Sunrise);
//            txt_Pray_Data.append("\n\n" + "Dhuhr : " + Pry_Dhuhr);
//            txt_Pray_Data.append("\n\n" + "Asr :" + Pry_Asr);
//            txt_Pray_Data.append("\n\n" + "Sunset :" + Pry_Sunset);
//            txt_Pray_Data.append("\n\n" + "Maghrib :" + Pry_Maghrib);
//            txt_Pray_Data.append("\n\n" + "Isha :" + Pry_Isha);
//            txt_Pray_Data.append("\n\n" + "Imsak :" + Pry_Imsak);
//            txt_Pray_Data.append("\n\n" + "Midnight :" + Pry_Midnight);
        }
    }

    private void GsonObject() {

        Api_UrlCity_Name = edt_Pray.getText().toString().toLowerCase().trim();
        if (Api_UrlCity_Name.length() < 3) {
            edt_Pray.setText("");
            App.T_Long("Please Select A City");
            return;
        }
        txt_City_Name.setText("City :  " + Api_UrlCity_Name);

        Api_Url = "https://api.aladhan.com/v1/timingsByCity?city=" + Api_UrlCity_Name + "&country=Iran&method=8";


        AsyncHttpClient client = new AsyncHttpClient();

        client.get(Api_Url, new JsonHttpResponseHandler() {


                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                        super.onSuccess(statusCode, headers, response);

                        Gson gson = new Gson();
                        PrayPack p = gson.fromJson(response.toString(), PrayPack.class);


                        Pry_Fajr = p.getData().getTimings().getFajr();
                        Pry_Sunrise = p.getData().getTimings().getSunrise();
                        Pry_Dhuhr = p.getData().getTimings().getDhuhr();
                        Pry_Asr = p.getData().getTimings().getAsr();
                        Pry_Sunset = p.getData().getTimings().getSunset();
                        Pry_Maghrib = p.getData().getTimings().getMaghrib();
                        Pry_Isha = p.getData().getTimings().getIsha();
                        Pry_Imsak = p.getData().getTimings().getImsak();
                        Pry_Midnight = p.getData().getTimings().getMidnight();
                        App.Log_I(Pry_Fajr);

                        try {


                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                s09_db.inserToTiming(Api_UrlCity_Name, Pry_Fajr, Pry_Sunrise, Pry_Dhuhr, Pry_Asr, Pry_Sunset, Pry_Maghrib
                                        , Pry_Isha, Pry_Imsak, Pry_Midnight);






                            }
                        }).start();
                        }catch (SQLException e){
                            App.Log_I(e.toString());
                        }
                        String me = s09_db.getPrayTime();
                        App.Log_I(s09_db.getPrayTime());
                        txt_Pray_Data.setText(me);

                    }


                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        super.onFailure(statusCode, headers, responseString, throwable);
                    }
                }


        );


    }


}
