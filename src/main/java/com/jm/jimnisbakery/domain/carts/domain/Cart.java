package com.jm.jimnisbakery.domain.carts.domain;

import com.jm.jimnisbakery.domain.breads.domain.Bread;
import com.jm.jimnisbakery.domain.users.domain.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hashids.Hashids;
import org.hibernate.annotations.ColumnDefault;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "carts")
//TODO cascade 및 N + 1 문제 공부 후 적용
public class Cart {

    private static Hashids hashids = new Hashids("this is my salt for carts", 6);
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bread_id")
    private Bread bread;

    @ColumnDefault("0")
    @Column(nullable = false)
    private Integer itemCount;

    @Builder
    Cart(User user, Bread bread, Integer itemCount){
        this.user = user;
        this.bread = bread;
        this.itemCount = itemCount;
    }
}
