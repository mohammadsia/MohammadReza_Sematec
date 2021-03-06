package sematec.mohammad.com.mohammadreza_sematec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.List;

import sematec.mohammad.com.mohammadreza_sematec.Adapters.S05_Recycler_Adapter;
import sematec.mohammad.com.mohammadreza_sematec.Application.Application;
import sematec.mohammad.com.mohammadreza_sematec.Objects.S05_Object;

public class S05_RecyclerView_Activity extends AppCompatActivity implements View.OnClickListener {



    private RecyclerView recycler;
    private Button Add;
    Intent intent;
    S05_Recycler_Adapter adapter;
    List<S05_Object> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s05__recycler_view);

        init();

    }

    private void init() {

        Hawk.init(Application.getContext()).build();


        Add = findViewById(R.id.Add);
        Add.setOnClickListener(this);


        S05_Object object = new S05_Object();
        List<String> firstname=new ArrayList<>();
        List<String> lastname = new ArrayList<>();

        firstname=Hawk.get("firstname");
        lastname=Hawk.get("lastname");

        recycler = findViewById(R.id.recycler);
        adapter   = new S05_Recycler_Adapter(list);
        recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        recycler.setLayoutManager(new LinearLayoutManager(Application.getContext(), RecyclerView.VERTICAL, false));

        for (int i=0;i<firstname.size();i++){

            object.setFirstName(firstname.get(i));
            object.setLastName(lastname.get(i));
            list.add(object);

        }




    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.Add){

            intent = new Intent(S05_RecyclerView_Activity.this, S04_StartActivityForResult.class);
            startActivity(intent);
        }
    }
}