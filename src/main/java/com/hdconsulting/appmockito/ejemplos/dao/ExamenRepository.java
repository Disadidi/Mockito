package com.hdconsulting.appmockito.ejemplos.dao;

import com.hdconsulting.appmockito.ejemplos.models.Examen;

import java.util.List;

public interface ExamenRepository {

    Examen guardar(Examen examen);
    List<Examen> findAll();
}
