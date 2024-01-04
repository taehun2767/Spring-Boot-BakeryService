package com.jm.jimnisbakery.domain.breads.controller;

import com.jm.jimnisbakery.global.common.ApiResult;
import com.jm.jimnisbakery.global.common.JRoute;
import com.jm.jimnisbakery.domain.breads.service.BreadService;
import com.jm.jimnisbakery.domain.breads.dto.BreadDto;
import com.jm.jimnisbakery.domain.breads.dto.CreateBreadRequest;
import com.jm.jimnisbakery.domain.breads.dto.UpdateBreadRequest;
import org.springframework.web.bind.annotation.*;

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
