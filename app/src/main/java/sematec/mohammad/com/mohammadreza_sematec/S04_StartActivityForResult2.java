package sematec.mohammad.com.mohammadreza_sematec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import sematec.mohammad.com.mohammadreza_sematec.Application.App;
import sematec.mohammad.com.mohammadreza_sematec.Application.Application;
import sematec.mohammad.com.mohammadreza_sematec.Objects.S05_Object;
import sematec.mohammad.com.mohammadreza_sematec.R;

public class S04_StartActivityForResult2 extends AppCompatActivity implements View.OnClickListener {


    TextView txt_FirstName, txt_LastName, txt_Age, txt_Email, txt_Phone;

    public final String Tag_FirstName    = "FirstName";
    public final String Tag_LastName     = "LastName";
    public final String Tag_Age          = "Age";
    public final String Tag_Email        = "Email";
    public final String Tag_Phone        = "Phone";




    public static final String TAG_FIRSTNAME_SHARED = "FirstName";
    public static final String TAG_LASTNAME_SHARED  = "LastName";
    public static final String TAG_AGE_SHARED       = "AGE";
    public static final String TAG_EMAIL_SHARED     = "Email";
    public static final String TAG_PHONE_SHARED     = "Phone";

    String FirstName, LastName, Age, Email, Phone;

    Button btn_Verify, btn_Back,add;

    Intent intent;

    List<S05_Object> list;
    S05_Object object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s04__start_for_result2);

        init();
        Listener();

    }


    private void init() {
        intent = getIntent();



        FirstName = intent.getStringExtra(Tag_FirstName);
        LastName = intent.getStringExtra(Tag_LastName);
        Age = intent.getStringExtra(Tag_Age);
        Email = intent.getStringExtra(Tag_Email);
        Phone = intent.getStringExtra(Tag_Phone);


        txt_FirstName = findViewById(R.id.txt_FirstName);
        txt_LastName = findViewById(R.id.txt_LastName);
        txt_Age = findViewById(R.id.txt_Age);
        txt_Email = findViewById(R.id.txt_Email);
        txt_Phone = findViewById(R.id.txt_Phone);

        btn_Verify = findViewById(R.id.btn_Verify);
        btn_Back = findViewById(R.id.btn_Back);


        txt_FirstName.setText("FirstName : " + FirstName);
        txt_LastName.setText("LastName : " + LastName);
        txt_Age.setText("Age : " + Age);
        txt_Email.setText("Email : " + Email);
        txt_Phone.setText("Phone : " + Phone);


        add=findViewById(R.id.Add);
    }


    private void Listener() {
        btn_Verify.setOnClickListener(this);
        btn_Back.setOnClickListener(this);

        Hawk.init(Application.getContext()).build();

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == btn_Verify.getId()) {
            try {
                Hawk.put(TAG_FIRSTNAME_SHARED, FirstName);
                Hawk.put(TAG_LASTNAME_SHARED, LastName);
                Hawk.put(TAG_AGE_SHARED, Age);
                Hawk.put(TAG_PHONE_SHARED, Phone);
                Hawk.put(TAG_EMAIL_SHARED, Email);
                List<String> firstname=new ArrayList<>();
                List<String> lastname=new ArrayList<>();
                firstname.add(FirstName);
                lastname.add(FirstName);
                Hawk.put("firstname",firstname);
                Hawk.put("lastname",lastname);

            } catch (Exception execution) {
                execution.printStackTrace();
            }

            App.T_Short("Login ....");
        }


        if (v.getId() == btn_Back.getId()) {

            setResult(RESULT_OK, intent);
            finish();

        }

    }


}
