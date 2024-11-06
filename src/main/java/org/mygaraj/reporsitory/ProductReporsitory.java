package org.mygaraj.reporsitory;

import org.mygaraj.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductReporsitory extends CrudRepository<ProductEntity, Integer> {
//    Iterable<Object> findByName();
//
//    Iterable<Object> findByCategory();
}
