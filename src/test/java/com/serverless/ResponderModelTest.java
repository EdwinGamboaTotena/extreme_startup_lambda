package com.serverless;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResponderModelTest {

    @Test
    public void  cuandoPreguntanPorElNombreRespondeHalcones(){
        ResponderModel responder = new ResponderModel();
        String pregunta = "d4f58f60: what is your name";
        String respuesta = responder.answer(pregunta);
        assertThat(respuesta).isEqualTo("halcones");
    }

    @Test
    public void cuandoPreguntaPorLaSuma(){
        ResponderModel responder = new ResponderModel();
        String pregunta = "d4f58f60: what is 5 plus 8";
        String respuesta = responder.answer(pregunta);
        assertThat(respuesta).isEqualTo("13");
    }

    @Test
    public void cuandoPreguntaPorElMayor(){
        ResponderModel responder = new ResponderModel();
        String pregunta = "2c3ba230: which of the following numbers is the largest: 648, 469, 85, 40";
        String respuesta = responder.answer(pregunta);
        assertThat(respuesta).isEqualTo("648");
    }

    @Test
    public void sacarListaDeNumeros() {
        ResponderModel responder = new ResponderModel();
        String pregunta = ": 648, 469, 85, 40";
        List<Integer> respuesta = responder.listNumeros(pregunta);
        assertThat(respuesta.size()).isEqualTo(4);
        assertThat(respuesta.get(0)).isEqualTo(648);
        assertThat(respuesta.get(3)).isEqualTo(40);
    }

    @Test
    public void cuandoPreguntaPorLaResta(){
        ResponderModel responder = new ResponderModel();
        String pregunta = "d4f58f60: what is 8 minus 5";
        String respuesta = responder.answer(pregunta);
        assertThat(respuesta).isEqualTo("3");
    }

}
