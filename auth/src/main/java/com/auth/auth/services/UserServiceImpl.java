package com.auth.auth.services;

import com.auth.auth.dtos.AuthResponseDTO;
import com.auth.auth.dtos.SignInDTO;
import com.auth.auth.dtos.SignUpDTO;
import com.auth.auth.entities.User;
import com.auth.auth.enums.UserRole;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.auth.auth.config.JwtServiceImpl;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService{

    @Autowired
    private JwtServiceImpl jwtService;

    @Override
    public AuthResponseDTO signIn(SignInDTO signInDTO) {
        return null;
    }

    @Override
    @Transactional
    public AuthResponseDTO signUp(SignUpDTO signUpDTO) throws Exception {
        try {

            if (signUpDTO.getEmail() == null || signUpDTO.getEmail().isEmpty()) throw new IllegalArgumentException("Email cannot be null");
            if (signUpDTO.getUsername() == null || signUpDTO.getUsername().isEmpty()) throw new IllegalArgumentException("Username cannot be null");
            if (signUpDTO.getPassword() == null || signUpDTO.getPassword().isEmpty()) throw new IllegalArgumentException("Email cannot be null");

            User user = User.builder()
                    .username(signUpDTO.getUsername())
                    .email(signUpDTO.getEmail())
                    .password(signUpDTO.getPassword())
                    .userRole(UserRole.TEAM_MEMBER)
                    .userSoftDeleteDate(null)
                    .build();

            this.baseRepository.save(user);

            return AuthResponseDTO.builder()
                    .token(jwtService.getToken(user))
                    .build();

        } catch (Exception e) {
            throw new Exception("Error registering user: " + e.getMessage(), e);
        }

    }
}
