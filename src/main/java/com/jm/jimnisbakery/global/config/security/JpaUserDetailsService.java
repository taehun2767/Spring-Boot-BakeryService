package com.jm.jimnisbakery.global.config.security;

import com.jm.jimnisbakery.domain.users.dao.UserRepository;
import com.jm.jimnisbakery.domain.users.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class JpaUserDetailsService  implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Supplier<UsernameNotFoundException> s = //예외 인스턴스 만들기 위한 공급자 선언
                () -> new UsernameNotFoundException(
                        "Problem during authentication");

        User user = userRepository
                .findByEmail(username)
                .orElseThrow(s);

        return new CustomUserDetails(user); //User 인스턴스를 CustomUserDetails 데코레이터로 래핑하고 반환
    }
}
