package com.ejemplo.libreria.Controlador;

import com.ejemplo.libreria.Model.Libros;
import com.ejemplo.libreria.RepoLibros.RepoLibros;
import com.ejemplo.libreria.Servicio.ServicioLibro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/libros")

public class ControladorLibreria {
    private final ServicioLibro libroServicio;
    private final RepoLibros libroRepositorio;

    public ControladorLibreria(ServicioLibro libroServicio, RepoLibros libroRepositorio) {
        this.libroServicio = libroServicio;

        this.libroRepositorio = libroRepositorio;
    }
    @GetMapping("/{titulo}")
    public String DameLibro(@PathVariable String titulo) {
        return libroServicio.buscaLibro(titulo);
    }

    @GetMapping("/todos")
    public List<Libros> dimeTodos(){
        return libroRepositorio.findAll();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Libros>buscaId(@PathVariable long id){
        return libroRepositorio.BuscaId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/clone")
    public String probarClone(){
        Libros original = new Libros(1L,"Miguel de Cervantes", "El Quijote", LocalDate.of(1605, 1, 16));
        Libros copia = original.clone();

        return "Original: " + original.toString() + " | Copia " + copia.toString();
    }




}
