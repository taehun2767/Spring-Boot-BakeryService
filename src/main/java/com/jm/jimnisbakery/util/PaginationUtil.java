package com.jm.jimnisbakery.util;

import com.jm.jimnisbakery.web.dto.SearchDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PaginationUtil {
    public static Pageable getPageable(SearchDto params, Sort sort){
        return PageRequest.of(params.getPageNumber(), params.getPageSize(), sort);
    }
}
