package sematec.mohammad.com.mohammadreza_sematec.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import sematec.mohammad.com.mohammadreza_sematec.Application.Application;
import sematec.mohammad.com.mohammadreza_sematec.Objects.S05_Object;
import sematec.mohammad.com.mohammadreza_sematec.R;

public class S05_Recycler_Adapter extends RecyclerView.Adapter<S05_Recycler_Adapter.S05_Recycler_ViewHolder> {

    List<S05_Object> objects;

    public S05_Recycler_Adapter(List<S05_Object> objects)
    {this.objects=objects;}



    @NonNull
    @Override
    public S05_Recycler_ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(Application.getContext()).inflate(R.layout.s05__recycler__adapter,viewGroup,false );

        return new S05_Recycler_ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull S05_Recycler_ViewHolder holder, int i) {


        holder.text_name.setText(objects.get(i).getName() + "/"+ objects.get(i).getLastName() );

    }

    @Override
    public int getItemCount() {
     try {
         return objects.size();
     }catch (NullPointerException e)
     {
         return 1;
     }}

    public class S05_Recycler_ViewHolder extends RecyclerView.ViewHolder {


        TextView text_name;
        public S05_Recycler_ViewHolder(@NonNull View itemView) {
            super(itemView);

            text_name =itemView.findViewById(R.id.Contact_Name);
        }
    }
}
