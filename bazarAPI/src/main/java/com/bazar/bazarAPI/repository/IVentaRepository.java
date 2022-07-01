package com.bazar.bazarAPI.repository;

import com.bazar.bazarAPI.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {

}
