package com.jm.jimnisbakery.domain.breads.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class SearchDto {
    protected int pageNumber;
    protected int itemSize;
    protected int pageSize;

    public SearchDto(){
        this.pageNumber = 0;
        this.itemSize = 10;
        this.pageSize = 10;
    }
}
