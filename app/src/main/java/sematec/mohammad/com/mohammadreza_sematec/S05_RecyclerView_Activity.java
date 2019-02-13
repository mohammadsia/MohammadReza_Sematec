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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s05__recycler_view);

        init();

    }

    private void init() {

        Hawk.init(Application.getContext()).build();

        List<S05_Object> list=new ArrayList<>();
        Add = findViewById(R.id.Add);
        Add.setOnClickListener(this);

         list = Hawk.get("object");
        recycler = findViewById(R.id.recycler);
        adapter   = new S05_Recycler_Adapter(list);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(Application.getContext(), RecyclerView.VERTICAL, false));

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.Add){

            intent = new Intent(S05_RecyclerView_Activity.this, S04_StartActivityForResult.class);
            startActivity(intent);
        }
    }
}