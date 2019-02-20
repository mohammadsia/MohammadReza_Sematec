package sematec.mohammad.com.mohammadreza_sematec;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import sematec.mohammad.com.mohammadreza_sematec.Application.App;
import sematec.mohammad.com.mohammadreza_sematec.Application.Application;

public class S08_AlertDialog extends AppCompatActivity implements View.OnClickListener {

    Button btn_Get_Permission;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s08__alert_dialog);




        init();

    }

    private void init() {

        btn_Get_Permission = findViewById(R.id.btn_getPermission);

        btn_Get_Permission.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){


            case R.id.btn_getPermission :
                if (ContextCompat.checkSelfPermission(Application.getContext(), Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED)
                { App.T_Long("Permission Is Granted");
                    return;}
                alertdialog();

                break;

        }    }




    private void alertdialog() {

        AlertDialog alertDialog = new AlertDialog.Builder(S08_AlertDialog.this).create();
        alertDialog.setTitle("Permission");
        alertDialog.setMessage("Please Get Permission");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (ContextCompat.checkSelfPermission(Application.getContext(), Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){

                    App.T_Long("Permission Granted");
                    ActivityCompat.requestPermissions(S08_AlertDialog.this, new String[]{Manifest.permission.CAMERA}
                            , 1500);

                }
            }
        });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                App.T_Long("Please Get Permission");

            }
        });
alertDialog.show();

    }
}
