package com.jm.jimnisbakery.domain.carts;

import com.jm.jimnisbakery.domain.breads.Bread;
import com.jm.jimnisbakery.domain.users.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "carts")
public class Cart {
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
    private int itemCount;

    @Builder
    Cart(User user, Bread bread, int itemCount){
        this.user = user;
        this.bread = bread;
        this.itemCount = itemCount;
    }
}
