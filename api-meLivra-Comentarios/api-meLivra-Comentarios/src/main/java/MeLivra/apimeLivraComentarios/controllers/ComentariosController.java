package MeLivra.apimeLivraComentarios.controllers;

import MeLivra.apimeLivraComentarios.domain.comentario.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/comentarios")
public class ComentariosController {
    @Autowired
    private ComentarioRepository repository;


    @GetMapping
    public ResponseEntity getAllComentarios(@RequestBody @Valid RequestComentarioGet data ){
        var ALLComentarios = repository.findAllByNomeprofessor(data.nomeprofessor().toUpperCase());
        if(ALLComentarios.size()==0){
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok(ALLComentarios);
    }

    @PostMapping
    public  ResponseEntity registrarComentario(@RequestBody @Valid RequestComentario data ){

        Comentarios newcomentario = new Comentarios(data);
        newcomentario.setNomeprofessor(data.nomeprofessor().toUpperCase());

        repository.save(newcomentario);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public  ResponseEntity atualizarComentarios(@RequestBody @Valid RequestComentarioUpdate data){
        Optional<Comentarios> optionalComentario = repository.findById(data.id());
        if(optionalComentario.isPresent()){
            Comentarios comentario = optionalComentario.get();
            comentario.setNomeuser(data.nomeuser());
            comentario.setInstituto(data.instituto());
            comentario.setNomeprofessor(data.nomeprofessor());
            comentario.setDescricao(data.descricao());
           return ResponseEntity.ok(comentario);
        }else {
           throw new EntityNotFoundException();
        }


    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteComentarios(@PathVariable String id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

}
