package com.katekozlova.cargo.business.validation;


import com.google.common.collect.Sets;
import com.katekozlova.cargo.data.entity.*;
import com.katekozlova.cargo.data.repository.WaypointRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

@Component
public class OrderValidator implements Validator {

    static final Logger logger = LoggerFactory.getLogger(OrderValidator.class);

    @Override
    public boolean supports(Class<?> clazz) {
        return Order.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        final Order order = (Order) target;
        final Map<Cargo, Set<WaypointType>> cargos = new HashMap<>();

        if (order.getWaypoints() == null) {
            errors.rejectValue("waypoints", "order.waypoints.null");
        } else {
            for (Waypoint waypoint : order.getWaypoints()) {
                final Cargo cargo = waypoint.getCargo();
                final WaypointType waypointType = waypoint.getWaypointType();
                final Set<WaypointType> waypointTypes = cargos.get(cargo);
                if (waypointTypes == null) {
                    cargos.put(cargo, Sets.newHashSet(waypointType));
                } else {
                    waypointTypes.add(waypointType);
                }
            }

            for (Set<WaypointType> waypointTypes : cargos.values()) {
                if (!waypointTypes.containsAll(Arrays.asList(WaypointType.values()))) {
                    errors.rejectValue("waypoints", "order.waypoints.invalid");
                }
            }
        }


        if(order.getTruck() == null) {
            logger.error("null truck");
            errors.rejectValue("truck", "order.truck.invalid");
        }

        if (order.getDrivers() == null) {
            logger.error("null driver");
            errors.rejectValue("drivers", "order.drivers.null");
        } else if (order.getDrivers().size() != order.getTruck().getShiftSize()) {
            logger.error("need more drivers");
            errors.rejectValue("drivers", "order.drivers.invalid");
        }
    }
}
