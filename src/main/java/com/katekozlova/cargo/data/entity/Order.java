package com.katekozlova.cargo.data.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @SequenceGenerator(name = "order_generator", sequenceName = "order_sequence", initialValue = 10)
    @GeneratedValue(generator = "order_generator")
    private long id;

    @Column(name = "unique_number")
    private long uniqueNumber;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus orderStatus;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orders")
//    private Set<Waypoint> waypoints;


}
