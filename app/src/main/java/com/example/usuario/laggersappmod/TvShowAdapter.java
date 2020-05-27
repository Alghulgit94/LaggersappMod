package com.example.usuario.laggersappmod;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by usuario on 7/1/2019.
 */

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.ViewHolder> {

    List<TvShow> TvShowList;
    Context context;

    public TvShowAdapter(List<TvShow>TvShowList)
    {
        this.TvShowList = TvShowList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        context = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final TvShow tvShow = TvShowList.get(position);
        holder.textTvShow.setText(tvShow.getTvshow());
        holder.imgTvShow.setImageResource(tvShow.getImgTvshow());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tvShow.getTvshow()=="Fortnite Shop"){
                    Toast.makeText(context,"Cargando "+tvShow.getTvshow(),Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, FortShop.class);
                    context.startActivity(intent);

                }
                if(tvShow.getTvshow()=="MK 11 Shop"){
                    Toast.makeText(context,"Cargando "+tvShow.getTvshow(),Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, MkShop.class);
                    context.startActivity(intent);
                }
                if(tvShow.getTvshow()=="Apex Shop"){
                    Toast.makeText(context,"Cargando "+tvShow.getTvshow(),Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, ApexShop.class);
                    context.startActivity(intent);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return TvShowList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imgTvShow;
        TextView textTvShow;
        CardView cv;

        public ViewHolder(View itemView)
        {
            super(itemView);
            imgTvShow = (ImageView)itemView.findViewById(R.id.imgTvshow);
            textTvShow = (TextView)itemView.findViewById(R.id.textTvshow);
            cv = (CardView)itemView.findViewById(R.id.cv);
        }

    }
}