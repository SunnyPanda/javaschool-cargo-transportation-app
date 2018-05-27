package com.katekozlova.cargo.business.validation;

import com.katekozlova.cargo.data.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class OrderTruckValidator implements Validator {

    static final Logger logger = LoggerFactory.getLogger(OrderValidator.class);

    @Override
    public boolean supports(Class<?> clazz) {
        return Order.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        final Order order = (Order) target;

        if (order.getTruck() == null) {
            logger.error("truck == 0");
            errors.rejectValue("truck", "order.truck.invalid");
        }
    }
}
