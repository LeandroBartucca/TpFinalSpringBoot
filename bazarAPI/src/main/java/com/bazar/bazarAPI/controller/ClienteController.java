package com.bazar.bazarAPI.controller;

import com.bazar.bazarAPI.model.Cliente;
import com.bazar.bazarAPI.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService clieServ;

    //Create
    @PostMapping("/clientes/crear")
    public String saveCliente(@RequestBody Cliente clie) {
        clieServ.saveCliente(clie);

        return "El cliente fue creado correctamente";
    }

    //Read
    @GetMapping("/clientes")
    @ResponseBody
    public List<Cliente> getClientes() {

        return clieServ.getClientes();
    }

    @GetMapping("/clientes/{id_cliente}")
    @ResponseBody
    public Cliente getCliente(@PathVariable Long id_cliente) {

        return clieServ.findCliente(id_cliente);
    }

    //Update
    @PutMapping("/clientes/editar")
    public Cliente editCliente(@RequestBody Cliente clie) {
        clieServ.editCliente(clie);

        return clieServ.findCliente(clie.getId_cliente());

    }

    @PutMapping("/clientes/editar/{id_cliente}")
    public String editCliente(@PathVariable Long id_cliente,
            @RequestParam(required = false, name = "id_cliente") Long idNueva,
            @RequestParam(required = false, name = "nombre") String nombreNuevo,
            @RequestParam(required = false, name = "apellido") String apellidoNuevo,
            @RequestParam(required = false, name = "dni") String dniNuevo) {

        clieServ.editClienteId(id_cliente, idNueva, nombreNuevo, apellidoNuevo, dniNuevo);

        return "El cliente fue editado correctamente";
    }

    //Delete
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente) {
        clieServ.deleteCliente(id_cliente);

        return "El cliente fue eliminado correctamente";
    }
    
    @DeleteMapping("/clientes/eliminado-logico/{id_cliente}")
    public String deleteClienteLogic(@PathVariable Long id_cliente) {
        clieServ.deleteClienteLogic(id_cliente);

        return "El cliente fue eliminado logica y correctamente";
    }
    
    @PostMapping("/clientes/activado-logico/{id_cliente}")
    public String activacionClienteLogic(@PathVariable Long id_cliente) {
        clieServ.activacionClienteLogic(id_cliente);

        return "El cliente fue activado logica y correctamente";
    }

}
