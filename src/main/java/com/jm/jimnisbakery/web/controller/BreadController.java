package com.jm.jimnisbakery.web.controller;

import com.jm.jimnisbakery.common.ApiResult;
import com.jm.jimnisbakery.common.JRoute;
import com.jm.jimnisbakery.common.StatusType;
import com.jm.jimnisbakery.domain.breads.Bread;
import com.jm.jimnisbakery.service.BreadService;
import com.jm.jimnisbakery.web.dto.BreadDto;
import com.jm.jimnisbakery.web.message.CreateBreadRequest;
import com.jm.jimnisbakery.web.message.UpdateBreadRequest;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class BreadController {
    BreadService breadService;

    public BreadController(BreadService breadService){
        this.breadService = breadService;
    }



    @GetMapping(value = JRoute.API_BREADS)
    public ApiResult<BreadDto> GetBreadDetails(@RequestParam Long breadId){
//        Long breadId = Bread.TryDecodeId(breadHashId);
        Bread bread = breadService.getBreadById(breadId);

        if(bread == null)
            return ApiResult.Failed(StatusType.NOT_FOUND_BREAD);

        BreadDto breadDto = new BreadDto(bread);
        return ApiResult.Succeed(breadDto);
    }


    @PostMapping(value = JRoute.API_BREADS)
    public ApiResult<BreadDto> CreateBread(@RequestBody CreateBreadRequest req){

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
        boolean isSuccess = breadService.saveBread(bread);
        if(!isSuccess)
            return ApiResult.Failed(StatusType.FAIL);

        BreadDto breadDto = new BreadDto(bread);
        return ApiResult.Succeed(breadDto);
    }

    @PutMapping(value = JRoute.API_BREADS)
    public ApiResult<BreadDto> UpdateBread(@RequestBody UpdateBreadRequest req){
        Bread bread = breadService.getBreadById(req.getBreadId());
        if(bread == null)
            return ApiResult.Failed(StatusType.NOT_FOUND_BREAD);

        if(req.getTitle() != null)
            bread.setTitle(req.getTitle());
        if(req.getDescription() != null)
            bread.setDescription(req.getDescription());
        if(req.getRemainingQuantity() != null)
            bread.setRemainingQuantity(req.getRemainingQuantity());
        if(req.getThumbnailUrl() != null)
            bread.setThumbnailUrl(req.getThumbnailUrl());
        if(req.getReviewRating() != null)
            bread.setReviewRating(req.getReviewRating());

        boolean isSuccess = breadService.saveBread(bread);
        if(!isSuccess)
            return ApiResult.Failed(StatusType.FAIL);

        BreadDto breadDto = new BreadDto(bread);
        return ApiResult.Succeed(breadDto);
    }

    @DeleteMapping(value = JRoute.API_BREADS)
    public ApiResult DeleteBread(@RequestParam Long breadId){
        int Status = breadService.deleteBreadById(breadId);
        return new ApiResult(Status);
    }
}
