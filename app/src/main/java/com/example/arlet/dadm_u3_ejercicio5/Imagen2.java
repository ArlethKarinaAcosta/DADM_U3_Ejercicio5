package com.example.arlet.dadm_u3_ejercicio5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Imagen2 {
    Bitmap icono;
    float x, y;
    private boolean visible;


    public Imagen2(int recurso, float _x, float _y, Lienzo2 u)
    {
        icono = BitmapFactory.decodeResource(u.getResources(), recurso);
        x = _x;
        y = _y;
        visible = true;
    }

    public void pintar(Canvas c, Paint p)
    {
        if(visible)
        {
            c.drawBitmap(icono, x, y, p);
        }
    }

    public void hacerVisible(boolean v)
    {
        visible = v;
    }

    public boolean estaEnArea(float xp, float yp)
    {
        float x2, y2;

        if (!visible){
            return false;
        }

        x2 = x+icono.getWidth();
        y2 = y+icono.getHeight();

        if(xp>=x && xp<=x2){
            if (yp >= y && yp <= y2){
                return true;
            }
        }

        return  false;
    }

    public void mover(float xp, float yp)
    {
        x = xp - icono.getWidth()/2;
        y = yp - icono.getHeight()/2;
    }

    public boolean colisionNew(Imagen2 objetoC)
    {
        float x2 = x + icono.getWidth();
        float y2 = y + icono.getHeight();

        if(objetoC.estaEnArea(x2, y))
        {
            //revisando caso 1
            return true;
        }
        if (objetoC.estaEnArea(x, y)){
            //revisando caso 2
            return  true;
        }

        if (objetoC.estaEnArea(x2, y2)) {
            //revisando caso 3
            return true;
        }

        if (objetoC.estaEnArea(x, y2)) {
            //revisando caso 4
            return true;
        }



        return false;
    }

}
