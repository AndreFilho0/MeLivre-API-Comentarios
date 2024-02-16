package MeLivra.apimeLivraComentarios.domain.comentario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentarios,String> {
    List<Comentarios> findAllByNomeprofessor(String nomeprofessor);

}
