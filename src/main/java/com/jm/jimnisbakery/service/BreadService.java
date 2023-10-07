package com.jm.jimnisbakery.service;

import com.jm.jimnisbakery.domain.breads.Bread;
import com.jm.jimnisbakery.domain.breads.BreadRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


public class BreadService {
    private final BreadRepository breadRepository;

    public BreadService(BreadRepository breadRepository){
        this.breadRepository = breadRepository;
    }

    /*
     * 전체 리스트 가져오기
     */
    //TODO 인기도 순
    //TODO 최신 등록 순
    public Page<Bread> getBreadsOrderByCreatedAtDescending(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<Bread> breads = breadRepository.findAll(pageable);

        return breads;
    }

    //TODO 낮은 가격 순
    public Page<Bread> getBreadsOrderByPriceAscending(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("price").ascending());
        Page<Bread> breads = breadRepository.findAll(pageable);

        return breads;
    }

    //TODO 높은 가격 순
    public Page<Bread> getBreadsOrderByPriceDescending(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("price").descending());
        Page<Bread> breads = breadRepository.findAll(pageable);

        return breads;
    }

    //TODO 리뷰 많은 순 (새 테이블 필요)

    //TODO 평점 높은 순 (새 칼럼 필요)

    //TODO 할인율 순 (새 칼럼 필요)


    //TODO 빵 검색으로 가져오기

    //TODO 빵 세부 사항 가져오기
    public Bread GetBreadById(Long breadId){
        return breadRepository.findById(breadId).orElse(null);
    }


    /*
     * 어드민
     */
    //TODO 빵 생성
    public Bread saveBread(Bread bread){
        return breadRepository.save(bread);
    }

    //TODO 빵 정보 수정

    //TODO 빵 삭제




}
