package com.auth.auth.controllers;

import com.auth.auth.dtos.SignInDTO;
import com.auth.auth.dtos.SignUpDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/auth")
public class UserControllerImpl {

    @PostMapping(path = "/sign-up")
    public ResponseEntity<?> signUp() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body("Hello from public endpoint");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("\"error\": " + "\"" + e.getMessage() + "\"");
        }
    }

    @PostMapping(path = "/sign-in")
    public ResponseEntity<?> signIn() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body("Hello from public endpoint");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("\"error\": " + "\"" + e.getMessage() + "\"");
        }
    }
}
