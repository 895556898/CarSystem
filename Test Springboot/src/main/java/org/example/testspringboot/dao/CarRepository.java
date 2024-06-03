package org.example.testspringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Collection<? extends Car> findAllById(long Id);

    Collection<? extends Car> findAllByCompany(String carCompany);

    Collection<? extends Car> findAllByType(String carType);
}