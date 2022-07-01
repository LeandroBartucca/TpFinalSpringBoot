package com.bazar.bazarAPI.service;

import com.bazar.bazarAPI.dto.MayorVentaDTO;
import com.bazar.bazarAPI.model.Producto;
import com.bazar.bazarAPI.model.Venta;
import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    //CRUD
        //Create
    public void saveVenta(Venta venta);

        //Read
             //método para traer a todas las personas
    public List<Venta> getVentas();

            //lectura de un solo objeto
    public Venta findVenta(Long codigo_venta);

        //Update
    public void editVenta(Venta venta);

        //Delete
    public void deleteVenta(Long codigo_venta);
    
    public void deleteVentaLogic(Long codigo_venta);
    
    public void activacionVentaLogic(Long codigo_venta);

    //otros requerimientos
    public List<Producto> getProductosVenta(Long codigo_venta);

    public String getMontoCantidad(LocalDate fecha_venta);

    public MayorVentaDTO getMayorVenta();

}
