package com.bazar.bazarAPI.service;

import com.bazar.bazarAPI.dto.MayorVentaDTO;
import com.bazar.bazarAPI.model.Producto;
import com.bazar.bazarAPI.model.Venta;
import com.bazar.bazarAPI.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository repoVenta;

    //Create
    @Override
    public void saveVenta(Venta venta) {
        repoVenta.save(venta);
    }

    //Read
    @Override
    public List<Venta> getVentas() {
        List<Venta> listaVentas = repoVenta.findAll();
        List<Venta> listaVentas2 = new ArrayList<Venta>();

        for (Venta venta : listaVentas) {

            if (venta.isBorrado() == false) {

                listaVentas2.add(venta);

            }

        }

        return listaVentas2;
    }

    @Override
    public Venta findVenta(Long codigo_venta) {

        return repoVenta.findById(codigo_venta).orElse(null);
    }

    //Update
    @Override
    public void editVenta(Venta venta) {
        this.saveVenta(venta);
    }

    //Delete
    @Override
    public void deleteVenta(Long codigo_venta) {
        repoVenta.deleteById(codigo_venta);
    }

    @Override
    public void deleteVentaLogic(Long codigo_venta) {
        this.findVenta(codigo_venta).setBorrado(true);
        repoVenta.flush();
    }

    @Override
    public void activacionVentaLogic(Long codigo_venta) {
        this.findVenta(codigo_venta).setBorrado(false);
        repoVenta.flush();
    }

    //Otros requerimientos
    @Override
    public List<Producto> getProductosVenta(Long codigo_venta) {
        Venta venta = this.findVenta(codigo_venta);

        List<Producto> listaProductosVenta = venta.getListaProductos();

        return listaProductosVenta;
    }

    @Override
    public String getMontoCantidad(LocalDate fecha_venta) {
        List<Venta> listaVentas = this.getVentas();
        double monto = 0;
        int cantidad = 0;

        for (Venta venta : listaVentas) {
            if (venta.getFecha_venta().equals(fecha_venta)) {
                monto = monto + venta.getTotal();
                cantidad++;
            }
        }
        return "La cantidad de ventas del dia " + fecha_venta + " es de: " + cantidad + ", con un monto total de: " + monto;
    }

    @Override
    public MayorVentaDTO getMayorVenta() {
        List<Venta> listaVentas = this.getVentas();
        Venta venta = new Venta();
        venta.setTotal(0.0);

        for (Venta venta2 : listaVentas) {
            if (venta2.getTotal() > venta.getTotal()) {
                venta = venta2;
            }
        }

        MayorVentaDTO mayorVenta = new MayorVentaDTO();

        mayorVenta.setCodigo_venta(venta.getCodigo_venta());
        mayorVenta.setTotal(venta.getTotal());
        mayorVenta.setCantidad_productos(venta.getListaProductos().size());
        mayorVenta.setNombre_cliente(venta.getUnCliente().getNombre());
        mayorVenta.setApellido_cliente(venta.getUnCliente().getApellido());

        return mayorVenta;
    }

}
