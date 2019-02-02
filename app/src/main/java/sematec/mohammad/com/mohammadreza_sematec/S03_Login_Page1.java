package sematec.mohammad.com.mohammadreza_sematec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import sematec.mohammad.com.mohammadreza_sematec.Application.App;

public class S03_Login_Page1 extends AppCompatActivity implements View.OnClickListener , TextWatcher {

    EditText ext_FirstName,ext_LastName,ext_Phone,ext_Mail,ext_Age;

    Button   btn_Login;

    String   FirstName ,LastName   ,Age   ,Phone   ,Email;

    Intent   intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s03__login__page1);




        init();
        Listener();
    }


    private void init() {

        ext_FirstName   =   findViewById(R.id.FirstName);
        ext_LastName    =   findViewById(R.id.LastName);
        ext_Age         =   findViewById(R.id.Age);
        ext_Mail        =   findViewById(R.id.Mail);
        ext_Phone       =   findViewById(R.id.Phone);

        btn_Login       =   findViewById(R.id.Login);


        intent          =   new Intent( this   ,S03_Login_Page2.class  );

    }

    private void Listener() {
        btn_Login.setOnClickListener(this);


        ext_FirstName.addTextChangedListener(this);
        ext_LastName.addTextChangedListener(this);
        ext_Age.addTextChangedListener(this);
        ext_Mail.addTextChangedListener(this);
        ext_Phone.addTextChangedListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.Login:
        try {
            if (FirstName.length() > 3 && LastName.length() > 5 && Age.length() >= 1 && Email.length() > 8 && Phone.length() > 10) {

                intent.putExtra("FirstName", FirstName);
                intent.putExtra("LastName", LastName);
                intent.putExtra("Age", Age);
                intent.putExtra("Email", Email);
                intent.putExtra("Phone", Phone);

                startActivity(intent);
            } else App.T_Short("Please Complete All Field And Try Again...");
        }catch (Exception e ){
            e.printStackTrace();
            App.T_Short("Please Complete All Field And Try Again...  " + e);
        }

                break;
        }

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {


        FirstName       =   ext_FirstName.getText().toString().trim();
        LastName        =   ext_LastName.getText().toString().trim();
        Age             =   ext_Age.getText().toString().trim();
        Email           =   ext_Mail.getText().toString().trim();
        Phone           =   ext_Phone.getText().toString().trim();


    }
}
