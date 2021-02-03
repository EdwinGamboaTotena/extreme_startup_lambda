package com.serverless;

import org.junit.Test;

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
        String pregunta = "d4f58f60: what is the sum of 5 and 8";
        String respuesta = responder.answer(pregunta);
        assertThat(respuesta).isEqualTo("13");
    }

}
