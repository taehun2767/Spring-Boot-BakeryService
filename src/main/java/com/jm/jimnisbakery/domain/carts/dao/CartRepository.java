package com.jm.jimnisbakery.domain.carts.dao;

import com.jm.jimnisbakery.domain.carts.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
