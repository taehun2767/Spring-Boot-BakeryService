package com.jm.jimnisbakery.domain.breads;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreadRepository extends JpaRepository<Bread, Long> {
//    Page<Bread> findAllOrderByPaginSort
}
