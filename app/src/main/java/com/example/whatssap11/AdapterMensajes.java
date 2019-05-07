package com.example.whatssap11;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static android.graphics.Color.RED;

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

        // verificacion de contenido de acoso
        Mensaje mensaje = ListMensaje.get(position);
        String msj = mensaje.getMensaje().toString();
        String []acoso = {
                "acoso uno",
                "acoso dos",
                "acoso tres"
        };
        String msjTextLower = msj.toLowerCase(Locale.getDefault());
        SpannableString spannableString = new SpannableString(msj);

        for(int ac=0; ac<acoso.length; ac++) { // en caso que el mensaje presente las tres frases de acoso
            if (msjTextLower.contains(acoso[ac]) && !acoso[ac].isEmpty()) {
                spannableString.setSpan(new ForegroundColorSpan(RED), msjTextLower.indexOf(acoso[ac]),
                        msjTextLower.indexOf(acoso[ac]) + acoso[ac].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                holderMensaje.getMensaje().setText(spannableString, TextView.BufferType.SPANNABLE);
            }
            if (msjTextLower.contains(acoso[0]) && !acoso[0].isEmpty()) { // en caso que el mensaje presente la primer frase de acoso
                spannableString.setSpan(new ForegroundColorSpan(RED), msjTextLower.indexOf(acoso[0]),
                        msjTextLower.indexOf(acoso[0]) + acoso[0].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                holderMensaje.getMensaje().setText(spannableString, TextView.BufferType.SPANNABLE);
            }
            else if (msjTextLower.contains(acoso[1]) && !acoso[1].isEmpty()) { // en caso que el mensaje presente la segunda frase de acoso
                spannableString.setSpan(new ForegroundColorSpan(RED), msjTextLower.indexOf(acoso[1]),
                        msjTextLower.indexOf(acoso[1]) + acoso[1].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                holderMensaje.getMensaje().setText(spannableString, TextView.BufferType.SPANNABLE);
            }
            else if (msjTextLower.contains(acoso[2]) && !acoso[2].isEmpty()) { // en caso que el mensaje presente la tercer frase de acoso
                spannableString.setSpan(new ForegroundColorSpan(RED), msjTextLower.indexOf(acoso[2]),
                        msjTextLower.indexOf(acoso[2]) + acoso[2].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                holderMensaje.getMensaje().setText(spannableString, TextView.BufferType.SPANNABLE);
            } else {
                holderMensaje.getMensaje().setText(mensaje.getMensaje());
            }
        }

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

