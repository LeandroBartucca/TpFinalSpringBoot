package com.bazar.bazarAPI.controller;

import com.bazar.bazarAPI.dto.MayorVentaDTO;
import com.bazar.bazarAPI.model.Producto;
import com.bazar.bazarAPI.model.Venta;
import com.bazar.bazarAPI.service.IVentaService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentaController {

    @Autowired
    private IVentaService ventaServ;

    //Create
    @PostMapping("/ventas/crear")
    public String saveVenta(@RequestBody Venta venta) {
        ventaServ.saveVenta(venta);

        return "La venta fue creada correctamente";
    }

    //Read
    @GetMapping("/ventas")
    @ResponseBody
    public List<Venta> getVentas() {

        return ventaServ.getVentas();
    }

    @GetMapping("/ventas/{codigo_venta}")
    @ResponseBody
    public Venta getVenta(@PathVariable Long codigo_venta) {

        return ventaServ.findVenta(codigo_venta);
    }

    //Update
    @PutMapping("/ventas/editar")
    public Venta editVenta(@RequestBody Venta venta) {
        ventaServ.editVenta(venta);

        return ventaServ.findVenta(venta.getCodigo_venta());

    }

    //Delete
    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String deleteVenta(@PathVariable Long codigo_venta) {
        ventaServ.deleteVenta(codigo_venta);

        return "La venta fue eliminada correctamente";
    }

    @DeleteMapping("/ventas/eliminado-logico/{codigo_venta}")
    public String deleteVentaLogic(@PathVariable Long codigo_venta) {
        ventaServ.deleteVentaLogic(codigo_venta);

        return "La venta fue eliminada logica y correctamente";
    }
    
    @PostMapping("/ventas/activado-logico/{codigo_venta}")
    public String activacionVentaLogic(@PathVariable Long codigo_venta) {
        ventaServ.activacionVentaLogic(codigo_venta);

        return "La venta fue activada logica y correctamente";
    }

    //otros requerimientos
    @GetMapping("/ventas/productos/{codigo_venta}")
    @ResponseBody
    public List<Producto> getProductosVenta(@PathVariable Long codigo_venta) {

        return ventaServ.getProductosVenta(codigo_venta);
    }

    @GetMapping("/ventas/monto/{fecha_venta}")
    @ResponseBody
    public String getMontoYCantidad(@PathVariable String fecha_venta) {

        //Pido la fecha previamente en un String y en la siguiente linea la parseo
        LocalDate fecha = LocalDate.parse(fecha_venta);

        return ventaServ.getMontoCantidad(fecha);
    }

    @GetMapping("ventas/mayor_venta")
    @ResponseBody
    public MayorVentaDTO getMayorVenta() {

        return ventaServ.getMayorVenta();
    }

}
