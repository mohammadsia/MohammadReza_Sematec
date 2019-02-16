package sematec.mohammad.com.mohammadreza_sematec.API;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

import sematec.mohammad.com.mohammadreza_sematec.Application.App;
import sematec.mohammad.com.mohammadreza_sematec.Application.Application;
import sematec.mohammad.com.mohammadreza_sematec.Objects.Prayer_Objcet;



public class Api_Services {


    public void getCurrentPrayer(final onPrayerRecived onprayerRecived, String cityName){
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET,
                "https://api.aladhan.com/v1/timingsByCity?city="+cityName+"&country=Iran&method=8",
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                App.Log_I(response.toString());
                onprayerRecived.onRecieved(parseResponseToPrayerInfo(response));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                onprayerRecived.onRecieved(null);
            }
        });

        request.setRetryPolicy(new DefaultRetryPolicy(10000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue requestQueue= Volley.newRequestQueue(Application.getContext());
        requestQueue.add(request);
    }


    private Prayer_Objcet parseResponseToPrayerInfo(JSONObject response){
        Prayer_Objcet prayer_objcet=new Prayer_Objcet();
        try {



            JSONObject prayer =response.getJSONObject("timings");



            prayer_objcet.setFajr(prayer.getString("Fajr"));


            prayer_objcet.setSunrise(prayer.getString("Sunrise"));


            prayer_objcet.setDhuhr(prayer.getString("Dhuhr"));


            prayer_objcet.setAsr(prayer.getString("Asr"));


            prayer_objcet.setSunset(prayer.getString("Sunset"));


            prayer_objcet.setMaghrib(prayer.getString("Maghrib"));


            prayer_objcet.setIsha(prayer.getString("Isha"));



            prayer_objcet.setImsak(prayer.getString("Imsak"));



            prayer_objcet.setMidnight(prayer.getString("midnight"));





            return prayer_objcet;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }


    public interface onPrayerRecived {
        void onRecieved(Prayer_Objcet prayer_objcet);
    }
}
