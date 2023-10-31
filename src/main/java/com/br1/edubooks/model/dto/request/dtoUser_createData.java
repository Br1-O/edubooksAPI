package com.br1.edubooks.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class dtoUser_createData {
        @NotBlank(message = "¡El campo usuario no puede estar vacio!")
        @Pattern(regexp = "^[a-zA-Z0-9\\-_]+$", message = "¡Sólo caracteres alfanúmericos y los caracteres especiales: - _ son aceptados!")
        private String username;

        @NotBlank(message = "¡El campo contraseña no puede estar vacio!")
        @Pattern(regexp = "^[A-Za-z0-9.,\\-_$]+$", message = "¡Sólo caracteres alfanúmericos y los caracteres especiales: . , - _ son aceptados!")
        private String password;

        @NotBlank(message = "¡El campo nombre no puede estar vacio!")
        @Pattern(regexp = "^[A-Za-zñ]+$", message = "¡Sólo se aceptan letras!")
        private String name;

        @NotBlank(message = "¡El campo apellido no puede estar vacio!")
        @Pattern(regexp = "^[A-Za-zñ]+$", message = "¡Sólo se aceptan letras!")
        private String lastname;

        @NotBlank(message = "¡El campo email no puede estar vacio!")
        @Email(message= "¡El email ingresado no es válido!")
        private String email;

}
