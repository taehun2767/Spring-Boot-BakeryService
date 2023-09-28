package com.jm.jimnisbakery.domain.breads;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
@Table(name="breads")
public class Breads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 32, nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(length = 256)
    private String thumbnailUrl;

    @ColumnDefault("0")
    private Integer viewOrder;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    //for admin
    private String createdBy;

    @Builder Breads(String title, String description, String thumbnailUrl, Integer viewOrder, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy){
        this.title = title;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.viewOrder = viewOrder;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
    }
}
