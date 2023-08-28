package com.test.ecommerce.controller;

import com.test.ecommerce.model.Cart;
import com.test.ecommerce.model.vo.ProductVO;
import com.test.ecommerce.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api( value = "REST API - Cart", tags = {"Cart"} )
@RestController
@RequestMapping("/ecommerce/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @ApiOperation(
            value = "Create a new cart",
            response = Cart.class,
            responseContainer = "Cart",
            nickname = "createCart"
    )
    @PostMapping("")
    public String newCart() {
        return cartService.add();
    }

    @ApiOperation(
            value = "Gets a cart",
            response = Cart.class,
            responseContainer = "Cart",
            nickname = "getCart"
    )
    @GetMapping("/{id}")
    public Cart getCart(@PathVariable String id) {
        return cartService.get(id);
    }

    @ApiOperation(
            value = "Delete a cart",
            response = Cart.class,
            responseContainer = "Cart",
            nickname = "deleteCart"
    )
    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable String id) {
        cartService.delete(id);
    }

    @ApiOperation(
            value = "Add a product to the cart",
            response = Cart.class,
            responseContainer = "Cart",
            nickname = "addProduct"
    )
    @PutMapping("/{id}/product")
    public void addProduct(@PathVariable String id, @RequestBody List<ProductVO> productVO) {
        cartService.updateCart(id, productVO);
    }

}
