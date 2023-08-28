package com.test.ecommerce.service;

import com.test.ecommerce.exception.CartException;
import com.test.ecommerce.model.Cart;
import com.test.ecommerce.model.Product;
import com.test.ecommerce.model.mapper.ProductMapper;
import com.test.ecommerce.model.vo.ProductVO;
import com.test.ecommerce.repository.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductMapper productMapper;

    public String add() {
        try {
            Cart cart = new Cart();
            cart.setLastActivity(LocalDateTime.now());
            cartRepository.save(cart);
            return cart.getId();
        }
        catch(Exception e) {
            throw new CartException("");
        }
    }

    public Cart get(String cartId) {
        log.info("Getting cart with ID " + cartId);
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new CartException("Cart there isn't!"));
        if ( cart.getLastActivity().plusMinutes(10).isBefore(LocalDateTime.now()) ) {
            delete(cartId);
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Cart time expired!");
            throw new CartException("Cart time expired!");
        }
        return cart;
    }

    public void delete(String id) {
        try {
            log.info("Deleting cart with ID " + id);
            cartRepository.deleteById(id);
            log.info("Cart with ID " + id + " has been deleted.");

        } catch (Exception e) {
            throw new CartException("Unable to delete cart with ID " + id);
        }
    }

    public void updateCart(String cartId, List<ProductVO> productVos) {
        try {
            Cart cart = get(cartId);

            List<Product> products = productMapper.convert(productVos);
            products.stream().forEach(product -> product.setCart(cart));

            cart.getProducts().clear();
            cart.getProducts().addAll(products);
            cart.setLastActivity(LocalDateTime.now());

            cartRepository.save(cart);
        } catch (Exception e) {
            throw new CartException("");
        }
    }


    public void deleteAllInactivityCart() {
        cartRepository.deleteAllInactivityCart();
    }
}
