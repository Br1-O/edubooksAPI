package com.br1.edubooks.model.dto.request;

import com.br1.edubooks.model.domain.Address;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

public record dtoUser_updateData(@NotNull Long id,
        @Pattern(regexp = "^[a-zA-Z0-9\\-_]+$", message = "¡Sólo caracteres alfanúmericos y los caracteres especiales: - _ son aceptados!")
        String username,
        @Pattern(regexp = "^[A-Za-z0-9.,\\-_$]+$", message = "¡Sólo caracteres alfanúmericos y los caracteres especiales: . , - _ son aceptados!")
        String password,
        //@Pattern(regexp = "^[0-9]+$", message = "¡Sólo caracteres númericos son aceptados!")
        //int planTypeId,
         //@Pattern(regexp = "^[0-9]+$", message = "¡Sólo caracteres númericos son aceptados!")
         //int role,
        @Pattern(regexp = "^[A-Za-zñ]+$", message = "¡Sólo se aceptan letras!")
        String name,
        @Pattern(regexp = "^[A-Za-zñ]+$", message = "¡Sólo se aceptan letras!")
        String lastname,
        @Email(message= "¡El email ingresado no es válido!")
        String email,
        @Pattern(regexp = "^[0-9\\-+]+$", message = "¡Sólo caracteres númericos y los caracteres especiales: + - son aceptados!")
        String phone,
        Date birthday,
        @Pattern(regexp = "^[A-Za-z0-9.\\-_]+$", message = "¡Sólo caracteres alfanúmericos y los caracteres especiales: . - _ son aceptados!")
        String profilePicture,
        String bio,
        String socialMediaLinks,
        Address address
) { }