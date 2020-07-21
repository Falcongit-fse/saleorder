package com.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.inventory.entity.Sale;

public interface SaleRepository extends CrudRepository<Sale, Integer> {

}
