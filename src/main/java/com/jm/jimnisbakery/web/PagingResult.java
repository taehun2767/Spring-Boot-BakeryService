package com.jm.jimnisbakery.web;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PagingResult<T> {
    private List<T> dtoList = new ArrayList<>();
    private PageVo pageVo;

    public PagingResult(List<T> dtoList, PageVo pageVo){
        this.dtoList = dtoList;
        this.pageVo = pageVo;
    }
}
