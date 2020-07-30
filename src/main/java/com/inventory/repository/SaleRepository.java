package com.inventory.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.entity.Sale;

public interface SaleRepository extends CrudRepository<Sale, Integer> {

@Query(value="update product_inventory inventory set inventory.products_sold=:quantity where inventory.product_id=:product_id",nativeQuery = true)
@Modifying
@Transactional
public int updateProductSold(@Param("product_id")Integer productId,@Param("quantity")Integer quantity);
}
