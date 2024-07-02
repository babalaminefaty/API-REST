package sn.faty.API.REST.services.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private  Long id ;
    //non null et non vide
    @NotEmpty(message = "le prenom est obligatoire")
    private  String firstName ;
    @NotEmpty(message = "le nom est obligatoire")
    private  String lastName;

    @NotEmpty(message = "l\'email est obligatoire")

    @Email(message = "l\'email doit etre correcte")
    private  String email ;

}
