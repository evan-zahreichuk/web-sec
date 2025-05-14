package edu.zahr.websec.security;

/*
@author ivan
@project IntelliJ IDEA 
@class UserDetailsServiceImpl
@version 1.0.0 
@since 14.05.2025 - 21.41
*/

import edu.zahr.websec.user.Role;
import edu.zahr.websec.user.User;
import edu.zahr.websec.user.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

//     @PostConstruct
//  void init() {
//      User user = User.builder()
//              .firstName("John")
//              .lastName("Lennon")
//              .email("chnu@mail.com")
//              .password(passwordEncoder.encode("password"))
//              .enabled(true)
//              .accountLocked(false)
//              .roles(List.of(Role.USER))
//              .build();
//     repository.save(user);
//  }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        return repository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }
}