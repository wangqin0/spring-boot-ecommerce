package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

// Spring Data REST supports pagination out of the box
@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);
    // Spring will execute a query similar to:
    //  `SELECT * FROM product WHERE category_id={id}`
    // And automatically exposes endpoint: /api/products/search/findByCategoryId?id={id}

    Page<Product> findByNameContaining(@Param("name") String name, Pageable pageable);
    // Spring will execute a query similar to:
    //  `SELECT * FROM product p
    //   WHERE p.name LIKE CONCAT('%', :{name}, '%')`
    // And automatically exposes endpoint: /api/products/search/findByNameContaining?name={name}

}
