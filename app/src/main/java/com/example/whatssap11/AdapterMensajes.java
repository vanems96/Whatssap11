package com.example.whatssap11;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdapterMensajes extends RecyclerView.Adapter<HolderMensaje>{

private List<MensajeRecibir> ListMensaje = new ArrayList<>();
private Context c;

    public AdapterMensajes( Context c) {
        this.c = c;
    }

    public void addMensaje(MensajeRecibir m){
        ListMensaje.add(m);
        notifyItemInserted(ListMensaje.size() );
    }

    @Override
    public HolderMensaje onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.card_view_mensajes,parent,false);
        return new HolderMensaje(v);
    }

    @Override
    public void onBindViewHolder( HolderMensaje holderMensaje, int position) {
        holderMensaje.getNombre().setText(ListMensaje.get(position).getNombre());
        holderMensaje.getMensaje().setText(ListMensaje.get(position).getMensaje());

        if (ListMensaje.get(position).getType_mensaje().equals("2")){
            holderMensaje.getFotoMensajeEnviadoImagenes().setVisibility(View.VISIBLE);
            holderMensaje.getMensaje().setVisibility(View.VISIBLE);
            Glide.with(c).load(ListMensaje.get(position).getUrlFoto()).into(holderMensaje.getFotoMensajeEnviadoImagenes());

        }else if (ListMensaje.get(position).getType_mensaje().equals("1")){
            holderMensaje.getFotoMensajeEnviadoImagenes().setVisibility(View.GONE);
            holderMensaje.getMensaje().setVisibility(View.VISIBLE);

        }
        if (ListMensaje.get(position).getFotoPerfil().isEmpty()){
            holderMensaje.getFotoMensaje().setImageResource(R.mipmap.ic_launcher);
        }else{
            Glide.with(c).load(ListMensaje.get(position).getFotoPerfil()).into(holderMensaje.getFotoMensaje());
        }
        Long codigoHora = ListMensaje.get(position).getHora();
        Date d = new Date(codigoHora);
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh:mm:ss a");//a es igual para am o pm
        holderMensaje.getHora().setText(sdf.format(d));
    }

    @Override
    public int getItemCount() {

        return ListMensaje.size();
    }
}

