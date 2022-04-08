package com.clemen.mvc.controllers;


import com.clemen.mvc.entity.Cliente;
import com.clemen.mvc.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    /**
     * Url de acceso
     * http://localhost:8081/api/clientes
     */


    private final String URL = "/api/clientes";

    @Autowired
    private ClienteService clienteService;


    /**
     *
     * Crear un cliente pasado por JSON
     */
    @PostMapping(URL)
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente){
        if(cliente.getId()!=null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(clienteService.crearCliente(cliente));
    }

    /**
     * Actualizar un cliente
     */
    @PutMapping(URL)
    public ResponseEntity<Cliente> actualizarCliente(@RequestBody Cliente cliente){
        if(clienteService.buscarPorId(cliente.getId())==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteService.actualizarCliente(cliente));
    }

    /**
     * Ver todos los clientes
     */
    @GetMapping(URL)
    public ResponseEntity<List<Cliente>> verClientes(){
        List<Cliente> clientes = clienteService.verTodosClientes();
        if(clientes.size()>0)
            return ResponseEntity.ok(clientes);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(URL + "/{id}")
    public ResponseEntity<Cliente> verCliente(@PathVariable Long id){
        if(clienteService.buscarPorId(id)!=null)
            return ResponseEntity.ok(clienteService.buscarPorId(id));
    return ResponseEntity.notFound().build();
    }

    @DeleteMapping(URL + "/{id}")
    public ResponseEntity<Cliente> borrarCliente(@PathVariable Long id){
        Cliente cliente = clienteService.buscarPorId(id);

        if(cliente==null)
            return ResponseEntity.notFound().build();

        clienteService.borrarCliente(clienteService.buscarPorId(id));
        return ResponseEntity.noContent().build();
    }

}
