package com.jm.jimnisbakery.domain.breads;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
@Table(name="breads")
public class Breads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //삭제할지 고민해봐야함
    @Column(nullable = true)
    private Long userId;

    @Column(length = 40, nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String thumbnailUrl;

    @Column
    private Integer viewOrder;

    @Column
    private LocalDate createdAt;

    @Column
    private LocalDate updatedAt;

    @Builder Breads(Long userId, String title, String description, String thumbnailUrl, Integer viewOrder, LocalDate createdAt, LocalDate updatedAt){
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.viewOrder = viewOrder;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
