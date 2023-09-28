package com.jm.jimnisbakery.domain.carts;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "carts")
public class Carts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long breadId;

    @ColumnDefault("0")
    @Column(nullable = false)
    private int itemCount;
    
    @Builder Carts(Long userId, Long breadId, int itemCount){
        this.userId = userId;
        this.breadId = breadId;
        this.itemCount = itemCount;
    }
}
