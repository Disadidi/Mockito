package com.hdconsulting.appmockito.ejemplos.services;

import com.hdconsulting.appmockito.ejemplos.Datos;
import com.hdconsulting.appmockito.ejemplos.dao.ExamenRepository;
import com.hdconsulting.appmockito.ejemplos.dao.ExamenRepositoryImpl;
import com.hdconsulting.appmockito.ejemplos.dao.PreguntaRepository;
import com.hdconsulting.appmockito.ejemplos.dao.PreguntaRepositoryImpl;
import com.hdconsulting.appmockito.ejemplos.models.Examen;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExamenServiceImplSpyTest {

    @Spy
    ExamenRepositoryImpl repository;

    @Spy
    PreguntaRepositoryImpl preguntaRepository;

    @InjectMocks
    ExamenServiceImpl service;


    @Test
    void testSpy() {
        //spy utilise l'implementation complete

        //Attention à ne pas utiliser when avec les spy, car à méthode est réellement appélée
        //seul la valeur de retour est modifiée.
        //préféré doReturn
        doReturn(Arrays.asList("aritmetica")).when(preguntaRepository).findPreguntasPorExamenId(anyLong());

        Examen examen = service.findExamenPorNombreConPreguntas("Matematicas");
        assertEquals(5, examen.getId());
        assertEquals("Matematicas", examen.getNombre());
        assertEquals(1, examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("aritmetica"));

        verify(repository).findAll(); //appelé de façon réel
        verify(preguntaRepository).findPreguntasPorExamenId(anyLong()); //appelé aussi, mais mocké

    }
}