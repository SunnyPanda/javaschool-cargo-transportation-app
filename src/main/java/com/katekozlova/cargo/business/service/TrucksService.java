package com.katekozlova.cargo.business.service;

import com.katekozlova.cargo.data.entity.Truck;
import com.katekozlova.cargo.data.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrucksService {

    @Autowired
    private TruckRepository truckRepository;

}
