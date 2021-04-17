package com.hdconsulting.appmockito.ejemplos.dao;

import java.util.List;

public interface PreguntaRepository {

    List<String> findPreguntasPorExamenId(Long id);

    void guardarVarias(List<String> preguntas);
}
