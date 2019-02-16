package sematec.mohammad.com.mohammadreza_sematec;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Objects;

import sematec.mohammad.com.mohammadreza_sematec.Adapters.CustomDrawerAdapter;
import sematec.mohammad.com.mohammadreza_sematec.Application.Application;
import sematec.mohammad.com.mohammadreza_sematec.Objects.DrawerItem;

public class S06_Navigation_Drawer_Activity extends AppCompatActivity {


    DrawerLayout drawerLayout;
    ListView drawerList;

    ActionBarDrawerToggle drawerToggle;

    DrawerItem drawerItems[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s06__navigation__drawer_activity);





        init();
    }

    private void init() {


        drawerLayout=findViewById(R.id.drawerLayout);
        drawerList=findViewById(R.id.leftDrawer);

        drawerItems=new DrawerItem[4];

        drawerItems[0]=new DrawerItem("LinnearLayout");
        drawerItems[1]=new DrawerItem("LoginPage");
        drawerItems[2]=new DrawerItem("RecyclerView");
        drawerItems[3]=new DrawerItem("Prayer");


        drawerList.setAdapter(new CustomDrawerAdapter(this,R.layout.s06_nav_list_adapter, drawerItems));

        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                switch(position){
                    case 0:
                        startActivity(new Intent(S06_Navigation_Drawer_Activity.this,S02_Linner.class));
                        break;
                    case 1:
                        startActivity(new Intent(S06_Navigation_Drawer_Activity.this,S03_Login_Page1.class));

                        break;
                    case 2:
                        startActivity(new Intent(S06_Navigation_Drawer_Activity.this,S05_RecyclerView_Activity.class));

                        break;
                        case 6:
                        startActivity(new Intent(S06_Navigation_Drawer_Activity.this,S06_Prayer_Activity.class));

                        break;
                }

            }
        });



        Objects.requireNonNull(getActionBar()).setDisplayHomeAsUpEnabled(true);

        drawerToggle = new ActionBarDrawerToggle(S06_Navigation_Drawer_Activity.this,drawerLayout,R.string.app_name,R.string.app_name);

        drawerLayout.setDrawerListener(drawerToggle);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }


}