package com.jm.jimnisbakery.domain.users;

import jakarta.transaction.Transactional;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("유저 생성")
    public void CreateUser(){
        //given
        String name = "ted";
        String loginToken = "testToken";
        String email = "test@snu.ac.kr";
        String snsId = "test@naver.com";
        String phoneNumber = "010-0000-0000";
        String address = "testAddress";

        User insertedUser = userRepository.save(User.builder()
                .name(name)
                .loginToken(loginToken)
                .email(email)
                .snsId(snsId)
                .phoneNumber(phoneNumber)
                .address(address)
                .build());

        //when
        User user = userRepository.findById(insertedUser.getId()).orElse(null);

        if(user == null)
            fail("failed to insert user");

        //then
        assertThat(user.getName()).isEqualTo(name);
        assertThat(user.getLoginToken()).isEqualTo(loginToken);
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getPhoneNumber()).isEqualTo(phoneNumber);
        assertThat(user.getAddress()).isEqualTo(address);
    }

}
