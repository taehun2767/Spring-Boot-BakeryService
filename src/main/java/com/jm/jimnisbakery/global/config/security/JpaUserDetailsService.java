package com.jm.jimnisbakery.global.config.security;

import com.jm.jimnisbakery.domain.users.dao.UserRepository;
import com.jm.jimnisbakery.domain.users.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JpaUserDetailsService  implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username).orElseThrow(
                () -> new UsernameNotFoundException("Invalid authentication")
        );

        return new CustomUserDetails(user);
    }
}
