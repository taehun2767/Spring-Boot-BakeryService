package com.jm.jimnisbakery.domain.users.domain;

import com.jm.jimnisbakery.global.config.security.Authority;
import com.jm.jimnisbakery.global.config.security.EncryptionAlgorithm;
import jakarta.persistence.*;
import lombok.*;
import org.hashids.Hashids;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter

@AllArgsConstructor
@Table(name = "users")
//TODO cascade 및 N + 1 문제 공부 후 적용
public class User {
    public  User (){
        // 기본 생성자 내의 초기화 코드 없이 비워둬도 됨
    }
    private static Hashids hashids = new Hashids("this is my salt for breads", 6);
    public static String EncodeId(Long id){
        return hashids.encode(id);
    }

    public static Long TryDecodeId(String hashId){
        long[] ids = hashids.decode(hashId);
        if(ids == null || ids.length < 1)
            return -1L;

        return ids[0];
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 32, nullable = false)
    private String name;

    @Column(length = 256, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private EncryptionAlgorithm algorithm;
    @Column(length = 64)
    private String email;

    @Column(length = 64)
    private String snsId;

    @Column(length = 32)
    private String phoneNumber;

    @Column(length =256)
    private String address;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Authority> authorities = new ArrayList<>();




    @Builder
    User(String name, String email, String snsId, String phoneNumber, String address,  List<Authority> authorities){
        this.name = name;
        this.email = email;
        this.snsId = snsId;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.authorities = authorities;
    }
}
