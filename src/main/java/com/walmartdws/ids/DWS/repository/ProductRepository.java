package com.walmartdws.ids.DWS.repository;

import com.walmartdws.ids.DWS.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
