package sematec.mohammad.com.mohammadreza_sematec.Adapters;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import sematec.mohammad.com.mohammadreza_sematec.Objects.DrawerItem;
import sematec.mohammad.com.mohammadreza_sematec.R;

public class CustomDrawerAdapter extends ArrayAdapter<DrawerItem>{
    Activity holder;
    int layourResourceId;
    DrawerItem items[];

    public CustomDrawerAdapter(Context context, int resource,DrawerItem[] drawerItems) {
        super(context, resource,drawerItems);
        holder=(Activity)context;
        layourResourceId=resource;
        items=drawerItems;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater=holder.getLayoutInflater();
            convertView=inflater.inflate(layourResourceId, parent,false);
        }

        TextView drawerItemText=convertView.findViewById(R.id.itemText);

        drawerItemText.setText(items[position].itemName);

        return convertView;
    }

}