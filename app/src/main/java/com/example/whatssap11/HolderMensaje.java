package com.example.whatssap11;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class HolderMensaje extends RecyclerView.ViewHolder {
    private TextView nombre;
    private TextView mensaje;
    private TextView hora;
    private CircleImageView fotoMensaje;
    private ImageView fotoMensajeEnviadoImagenes;

    public HolderMensaje(@NonNull View itemView) {
        super(itemView);
        nombre = (TextView) itemView.findViewById(R.id.nombreMensaje);
        mensaje = (TextView) itemView.findViewById(R.id.mensajeMensaje);
        hora = (TextView) itemView.findViewById(R.id.horaMensaje);
        fotoMensaje = (CircleImageView) itemView.findViewById(R.id.fotoPerfilMensaje);
        fotoMensajeEnviadoImagenes = (ImageView) itemView.findViewById(R.id.mensajeFoto);
    }

    public ImageView getFotoMensajeEnviadoImagenes() {
        return fotoMensajeEnviadoImagenes;
    }

    public void setFotoMensajeEnviadoImagenes(ImageView fotoMensajeEnviadoImagenes) {
        this.fotoMensajeEnviadoImagenes = fotoMensajeEnviadoImagenes;
    }

    public TextView getNombre() {
        return nombre;
    }

    public void setNombre(TextView nombre) {
        this.nombre = nombre;
    }

    public TextView getMensaje() {
        return mensaje;
    }

    public void setMensaje(TextView mensaje) {
        this.mensaje = mensaje;
    }

    public TextView getHora() {
        return hora;
    }

    public void setHora(TextView hora) {
        this.hora = hora;
    }

    public CircleImageView getFotoMensaje() {
        return fotoMensaje;
    }

    public void setFotoMensaje(CircleImageView fotoMensaje) {
        this.fotoMensaje = fotoMensaje;
    }
}
