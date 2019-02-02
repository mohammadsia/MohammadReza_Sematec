package sematec.mohammad.com.mohammadreza_sematec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import sematec.mohammad.com.mohammadreza_sematec.Application.App;

public class S03_Login_Page2 extends AppCompatActivity implements View.OnClickListener {


    TextView  txt_FirstName ,txt_LastName ,txt_Age ,txt_Email ,txt_Phone;

    public final String Tag_FirstName = "FirstName";
    public final String Tag_LastName  = "LastName";
    public final String Tag_Age       = "Age";
    public final String Tag_Email     = "Email";
    public final String Tag_Phone     = "Phone";

    String  FirstName   ,   LastName    ,   Age     ,   Email   ,   Phone ;

    Button btn_Verify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s03__login__page2);

        init();
        Listener();

    }



    private void init() {
        Intent intent=getIntent();

        FirstName =   intent.getStringExtra(Tag_FirstName);
        LastName  =   intent.getStringExtra(Tag_LastName);
        Age       =   intent.getStringExtra(Tag_Age);
        Email     =   intent.getStringExtra(Tag_Email);
        Phone     =   intent.getStringExtra(Tag_Phone);


        txt_FirstName =   findViewById(R.id.txt_FirstName);
        txt_LastName  =   findViewById(R.id.txt_LastName);
        txt_Age       =   findViewById(R.id.txt_Age);
        txt_Email     =   findViewById(R.id.txt_Email);
        txt_Phone     =   findViewById(R.id.txt_Phone);

        btn_Verify      =   findViewById(R.id.btn_Verify);



        txt_FirstName   .   setText ("FirstName : " + FirstName);
        txt_LastName    .   setText ("LastName : " +LastName);
        txt_Age         .   setText ("Age : " +Age );
        txt_Email       .   setText ("Email : " +Email);
        txt_Phone       .   setText ("Phone : " +Phone);
    }


    private void Listener() {
        btn_Verify.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId()==btn_Verify.getId()){

            App.T_Short("Login ...." );
        }
    }
}
