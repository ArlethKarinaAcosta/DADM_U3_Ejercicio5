package com.example.arlet.dadm_u3_ejercicio5;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View {

    Imagen icono1, icono2, icono3, puntero;
    String mensaje, mensaje2, mensaje3;
    MainActivity puntero2;
    public Lienzo(Context context) {
        super(context);

        mensaje ="Bienvenido al juego de Colores";
        mensaje2 = "Welcome to Colors' game";
        mensaje3 = "";
        icono1 = new Imagen(R.drawable.iniciar, 1000, 400, this);
        icono2 = new Imagen(R.drawable.bueno, 1000, 1250, this);
        icono3 = new Imagen(R.drawable.superfeliz, 10, 600, this);
        puntero = null;
        puntero2 = (MainActivity) context;
        puntero2 = (MainActivity) context;

    }

    protected void onDraw(Canvas c)
    {
        super.onDraw(c);

        Paint p = new Paint();
        p.setTextSize(70);
        p.setColor(Color.BLACK);
        c.drawText(mensaje, 400, 100, p);
        c.drawText(mensaje2, 450, 180, p);
        p.setColor(Color.RED);
        c.drawText(mensaje3, 700, 2000, p);
        icono1.pintar(c, p);
        icono2.pintar(c, p);
        icono3.pintar(c, p);

    }

    public boolean onTouchEvent(MotionEvent e)
    {

        float xp = e.getX();
        float yp = e.getY();

        switch (e.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                if (icono1.estaEnArea(xp, yp)){
                    mensaje3 = "¡A EMPEZAR!";
                    cambiarPantalla();
                    puntero = icono1; //puntero apunta a icono1
                }
                if (icono2.estaEnArea(xp, yp)){
                    mensaje3 = "¡A JUGAR!";
                    cambiarPantalla2();
                    puntero = icono2;
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



    public void cambiarPantalla()
    {

        Intent nuevaPantalla = new Intent(puntero2, Main3Activity.class);
        puntero2.startActivity(nuevaPantalla);
    }

    public void cambiarPantalla2()
    {
        Intent otraPantalla = new Intent(puntero2, Main2Activity.class);
        puntero2.startActivity(otraPantalla);
    }

}
