package com.example.iraisyishar.transporta2;
/**
 * Created by iraisyishar on 10/11/2017.
 */

public class Ruta {
    protected long id;
    private String numRuta;
    private String origen;
    private String destino;
    private String idServidor;

    public Ruta(String numRuta, String origen, String destino, String id){
        this.numRuta = numRuta;
        this.origen = origen;
        this.destino = destino;
        this.id = 1;
        this.idServidor = id;
    }

    public String getNumRuta() {
        return numRuta;
    }

    public String getDestino() {
        return destino;
    }

    public String getOrigen() {
        return origen;
    }

    public long getId() { return id; }

    public String getIdServidor() { return idServidor; }

    public void setNumRuta(String numRuta) {
        this.numRuta = numRuta;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setId(long id) { this.id = id; }

    public void setIdServidor(String idServidor) { this.idServidor = idServidor; }
}
