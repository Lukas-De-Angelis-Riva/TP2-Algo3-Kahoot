package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MultipleChoiceClasicoTest {

    @Test
    public void test01ResponderPreguntaConDosRespuestasAplicaResponderConCriterioACadaRespuestaEnviada(){

        String enunciado = "¿Quien creo el patron Poxi?";

        String opcion1 = "Diego";
        String opcion2 = "Tomas";
        String opcion3 = "Pablo";
        String opcion4 = "Pablo";
        String opcion5 = "Eugenio";

        List<String> correctas = new ArrayList<String>();
        correctas.add(opcion3);
        correctas.add(opcion4);


        Eleccion eleccionCorrecta = new Eleccion(correctas);
        MultipleChoiceClasico multipleChoice = new MultipleChoiceClasico(enunciado, eleccionCorrecta);

        Respuesta mockRespuesta = mock(Respuesta.class);
        Respuesta mockRespuesta2 = mock(Respuesta.class);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(mockRespuesta);
        respuestas.add(mockRespuesta2);

        multipleChoice.responderPregunta(respuestas);

        verify(mockRespuesta, times(1)).responderConCriterio(any(CriterioMultipleChoiceClasico.class));
        verify(mockRespuesta2, times(1)).responderConCriterio(any(CriterioMultipleChoiceClasico.class));
    }

    @Test
    public void test02ResponderPreguntaConTresRespuestasAplicaResponderConCriterioACadaRespuestaEnviada(){

        String enunciado = "¿Cuales no son principios SOLID";

        String opcion1 = "Liskov";
        String opcion2 = "Close-Open";
        String opcion3 = "Single Responsability";
        String opcion4 = "Herencia de Markov";
        String opcion5 = "Design driven development";

        List<String> correctas = new ArrayList<String>();
        correctas.add(opcion2);
        correctas.add(opcion4);
        correctas.add(opcion5);

        Eleccion eleccionCorrecta = new Eleccion(correctas);
        MultipleChoiceClasico multipleChoice = new MultipleChoiceClasico(enunciado, eleccionCorrecta);

        Respuesta mockRespuesta = mock(Respuesta.class);
        Respuesta mockRespuesta2 = mock(Respuesta.class);
        Respuesta mockRespuesta3 = mock(Respuesta.class);
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(mockRespuesta);
        respuestas.add(mockRespuesta2);
        respuestas.add(mockRespuesta3);

        multipleChoice.responderPregunta(respuestas);

        verify(mockRespuesta, times(1)).responderConCriterio(any(CriterioMultipleChoiceClasico.class));
        verify(mockRespuesta2, times(1)).responderConCriterio(any(CriterioMultipleChoiceClasico.class));
        verify(mockRespuesta3, times(1)).responderConCriterio(any(CriterioMultipleChoiceClasico.class));
    }

    @Test
    public void test03UnMultipleChoiceClasicolLanzaUnaExcepcionCuandoSeIntentaInicializarConMasDe5pcionesCorrectas(){

        String enunciado = "p -> q";

        String opcion1 = "p'.q";
        String opcion2 = "q'-> p'";
        String opcion3 = "(p + q')'";
        String opcion4 = "p'.q + p.p'";
        String opcion5 = "p'.(q + p)";
        String opcion6 = "(p + (q'.p'))'";

        List<String> correctas = new ArrayList<String>();
        correctas.add(opcion1);
        correctas.add(opcion2);
        correctas.add(opcion3);
        correctas.add(opcion4);
        correctas.add(opcion5);
        correctas.add(opcion6);

        Eleccion eleccionCorrecta = new Eleccion(correctas);

        assertThrows(SolucionInvalidaException.class,
                ()->{
                    MultipleChoiceClasico multipleChoice = new MultipleChoiceClasico(enunciado, eleccionCorrecta);
                });
    }

    @Test
    public void test04UnMultipleChoiceClasicoLanzaUnaExcepcionCuandoSeIntentaInicializarConCeroOcionesCorrectas(){

        String enunciado = "P = NP";

        String opcion1 = "Si";
        String opcion2 = "Claramente no";
        String opcion3 = "Un poquito";
        String opcion4 = "Pablo = NicoPaez (?";
        String opcion5 = ":SonLoMismo:";

        List<String> correctas = new ArrayList<String>();

        Eleccion eleccionCorrecta = new Eleccion(correctas);

        assertThrows(SolucionInvalidaException.class,
                ()->{
                    MultipleChoiceClasico multipleChoice = new MultipleChoiceClasico(enunciado, eleccionCorrecta);
                });
    }

}
