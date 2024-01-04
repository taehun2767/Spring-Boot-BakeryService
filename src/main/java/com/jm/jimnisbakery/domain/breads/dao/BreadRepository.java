package com.jm.jimnisbakery.domain.breads.dao;

import com.jm.jimnisbakery.domain.breads.domain.Bread;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreadRepository extends JpaRepository<Bread, Long> {
//    Page<Bread> findAllOrderByPaginSort
}
