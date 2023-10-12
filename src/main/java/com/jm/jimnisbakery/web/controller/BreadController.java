package com.jm.jimnisbakery.web.controller;

import com.jm.jimnisbakery.common.ApiResult;
import com.jm.jimnisbakery.common.JRoute;
import com.jm.jimnisbakery.common.StatusType;
import com.jm.jimnisbakery.domain.breads.Bread;
import com.jm.jimnisbakery.service.BreadService;
import com.jm.jimnisbakery.web.dto.BreadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@RestController
public class BreadController {
    BreadService breadService;

    public BreadController(BreadService breadService){
        this.breadService = breadService;
    }

    @ResponseBody
    @GetMapping(value = JRoute.API_BREADS)
    public ApiResult<BreadDto> GetBreadDetails(@RequestParam Long breadId){
//        Long breadId = Bread.TryDecodeId(breadHashId);
        Bread bread = breadService.getBreadById(breadId);

        if(bread == null)
            return ApiResult.Failed(StatusType.NOT_FOUND_BREAD);

        BreadDto breadDto = new BreadDto(bread);
        return ApiResult.Succeed(breadDto);
    }

    @ResponseBody
    @PostMapping(value = JRoute.API_BREADS)
    public ApiResult CreateBread(){

    }
}
