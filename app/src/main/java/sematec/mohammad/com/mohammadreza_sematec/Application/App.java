package sematec.mohammad.com.mohammadreza_sematec.Application;

import android.util.Log;
import android.widget.Toast;
public class App {

    public static final String  TAG = "log";


    public static void Log_I(String Message)
    {
        Log.d(TAG, Message);
    }

    public static void T_Short(String Meesage){

        Toast.makeText(Application.getContext(),Meesage ,Toast.LENGTH_SHORT ).show();

    }

    public static void T_Long(String Meesage){

        Toast.makeText(Application.getContext(),Meesage ,Toast.LENGTH_LONG ).show();

    }

}
