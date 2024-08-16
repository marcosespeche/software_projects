package com.auth.auth.services;

import com.auth.auth.dtos.AuthResponseDTO;
import com.auth.auth.dtos.SignInDTO;
import com.auth.auth.dtos.SignUpDTO;
import com.auth.auth.entities.User;

public interface UserService extends BaseService<User, Long>{

    public AuthResponseDTO signUp(SignUpDTO signUpDTO) throws Exception;

    public AuthResponseDTO signIn(SignInDTO signInDTO) throws Exception;
}
