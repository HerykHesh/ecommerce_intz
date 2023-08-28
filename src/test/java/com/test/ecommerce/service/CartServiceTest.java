package com.test.ecommerce.service;


import com.test.ecommerce.model.Cart;
import com.test.ecommerce.model.mapper.ProductMapper;
import com.test.ecommerce.model.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@SpringBootTest
public class CartServiceTest {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    CartService cartService;


    @BeforeAll
    static void setup() {
        log.info("Setup");
    }

    @BeforeEach
    void init() {
        log.info("Before each test");
    }


    @Test
    @DisplayName("Should create a new cart")
    void addCart() {

        String cartId = cartService.add();
        Assertions.assertTrue(isValidUuid(cartId));
        log.info("Cart id created: " + cartId);

    }

    public static boolean isValidUuid(String uuid) {
        String regex = "[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(uuid);
        return matcher.matches();
    }

}