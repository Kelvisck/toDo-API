package meuprojeto.todo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    @NotBlank
    private String username;

    @NotBlank(message = "Senha obrigatória")
    private String password;

    @NotBlank(message = "Email obrigatório")
    @Email(message = "Use email valido")
    private String email;

    private String role;

}
