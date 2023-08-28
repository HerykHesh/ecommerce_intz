package com.test.ecommerce.repository;

import com.test.ecommerce.model.Cart;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends JpaRepository<Cart, String> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from cart where last_activity < now() - interval '10' minute")
    public void deleteAllInactivityCart();

}
