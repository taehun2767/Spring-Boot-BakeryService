package com.jm.jimnisbakery.domain.carts;


import com.jm.jimnisbakery.domain.breads.Bread;
import com.jm.jimnisbakery.domain.breads.BreadRepository;
import com.jm.jimnisbakery.domain.users.User;
import com.jm.jimnisbakery.domain.users.UserRepository;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartRepositoryTest {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    BreadRepository breadRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    @Transactional
    public void CreateCart(){
        //given
        String name = "ted";
        String loginToken = "testToken";
        String email = "test@snu.ac.kr";
        String snsId = "test@naver.com";
        String phoneNumber = "010-0000-0000";
        String address = "testAddress";

        User user = userRepository.save(User.builder()
                .name(name)
                .loginToken(loginToken)
                .email(email)
                .snsId(snsId)
                .phoneNumber(phoneNumber)
                .address(address)
                .build());

        String title = "title test";
        String description = "description test";
        String thumbnailUrl = "thumbnailUrl test";
        Integer remainingQuantity = 1;
        Integer viewOrder = 1;
        LocalDate createdAt = LocalDate.now();
        LocalDate updatedAt = LocalDate.now();
        String createdBy = "admin";


        Bread bread = breadRepository.save(Bread.builder()
                .title(title)
                .description(description)
                .thumbnailUrl(thumbnailUrl)
                .remainingQuantity(remainingQuantity)
                .viewOrder(viewOrder)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .createdBy(createdBy)
                .build());

        Cart cart = cartRepository.save(Cart.builder()
                .user(user)
                .bread(bread)
                .itemCount(3)
                .build());

        Cart insertedCart = cartRepository.getReferenceById(cart.getId());
        Hibernate.initialize(insertedCart.getUser());
        Hibernate.initialize(insertedCart.getBread());

        assertThat(cart.getItemCount()).isEqualTo(insertedCart.getItemCount());
        assertThat(cart.getUser().getId()).isEqualTo(insertedCart.getUser().getId());

    }
}
