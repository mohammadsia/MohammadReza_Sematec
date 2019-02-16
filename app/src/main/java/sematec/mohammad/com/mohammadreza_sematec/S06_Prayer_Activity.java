package sematec.mohammad.com.mohammadreza_sematec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import sematec.mohammad.com.mohammadreza_sematec.API.Api_Services;
import sematec.mohammad.com.mohammadreza_sematec.Application.App;
import sematec.mohammad.com.mohammadreza_sematec.Objects.Prayer_Objcet;

public class S06_Prayer_Activity extends AppCompatActivity implements Api_Services.onPrayerRecived, View.OnClickListener {

    TextView txt_Fajr,txt_Asr , txt_Sunrise, txt_Dhuhr, txt_SunSet, txt_Maghrib, txt_Isha, txt_Imsak, txt_MidNight;
    Button btn_Submit;
    EditText edt_City;
    Api_Services api_services;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s06__prayer_activity);


        init();
    }

    private void init() {
        api_services=new Api_Services();



        txt_Fajr = findViewById(R.id.txt_Fajr);
        txt_Sunrise = findViewById(R.id.txt_Sunrise);
        txt_SunSet = findViewById(R.id.txt_Sunset);
        txt_Dhuhr = findViewById(R.id.txt_Dhuhr);
        txt_Maghrib = findViewById(R.id.txt_Maghrib);
        txt_Imsak = findViewById(R.id.txt_Imsak);
        txt_Isha = findViewById(R.id.txt_Isha);
        txt_MidNight = findViewById(R.id.txt_Midnight);
        txt_Asr = findViewById(R.id.txt_Asr);



        edt_City = findViewById(R.id.edt_City);

        btn_Submit=findViewById(R.id.btn_Submit);
        btn_Submit.setOnClickListener(this);
    }


    @Override
    public void onRecieved(Prayer_Objcet prayer_objcet) {
        if (prayer_objcet!=null){

            txt_Fajr.setText("Fajr : "+ prayer_objcet.getFajr());
            txt_Asr.setText("Fajr : "+ prayer_objcet.getFajr());
            txt_Dhuhr.setText("Dhuhr : "+ prayer_objcet.getDhuhr());
            txt_Imsak.setText("Imsak : "+prayer_objcet.getImsak());
            txt_Isha.setText("Isha : "+(prayer_objcet.getIsha()));
            txt_Maghrib.setText("Maghrib ا: "+(prayer_objcet.getMaghrib()));
            txt_MidNight.setText("MidNight : "+(prayer_objcet.getMidnight()));
            txt_Sunrise.setText("SunRise : "+(prayer_objcet.getSunrise()));
            txt_SunSet.setText("Sunset : "+(prayer_objcet.getSunset()));
            txt_Asr.setText("Sunset : "+(prayer_objcet.getAsr()));
        }

        else {

            App.T_Long("خطا در دریافت اطلاعات");


        }

    }

    @Override
    public void onClick(View v) {
        api_services.getCurrentPrayer(S06_Prayer_Activity.this, edt_City.getText().toString().toLowerCase().trim());

    }
}
