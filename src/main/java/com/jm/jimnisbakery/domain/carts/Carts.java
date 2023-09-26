package com.jm.jimnisbakery.domain.carts;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "carts")
public class Carts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;

    @Column
    private Long breadId;

    @Column
    private int itemCount;


    @Builder Carts(Long userId, Long breadId, int itemCount){
        this.userId = userId;
        this.breadId = breadId;
        this.itemCount = itemCount;
    }
}
