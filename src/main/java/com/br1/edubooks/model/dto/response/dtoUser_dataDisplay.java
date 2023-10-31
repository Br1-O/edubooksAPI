package com.br1.edubooks.model.dto.response;


import com.br1.edubooks.model.domain.User;

public record dtoUser_dataDisplay(
        Long id,
        String username,
        String name,
        String lastname,
        String email
){
    public dtoUser_dataDisplay(User user) {
        this(user.getId(), user.getUsername(), user.getName(), user.getLastname(), user.getEmail());
    }
}
