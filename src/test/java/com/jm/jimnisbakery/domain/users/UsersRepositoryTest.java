package com.jm.jimnisbakery.domain.users;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersRepositoryTest {

    @Autowired
    UserRepository usersRepository;

    @Test
    public void InsertUserTest(){
        //given
        String name = "ted";
        String loginToken = "testToken";
        String email = "abc2767@snu.ac.kr";
        String snsId = "zxc2876@naver.com";
        String phoneNumber = "010-0000-0000";
        String address = "testAddress";

        User insertedUser = usersRepository.save(User.builder()
                .name(name)
                .loginToken(loginToken)
                .email(email)
                .snsId(snsId)
                .phoneNumber(phoneNumber)
                .address(address)
                .build());

        //when
        User user = usersRepository.findById(insertedUser.getId()).orElse(null);

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
