package MeLivra.apimeLivraComentarios.domain.comentario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestComentarioGet(
        @NotBlank
        @NotNull
        String instituto,
        @NotBlank
        @NotNull
        String nomeprofessor



) {
}
