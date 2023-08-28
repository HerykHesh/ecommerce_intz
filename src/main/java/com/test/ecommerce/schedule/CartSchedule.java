package com.test.ecommerce.schedule;

import com.test.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CartSchedule {

    @Autowired
    CartService cartService;

    @Scheduled(cron = "${schedule.cron.cleanInactivityCart}")
    private void deleteAllInativityCart() {
        cartService.deleteAllInactivityCart();
    }

}
