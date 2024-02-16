package MeLivra.apimeLivraComentarios.controllers;

import MeLivra.apimeLivraComentarios.domain.comentario.ComentarioRepository;
import MeLivra.apimeLivraComentarios.domain.comentario.Comentarios;
import MeLivra.apimeLivraComentarios.domain.comentario.RequestComentario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comentarios")
public class ComentariosController {
    @Autowired
    private ComentarioRepository repository;


    @GetMapping
    public ResponseEntity getAllComentarios(){
        var ALLComentarios = repository.findAll();
        return ResponseEntity.ok(ALLComentarios);
    }

    @PostMapping
    public  ResponseEntity registrarComentario(@RequestBody @Valid RequestComentario data ){
        System.out.println(data);
        Comentarios newcomentario = new Comentarios(data);
        repository.save(newcomentario);
        return ResponseEntity.ok().build();
    }

}
