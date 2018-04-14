package com.katekozlova.cargo.data.repository;

import com.katekozlova.cargo.data.entity.Cargo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Long> {
}
