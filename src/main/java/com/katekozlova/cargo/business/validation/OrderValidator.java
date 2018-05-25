package com.katekozlova.cargo.business.validation;


import com.google.common.collect.Sets;
import com.katekozlova.cargo.data.entity.Cargo;
import com.katekozlova.cargo.data.entity.Order;
import com.katekozlova.cargo.data.entity.Waypoint;
import com.katekozlova.cargo.data.entity.WaypointType;
import com.katekozlova.cargo.data.repository.WaypointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class OrderValidator implements Validator {

    private final WaypointRepository waypointRepository;

    @Autowired
    public OrderValidator(WaypointRepository waypointRepository) {
        this.waypointRepository = waypointRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Order.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        System.out.println("OrderValidator.validate");
        System.out.println("target = [" + target + "], errors = [" + errors + "]");
        final Order order = (Order) target;
        final Map<Cargo, Set<WaypointType>> cargos = new HashMap<>();

        System.out.println("order" + order.getWaypoints());
        for (Waypoint waypoint : order.getWaypoints()) {
            final Cargo cargo = waypoint.getCargo();
            System.out.println("cargo" + cargo);
            final WaypointType waypointType = waypoint.getWaypointType();
            System.out.println("waypointType = " + waypointType);
            final Set<WaypointType> waypointTypes = cargos.get(cargo);
            System.out.println("waypointTypes = " + waypointTypes);
            if (waypointTypes == null) {
                cargos.put(cargo, Sets.newHashSet(waypointType));
            } else {
                waypointTypes.add(waypointType);
            }
        }

        System.out.println("cargos = " + cargos);

        for (Set<WaypointType> waypointTypes : cargos.values()) {
            if (!waypointTypes.containsAll(Arrays.asList(WaypointType.values()))) {
                System.out.println("ошибка");
                errors.rejectValue("waypoints", "order.waypoints.error", "Атата");
            }
        }
    }
}
