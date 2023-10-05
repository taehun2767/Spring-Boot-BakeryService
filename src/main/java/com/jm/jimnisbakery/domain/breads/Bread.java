package com.jm.jimnisbakery.domain.breads;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.hashids.Hashids;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name="breads")
//TODO cascade 및 N + 1 문제 공부 후 적용
public class Bread {

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
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(length = 256)
    private String thumbnailUrl;

    @ColumnDefault("0")
    private Integer viewOrder;

    @ColumnDefault("0")
    private Integer remainingQuantity;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    //for admin
    private String createdBy;

    @Builder
    Bread(String title, String description, String thumbnailUrl, Integer remainingQuantity, Integer viewOrder, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy){
        this.title = title;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.remainingQuantity = remainingQuantity;
        this.viewOrder = viewOrder;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
    }
}
