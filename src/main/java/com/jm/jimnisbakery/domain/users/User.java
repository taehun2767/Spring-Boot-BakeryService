package com.jm.jimnisbakery.domain.users;

import com.jm.jimnisbakery.domain.carts.Cart;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
//TODO cascade 및 N + 1 문제 공부 후 적용
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 32, nullable = false)
    private String name;

    @Column(length = 256, nullable = false)
    private String loginToken;

    @Column(length = 64)
    private String email;

    @Column(length = 64)
    private String snsId;

    @Column(length = 32)
    private String phoneNumber;

    @Column(length =256)
    private String address;

    @Builder
    User(String name, String loginToken, String email, String snsId, String phoneNumber, String address){
        this.name = name;
        this.loginToken = loginToken;
        this.email = email;
        this.snsId = snsId;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
