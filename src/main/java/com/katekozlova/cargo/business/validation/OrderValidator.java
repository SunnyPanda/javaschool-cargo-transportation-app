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
import java.util.regex.Pattern;

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
        final Order order = (Order) target;
        final Map<Cargo, Set<WaypointType>> cargos = new HashMap<>();

//        Pattern personalNumberPattern = Pattern.compile("\\d+");
//        long number = order.getUniqueNumber();
//        if (!(personalNumberPattern.matcher(Long.toString(number))).matches() || number <= 0) {
//            errors.rejectValue("uniqueNumber", "order.uniqueNumber.invalid");
//        }

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
}
