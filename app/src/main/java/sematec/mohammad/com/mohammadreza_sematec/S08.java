package sematec.mohammad.com.mohammadreza_sematec;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import sematec.mohammad.com.mohammadreza_sematec.Application.App;

public class S08 extends AppCompatActivity {

    private Boolean Back_Flag = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s08);





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


     menu.add(getString(R.string.goto_alertdialog_activity));
     menu.add(getString(R.string.Gson_Activity));


        return super.onCreateOptionsMenu(menu);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

       if (item.getTitle()==getString(R.string.goto_alertdialog_activity)){

          startActivity(new Intent(S08.this,S08_AlertDialog.class));

       }
       else if (item.getTitle()==(getString(R.string.Gson_Activity)))
       {

            startActivity(new Intent(S08.this,S08_Gson_Activity.class));

       }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        App.T_Long("Are You Sure To Quit?");

        if (!Back_Flag) {
            Back_Flag = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Back_Flag = false;
                }
            }, 2500);

        }else{
            super.onBackPressed();
        }
}}
