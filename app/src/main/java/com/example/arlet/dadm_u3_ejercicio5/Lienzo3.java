package com.example.arlet.dadm_u3_ejercicio5;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo3 extends View {
    Imagen3 icono1, icono2, icono3, icono4, icono5, icono6, puntero, icono7, icono8;
    String mensaje, mensaje2, mensaje3, mensaje4, mensaje5, mensaje6, mensaje7, mensaje8;
    MediaPlayer mp;
    Main3Activity puntero2;

    public Lienzo3(Context context) {
        super(context);
        mensaje="¡Toca el color y escucha su pronunciación!";
        icono1 = new Imagen3(R.drawable.blue, 100, 400, this);
        icono2 = new Imagen3(R.drawable.red, 680, 400, this);
        icono3 = new Imagen3(R.drawable.green, 1250, 400, this);
        icono4 = new Imagen3(R.drawable.purple, 100, 1200,this);
        icono5 = new Imagen3(R.drawable.black, 680, 1200, this);
        icono6 = new Imagen3(R.drawable.yellow, 1250, 1200, this);
        icono7 = new Imagen3(R.drawable.atras, 400, 1900, this);
        icono8 = new Imagen3(R.drawable.volver, 1000, 1900, this);

        puntero2 = (Main3Activity) context;

        mp = new MediaPlayer();
        puntero = null;
        mensaje2 = "Blue";
        mensaje3 = "Red";
        mensaje4 = "Green";
        mensaje5 = "Purple";
        mensaje6 = "Black";

        mensaje7 ="Yellow";
        mensaje8="";


    }

    protected void onDraw(Canvas c)
    {
        super.onDraw(c);
        Paint p = new Paint();

        p.setTextSize(80);
        p.setColor(Color.BLACK);
        c.drawText(mensaje, 100, 200, p);
        icono1.pintar(c,p);
        icono2.pintar(c, p);
        icono3.pintar(c,p);
        p.setTextSize(70);
        p.setColor(Color.BLUE);
        c.drawText(mensaje2, 230, 900, p);
        p.setTextSize(70);
        p.setColor(Color.RED);
        c.drawText(mensaje3, 830, 900, p);
        p.setTextSize(70);
        p.setColor(Color.GREEN);
        c.drawText(mensaje4, 1360, 900, p);
        icono4.pintar(c, p);
        icono5.pintar(c,p);
        icono6.pintar(c,p);
        p.setTextSize(70);
        p.setColor(Color.MAGENTA);
        c.drawText(mensaje5, 230, 1700, p);
        p.setTextSize(70);
        p.setColor(Color.BLACK);
        c.drawText(mensaje6, 830, 1700, p);
        p.setTextSize(70);
        p.setColor(Color.YELLOW);
        c.drawText(mensaje7, 1360, 1700, p);
        p.setColor(Color.BLACK);
        c.drawText(mensaje8, 800, 1900, p);
        icono7.pintar(c,p);
        icono8.pintar(c,p);


    }


    public boolean onTouchEvent(MotionEvent e)
    {

        float xp = e.getX();
        float yp = e.getY();

        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (icono1.estaEnArea(xp, yp)){
                    puntero = icono1; //puntero apunta a icono1
                    mp = MediaPlayer.create(puntero2, R.raw.bluebueno);
                    mp.start();
                    mensaje8 ="BLUE";

                }
                if (icono2.estaEnArea(xp, yp)){
                    puntero = icono2;
                    mp = MediaPlayer.create(puntero2, R.raw.redbueno);
                    mp.start();
                    mensaje8 ="RED";
                }
                if (icono3.estaEnArea(xp, yp)){
                    puntero = icono3;
                    mensaje8 ="GREEN";
                    mp = MediaPlayer.create(puntero2, R.raw.greenbueno);
                    mp.start();
                }
                if (icono4.estaEnArea(xp, yp)){
                    puntero = icono4;
                    mensaje8 ="PURPLE";
                    mp = MediaPlayer.create(puntero2, R.raw.purplebueno);
                    mp.start();
                }
                if (icono5.estaEnArea(xp, yp)){
                    puntero = icono5;
                    mensaje8 ="BLACK";
                    mp = MediaPlayer.create(puntero2, R.raw.blackbueno);
                    mp.start();
                }
                if (icono6.estaEnArea(xp, yp)){
                    puntero = icono6;
                    mensaje8 ="YELLOW";
                    mp = MediaPlayer.create(puntero2, R.raw.yellowbueno);
                    mp.start();
                }
                if (icono7.estaEnArea(xp, yp)){
                    puntero = icono7;
                    cambioAtras();
                }
                if (icono8.estaEnArea(xp, yp)){
                    puntero = icono8;
                    cambioVolver();
                }


                break;

            case MotionEvent.ACTION_MOVE:
                break;

            case MotionEvent.ACTION_UP:
                puntero = null;
                break;
        }

        invalidate();
        return true;
    }

    public void cambioAtras()
    {
        Intent atras = new Intent(puntero2, MainActivity.class);
        puntero2.startActivity(atras);
    }

    public void cambioVolver()
    {
        Intent volver = new Intent(puntero2, Main3Activity.class);
        puntero2.startActivity(volver);
    }




}
