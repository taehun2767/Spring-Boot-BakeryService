package com.jm.jimnisbakery.domain.carts.dto;

import com.jm.jimnisbakery.domain.breads.domain.Bread;
import com.jm.jimnisbakery.domain.carts.domain.Cart;
import com.jm.jimnisbakery.domain.users.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class CartDto {
    public String cartHashId;
    public User user;
    public Bread bread;
    public Integer itemCount;

    public CartDto(String cartHashId, User user, Bread bread, Integer itemCount){
        this.cartHashId = cartHashId;
        this.user = user;
        this.bread = bread;
        this.itemCount = itemCount;
    }

    public CartDto(Cart cart){
        cartHashId = Cart.EncodeId(cart.getId());
        user = cart.getUser();
        bread = cart.getBread();
        itemCount = cart.getItemCount();
    }
}
