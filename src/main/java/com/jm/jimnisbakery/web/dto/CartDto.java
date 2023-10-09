package com.jm.jimnisbakery.web.dto;

import com.jm.jimnisbakery.domain.breads.Bread;
import com.jm.jimnisbakery.domain.carts.Cart;
import com.jm.jimnisbakery.domain.users.User;
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
