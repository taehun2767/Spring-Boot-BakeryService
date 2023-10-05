package com.jm.jimnisbakery.domain.comments;

import com.jm.jimnisbakery.domain.breads.Bread;
import com.jm.jimnisbakery.domain.users.User;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Fetch;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hashids.Hashids;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "comments")
//TODO cascade 및 N + 1 문제 공부 후 적용
public class Comment {

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bread_id")
    private Bread bread;

    @Column(length = 200)
    private String description;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Builder
    Comment(User user, Bread bread, String description, LocalDateTime createdAt, LocalDateTime updatedAt){
        this.user = user;
        this. bread = bread;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
