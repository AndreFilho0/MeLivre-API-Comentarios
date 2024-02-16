package MeLivra.apimeLivraComentarios.domain.comentario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.*;
import jakarta.persistence.*;

@Table(name="comentarios")
@Entity(name="comentarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Comentarios{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nomeuser;

    private String instituto;

    private String nomeprofessor;

    private String descricao;

    public Comentarios(RequestComentario requestComentario){
        this.nomeuser = requestComentario.nomeuser();
        this.instituto = requestComentario.instituto();
        this.nomeprofessor = requestComentario.nomeprofessor();
        this.descricao = requestComentario.descricao();

    }



}
