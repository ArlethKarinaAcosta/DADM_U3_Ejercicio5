package com.example.arlet.dadm_u3_ejercicio5;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo2 extends View {

    Imagen2 icono1, icono2, icono3, puntero, icono4, icono5, icono6, icono7, icono8;
    String mensaje, mensaje2;
    Main2Activity puntero2;


    public Lienzo2(Context context) {
        super(context);

        mensaje ="Arrastra el texto al color que corresponda";
        mensaje2 ="";
        icono1 = new Imagen2(R.drawable.red, 200, 400, this);
        icono2 = new Imagen2(R.drawable.blue, 200, 900, this);
        icono3 = new Imagen2(R.drawable.green, 200, 1400, this);
        icono4 = new Imagen2(R.drawable.green2, 1100, 400, this);
        icono5 = new Imagen2(R.drawable.red2, 1100, 900, this);
        icono6 = new Imagen2(R.drawable.blue2, 1100, 1400, this);
        icono7 = new Imagen2(R.drawable.atras, 400, 1900, this);
        icono8 = new Imagen2(R.drawable.volver, 900, 1900, this);

        puntero = null;
        puntero2 = (Main2Activity) context;



    }

    public void onDraw(Canvas c)
    {
        super.onDraw(c);
        Paint p = new Paint();

        p.setTextSize(80);
        p.setColor(Color.BLACK);
        c.drawText(mensaje, 200, 150, p);
        icono1.pintar(c, p);
        icono2.pintar(c, p);
        icono3.pintar(c,p);
        icono4.pintar(c,p);
        icono5.pintar(c,p);
        icono6.pintar(c,p);
        p.setTextSize(70);
        p.setColor(Color.MAGENTA);
        c.drawText(mensaje2, 250, 1900, p);
        icono7.pintar(c,p);
        icono8.pintar(c,p);

    }

    public boolean onTouchEvent(MotionEvent e)
    {
        float xp = e.getX();
        float yp = e.getY();

        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:

                if (icono4.estaEnArea(xp, yp)) {
                    puntero = icono4;
                }
                if (icono5.estaEnArea(xp, yp)) {
                    puntero = icono5;
                }
                if (icono6.estaEnArea(xp, yp)) {
                    puntero = icono6;
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
                if(puntero!=null)
                {
                    puntero.mover(xp, yp);
                    if(puntero.colisionNew(icono1) && puntero == icono5)
                    {
                        mensaje2 = "Unió correctamente los colores red/rojo.";
                        icono5.hacerVisible(false);
                        icono1.hacerVisible(false);
                    }

                    if(puntero.colisionNew(icono2) && puntero == icono6)
                    {
                        mensaje2 = "Unió correctamente el color blue/azul.";
                        icono6.hacerVisible(false);
                        icono2.hacerVisible(false);
                    }

                    if(puntero.colisionNew(icono3) && puntero == icono4)
                    {
                        mensaje2 = "Unió correctamente los colores green/verde.";
                        icono4.hacerVisible(false);
                        icono3.hacerVisible(false);
                    }
                }



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
        Intent volver = new Intent(puntero2, Main2Activity.class);
        puntero2.startActivity(volver);
    }

}
