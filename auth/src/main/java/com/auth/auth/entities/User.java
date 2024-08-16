package com.auth.auth.entities;

import com.auth.auth.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User extends BaseEntity implements UserDetails {

    @Column(name = "user_email", unique = true, nullable = false)
    private String email;

    @Column(name = "user_name", nullable = false)
    private String username;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "user_role", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    @Column(name = "user_softDeleteDate")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date userSoftDeleteDate;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    //The following methods are not actually used, since it's validated using the JWT

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
