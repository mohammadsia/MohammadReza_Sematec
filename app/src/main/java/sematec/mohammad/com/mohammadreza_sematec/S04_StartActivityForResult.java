package sematec.mohammad.com.mohammadreza_sematec;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.orhanobut.hawk.Hawk;

import sematec.mohammad.com.mohammadreza_sematec.Application.App;
import sematec.mohammad.com.mohammadreza_sematec.Application.Application;

public class S04_StartActivityForResult extends AppCompatActivity implements View.OnClickListener , TextWatcher {

    EditText ext_FirstName,ext_LastName,ext_Phone,ext_Mail,ext_Age;

    Button   btn_Login;

    String   FirstName ,LastName   ,Age   ,Phone   ,Email;

    String   Hawk_First_Name,Hawk_LastName,Hawk_Age,Hawk_Email,Hawk_Phone;

    Intent   intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s04__start_activity_for_result);





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


        Hawk.init(Application.getContext()).build();


        intent          =   new Intent( this   ,S04_StartActivityForResult2.class  );



        Hawk_init();

    }

    private void Hawk_init() {

   try {
       Hawk_First_Name = Hawk.get(S04_StartActivityForResult2.TAG_FIRSTNAME_SHARED);
       Hawk_LastName = Hawk.get(S04_StartActivityForResult2.TAG_LASTNAME_SHARED);
       Hawk_Age = Hawk.get(S04_StartActivityForResult2.TAG_AGE_SHARED);
       Hawk_Email = Hawk.get(S04_StartActivityForResult2.TAG_EMAIL_SHARED);
       Hawk_Phone = Hawk.get(S04_StartActivityForResult2.TAG_PHONE_SHARED);


       ext_FirstName.setText(Hawk_First_Name);
       ext_LastName.setText(Hawk_LastName);
       ext_Age.setText(Hawk_Age);
       ext_Mail.setText(Hawk_Email);
       ext_Phone.setText(Hawk_Phone);
   }catch (Exception e ){
       e.printStackTrace();
   }

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
                    if (FirstName.length() > 3 && LastName.length() > 3 && Age.length() >= 1 && Email.length() > 8 && Phone.length() > 9) {

                        intent.putExtra("FirstName", FirstName);
                        intent.putExtra("LastName", LastName);
                        intent.putExtra("Age", Age);
                        intent.putExtra("Email", Email);
                        intent.putExtra("Phone", Phone);

                        startActivityForResult(intent,20);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {


        super.onActivityResult(requestCode, resultCode, data);
    }
}
