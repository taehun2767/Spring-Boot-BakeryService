package com.jm.jimnisbakery.service;

import com.jm.jimnisbakery.common.ApiResult;
import com.jm.jimnisbakery.common.StatusType;
import com.jm.jimnisbakery.domain.breads.Bread;
import com.jm.jimnisbakery.domain.breads.BreadRepository;
import com.jm.jimnisbakery.web.PageVo;
import com.jm.jimnisbakery.web.PagingResult;
import com.jm.jimnisbakery.web.dto.BreadDto;
import com.jm.jimnisbakery.web.dto.SearchDto;
import com.jm.jimnisbakery.web.message.CreateBreadRequest;
import com.jm.jimnisbakery.web.message.UpdateBreadRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BreadService {
    private final BreadRepository breadRepository;

    public BreadService(BreadRepository breadRepository){
        this.breadRepository = breadRepository;
    }
    private Logger logger = LoggerFactory.getLogger(BreadService.class);
    /*
     * 전체 리스트 가져오기
     * API단에서 정렬 순서 가져오도록 기획 변경
     */
    //TODO 인기도 순
    //TODO 최신 등록 순
    //TODO 낮은 가격 순
    //TODO 높은 가격 순
    //TODO 리뷰 많은 순 (새 테이블 필요)
    //TODO 평점 높은 순 (새 칼럼 필요)
    //TODO 할인율 순 (새 칼럼 필요)

    @Transactional(readOnly = true)
    public PagingResult<BreadDto> getBreadsOfPage(SearchDto pagingParams, Pageable pageable){
        //TODO 빵 검색으로 가져오는 필터 추가

        logger.info("offset : {}, pagesize : {}, pagenumber : {}", pageable.getOffset(), pageable.getPageSize(), pageable.getPageNumber());

        List<BreadDto> breadList = null;
        Page<Bread> breads = breadRepository.findAll(pageable);
        if(breads.hasContent() == false)
            return new PagingResult<>(Collections.emptyList(), null);

        breadList = breads.stream().map(BreadDto::new)
                .collect(Collectors.toList());
        long totalItemCount = breads.getTotalElements();
        PageVo pageVo = new PageVo(totalItemCount, pagingParams);

        return new PagingResult<>(breadList, pageVo);
    }

    public ApiResult<BreadDto> getBreadDetails(Long breadId)
    {
        Bread bread = getBreadById(breadId);

        if(bread == null)
            return ApiResult.Failed(StatusType.NOT_FOUND_BREAD);

        BreadDto breadDto = new BreadDto(bread);
        return ApiResult.Succeed(breadDto);
    }

    public Bread getBreadById(Long breadId){
        return breadRepository.findById(breadId).orElse(null);
    }

    public ApiResult<BreadDto> createBread(CreateBreadRequest req){
        Bread bread = Bread.builder()
                .title(req.getTitle())
                .description(req.getDescription())
                .remainingQuantity(req.getRemainingQuantity())
                .thumbnailUrl(req.getThumbnailUrl())
                .reviewRating(req.getReviewRating())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .createdBy(req.getCreatedBy())
                .build();
        Bread insertedBread = saveBread(bread);
        if(insertedBread.getId() <= 0)
            return ApiResult.Failed(StatusType.FAIL);

        BreadDto breadDto = new BreadDto(bread);
        return ApiResult.Succeed(breadDto);
    }

    public ApiResult<BreadDto> updateBread(UpdateBreadRequest req) {
        Bread bread = getBreadById(req.getBreadId());
        if (bread == null)
            return ApiResult.Failed(StatusType.NOT_FOUND_BREAD);

        if (req.getTitle() != null)
            bread.setTitle(req.getTitle());
        if (req.getDescription() != null)
            bread.setDescription(req.getDescription());
        if (req.getRemainingQuantity() != null)
            bread.setRemainingQuantity(req.getRemainingQuantity());
        if (req.getThumbnailUrl() != null)
            bread.setThumbnailUrl(req.getThumbnailUrl());
        if (req.getReviewRating() != null)
            bread.setReviewRating(req.getReviewRating());

        Bread insertedBread = saveBread(bread);
        if(insertedBread.getId() <= 0)
            return ApiResult.Failed(StatusType.FAIL);

        BreadDto breadDto = new BreadDto(bread);
        return ApiResult.Succeed(breadDto);
    }


    /*
     * 어드민
     */
    //TODO 빵 생성
    //TODO 빵 정보 수정
    public Bread saveBread(Bread bread){
        return  breadRepository.save(bread);
    }

    //TODO 빵 삭제
    public int deleteBreadById(Long breadId){
        //TODO 어드민인지 authorization 체크
        try{
            if(breadRepository.existsById(breadId) == false)
                return StatusType.NOT_FOUND_BREAD;
            breadRepository.deleteById(breadId);
            return StatusType.SUCCESS;
        }
        catch (Exception e){
            logger.error("delete bread is failed : " + e.getMessage(), e);
            return StatusType.FAIL;
        }

    }
}
