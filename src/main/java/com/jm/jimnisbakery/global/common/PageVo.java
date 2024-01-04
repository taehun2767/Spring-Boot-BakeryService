package com.jm.jimnisbakery.global.common;

import com.jm.jimnisbakery.domain.breads.dto.SearchDto;

public class PageVo {
    private long totalItemCount;
    private int totalPageCount;
    private int startPage;
    private int endPage;
    private int currentPage;
    private int startIndex;
    private boolean isExistPrevPage;
    private boolean isExistNextPage;

    public PageVo(long totalItemCount, SearchDto params){
        calculatePageParameters(totalItemCount, params);
    }

    private void calculatePageParameters(long totalItemCount, SearchDto params){
        this.totalItemCount = Math.max(0, totalItemCount);
        this.totalPageCount = Math.max(1, (int) (totalItemCount-1)/params.getItemSize() + 1);

        currentPage = params.getPageNumber();
        if(currentPage < 1){
            currentPage = 1;
        }
        if(currentPage > totalPageCount){
            currentPage = totalPageCount;
        }
        int lowerBound = Math.floorDiv(params.getPageSize(), 2);
        int upperBound = Math.ceilDiv(params.getPageSize(), 2) - 1;

        startPage = Math.max(1, currentPage - lowerBound);
        endPage = Math.min(currentPage + upperBound, totalPageCount);

        startIndex = (params.getPageNumber() - 1) * params.getItemSize();

        isExistPrevPage = startPage != 1;
        isExistNextPage = endPage < totalPageCount;

    }
}
