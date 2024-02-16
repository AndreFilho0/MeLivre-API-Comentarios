package MeLivra.apimeLivraComentarios.domain.comentario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestComentarioUpdate(
        @NotBlank
         @NotNull
        String id,

        @NotBlank
        @NotNull
        String nomeuser,
        @NotBlank
        String instituto ,
        @NotBlank
        String nomeprofessor,
        @NotBlank
        String descricao
){
}
