package com.jm.jimnisbakery.domain.users;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 32, nullable = false)
    private String name;

    @Column(length = 64, nullable = false)
    private String password;

    @Column(length = 64, nullable = false)
    private String email;

    @Column(length = 64, nullable = false)
    private String snsId;

    @Column(length = 20, nullable = false)
    private String phoneNumber;

    @Column(length =128, nullable = false)
    private String address;

    @Builder Users(String name, String password, String email, String snsId, String phoneNumber, String address){
        this.name = name;
        this.password = password;
        this.email = email;
        this.snsId = snsId;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
