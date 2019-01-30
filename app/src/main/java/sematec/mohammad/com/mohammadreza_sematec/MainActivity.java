package sematec.mohammad.com.mohammadreza_sematec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
public static final String TAG_LOG="TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG_LOG, "OnCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG_LOG, "OnCreate");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG_LOG, "OnStop");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG_LOG, "OnPause");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG_LOG, "OnDestroy");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG_LOG, "OnResume");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG_LOG, "OnRestart");

    }
}
