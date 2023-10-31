package com.br1.edubooks.controller;


import com.br1.edubooks.model.domain.User;
import com.br1.edubooks.model.dto.request.dtoUser_createData;
import com.br1.edubooks.model.dto.request.dtoUser_loginData;
import com.br1.edubooks.model.dto.request.dtoUser_updateData;
import com.br1.edubooks.model.dto.response.dtoUser_dataDisplay;
import com.br1.edubooks.model.infrastructure.security.JWT_tokenService;
import com.br1.edubooks.model.infrastructure.security.dto_JWTtoken;

import com.br1.edubooks.model.repositories.IUserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class userController {

    //dependency injection via constructor
        private final IUserRepository userRepository;
        private AuthenticationManager authenticationManager;
        private JWT_tokenService jwt_tokenService;
        private PasswordEncoder passwordEncoder;

        public userController(IUserRepository userRepository, AuthenticationManager authenticationManager, JWT_tokenService jwt_tokenService, PasswordEncoder passwordEncoder) {
            this.userRepository = userRepository;
            this.authenticationManager = authenticationManager;
            this.jwt_tokenService = jwt_tokenService;
            this.passwordEncoder = passwordEncoder;
        }

    //LOGIN Auth method
        @PostMapping("/login")
        public ResponseEntity loginAuth(@RequestBody @Valid dtoUser_loginData dtoUser_loginData){
            Authentication authToken = new UsernamePasswordAuthenticationToken(dtoUser_loginData.username(), dtoUser_loginData.password());
            var authUser= authenticationManager.authenticate(authToken);
            var JWTtoken = jwt_tokenService.generateJWT((User) authUser.getPrincipal());
            return ResponseEntity.ok(new dto_JWTtoken(JWTtoken));
        }

    //CREATE method
        @PostMapping("/registrar")
        public ResponseEntity<dtoUser_dataDisplay> register(@RequestBody @Valid dtoUser_createData user, UriComponentsBuilder UriComponentsBuilder) {
            //encrypt password
            String encryptedPassword=passwordEncoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);
            //save into db
            User newUser = userRepository.save(new User(user));
            dtoUser_dataDisplay dtoUser_dataDisplay = new dtoUser_dataDisplay(newUser);

            URI url = UriComponentsBuilder.path("/usuario/mostrar/{id}").buildAndExpand(newUser.getId()).toUri();
            return ResponseEntity.created(url).body(dtoUser_dataDisplay);
        }


    //READ ONE method
        @GetMapping("/mostrar/{id}")
        @Transactional
        public ResponseEntity<dtoUser_dataDisplay> showOne(@PathVariable long id){
            User user = userRepository.getReferenceById(id);
            dtoUser_dataDisplay dtoUser_dataDisplay = new dtoUser_dataDisplay(user);

            return ResponseEntity.ok(dtoUser_dataDisplay);
        }


    //READ ALL method
        @GetMapping("/mostrar")
        public ResponseEntity<Page<dtoUser_dataDisplay>> show(@PageableDefault(size = 4, sort="name") Pageable pagination){

            //if done without using pagination, should return List<dtoUser_dataDisplay>
            //return IUserRepository.findAll().stream().map(dtoUser_dataDisplay::new).toList();

            return ResponseEntity.ok(userRepository.findByIsActiveTrue(pagination).map(dtoUser_dataDisplay::new));
        }

    //LOGICAL DELETE method (active - inactive switch)
        @DeleteMapping("/borrar/{i}")
        //this notation allows ONLY ADMIN USERS to access to this path
        //@Secured("ROLE_ADMIN")
        @Transactional
        public ResponseEntity delete(@PathVariable long i){
            User user = userRepository.getReferenceById(i);
            user.setIsActive(false);

            return ResponseEntity.noContent().build();
        }

    //UPDATE method
        @PutMapping("/editar/{i}")
        @Transactional
        public ResponseEntity<dtoUser_dataDisplay> edit(@PathVariable Long i, @RequestBody dtoUser_updateData userUpdateData){

            //get reference of user by id from db
            User userOldData= userRepository.getReferenceById(i);
            //use update method from User class passing the dtoUser_updateData as parameter
            userOldData.updateData(userUpdateData);
            //encrypt password
            userOldData.setPassword(passwordEncoder.encode(userOldData.getPassword()));

            dtoUser_dataDisplay dtoUser_dataDisplay = new dtoUser_dataDisplay(userOldData);

            return ResponseEntity.ok(dtoUser_dataDisplay);
        }

}