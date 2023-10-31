package com.br1.edubooks.model.dto.request;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

public record dtoBook_createData(
        @NotBlank(message = "¡Este campo no puede estar vacio!")
        String title,
        @NotNull(message = "¡Este campo no puede estar vacio!")
        @Digits(integer = 10, fraction = 0, message = "¡Sólo se aceptan caracteres numéricos!")
        Long authorId,
        @NotNull(message = "¡Este campo no puede estar vacio!")
        @Digits(integer = 10, fraction = 0, message = "¡Sólo se aceptan caracteres numéricos!")
        Long genreId,
        Date publicationDate,
        String description,
        Boolean isAvailable,
        Date availableSince,
        @NotBlank(message = "¡Este campo no puede estar vacio!")
        String filePath
) { }
