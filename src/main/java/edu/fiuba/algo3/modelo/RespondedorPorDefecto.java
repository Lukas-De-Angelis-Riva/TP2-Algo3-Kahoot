package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionComun;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class RespondedorPorDefecto {

    private Ronda ronda;
    public RespondedorPorDefecto(Ronda ronda){
        this.ronda = ronda;
    }

    public void responder() {

        this.ronda.agregarRespuesta(this.respuestaPorDefecto());
    }


    private Respuesta respuestaPorDefecto(){
        Jugador unJugador = this.ronda.getJugadorActivo();
        Opcion opcionVacia = new OpcionComun("");
        List<Opcion> opcionesVacias = new ArrayList<>();
        opcionesVacias.add(opcionVacia);
        Eleccion eleccion = new Eleccion(opcionesVacias);
        Bonificador bonificador = new Bonificador();

        return new Respuesta(unJugador, eleccion, bonificador);
    }
}
