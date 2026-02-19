package com.ejemplo.libreria.Util;

import com.ejemplo.libreria.Model.Libros;
import org.springframework.stereotype.Component;

@Component //Gestiona el ciclo de vida de la clase inyectando los componentes que necesite
public class ValidaLibros {
    public Libros libro;
    public boolean tituloValido(){

        return libro.getTitulo() !=null && !Boolean.parseBoolean(libro.getTitulo());
    }
}
