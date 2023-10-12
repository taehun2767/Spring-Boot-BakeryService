package com.jm.jimnisbakery.web.controller;

import com.jm.jimnisbakery.common.ApiResult;
import com.jm.jimnisbakery.common.JRoute;
import com.jm.jimnisbakery.web.dto.BreadDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BreadController {
    @GetMapping(value = JRoute.API_BREADS)
    public ApiResult<BreadDto> GetBreadDetails(){

    }
}
