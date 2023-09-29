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

    @Builder.Default
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cart")
    private List<Bread> breads;

    @ColumnDefault("0")
    @Column(nullable = false)
    private int itemCount;

    @Builder
    Cart(User user, List<Bread> breads, int itemCount){
        this.user = user;
        this.breads = breads;
        this.itemCount = itemCount;
    }
}
