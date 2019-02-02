package sematec.mohammad.com.mohammadreza_sematec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class S03_Login_Page1 extends AppCompatActivity implements View.OnClickListener {

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

        FirstName       =   ext_FirstName.getText().toString().trim();
        LastName        =   ext_FirstName.getText().toString().trim();
        Age             =   ext_FirstName.getText().toString().trim();
        Email           =   ext_FirstName.getText().toString().trim();
        Phone           =   ext_FirstName.getText().toString().trim();

        intent          =   new Intent( this   ,S03_Login_Page2.class  );

    }

    private void Listener() {
        btn_Login.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.Login:

                intent.putExtra("FirstName", FirstName);
                intent.putExtra("LastName", LastName);
                intent.putExtra("Age", Age);
                intent.putExtra("Email", Email);
                intent.putExtra("Phone", Phone);

                startActivity(intent);
                break;
        }

    }
}
