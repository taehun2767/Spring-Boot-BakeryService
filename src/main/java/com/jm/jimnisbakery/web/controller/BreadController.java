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
        return breadService.getBreadDetails(breadId);
    }


    @PostMapping(value = JRoute.API_BREADS)
    public ApiResult<BreadDto> CreateBread(@RequestBody CreateBreadRequest req){
        return breadService.createBread(req);
    }

    @PutMapping(value = JRoute.API_BREADS)
    public ApiResult<BreadDto> UpdateBread(@RequestBody UpdateBreadRequest req){
        return breadService.updateBread(req);
    }

    @DeleteMapping(value = JRoute.API_BREADS)
    public ApiResult DeleteBread(@RequestParam Long breadId){
        int Status = breadService.deleteBreadById(breadId);
        return new ApiResult(Status);
    }
}
