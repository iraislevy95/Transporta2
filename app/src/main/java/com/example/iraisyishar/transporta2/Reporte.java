package com.example.iraisyishar.transporta2;

/**
 * Created by iraisyishar on 12/11/2017.
 */

public class Reporte {
    //Limpieza
    public final int LIMPIO=0;
    public final int SUCIO=1;
    public final int MUY_SUCIO=2;
    //Llenado
    public final int VACIO=0;
    public final int REGULAR=1;
    public final int LLENO=2;
    public final int HASTA_SU_PTM=3;

    private String ruta;
    private String numUnidad;
    private boolean amable;
    private boolean manejaMal;
    private boolean noDaParada;
    private int limpieza;
    private int llenado;

    public Reporte(String ruta, String numUnidad,boolean amable,boolean manejaMal,
                   boolean noDaParada,int limpieza,int llenado){
        this.ruta = ruta;
        this.numUnidad = numUnidad;
        this.amable = amable;
        this.manejaMal = manejaMal;
        this.noDaParada = noDaParada;
        this.limpieza = limpieza;
        this.llenado = llenado;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public void setNumUnidad(String numUnidad) {
        this.numUnidad = numUnidad;
    }

    public void setAmable(boolean amable) {
        this.amable = amable;
    }

    public void setManejaMal(boolean manejaMal) {
        this.manejaMal = manejaMal;
    }

    public void setNoDaParada(boolean noDaParada) {
        this.noDaParada = noDaParada;
    }

    public void setLimpieza(int limpieza) {
        this.limpieza = limpieza;
    }

    public void setLlenado(int llenado) {
        this.llenado = llenado;
    }

    public String getRuta() {
        return ruta;
    }

    public String getNumUnidad() {
        return numUnidad;
    }
    public boolean getAmable(){
        return amable;
    }
    public boolean getManejaMal(){
        return  manejaMal;
    }
    public boolean getNoDaParada(){
        return noDaParada;
    }

    public int getLimpieza() {
        return limpieza;
    }

    public int getLlenado() {
        return llenado;
    }
}
