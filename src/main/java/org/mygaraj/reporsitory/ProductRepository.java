package org.mygaraj.reporsitory;

import org.mygaraj.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
//    Iterable<Object> findByName();
//
//    Iterable<Object> findByCategory();
}
