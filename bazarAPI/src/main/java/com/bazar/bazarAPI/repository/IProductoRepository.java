package com.bazar.bazarAPI.repository;

import com.bazar.bazarAPI.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {

}
