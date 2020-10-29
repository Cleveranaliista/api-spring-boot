package com.api.cliente.controller;

import java.util.Optional;

import javax.persistence.PostUpdate;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.api.cliente.model.Cliente;
import com.api.cliente.service.ClienteRepository;
import com.api.cliente.service.ClienteService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private ClienteService service;

			
	@GetMapping  
	public ResponseEntity<?> findAll(Pageable pageable) {
		log.info("Request /clientes");
		return ResponseEntity.ok().body(service.findAll(pageable));
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable long id){
	   return repository.findById(id)
	           .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Cliente produto) {
		return ResponseEntity.created(
				ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produto.getId()).toUri())
				.body(service.save(produto));
	}


	@PutMapping(path = {"/{id}"}) 
    public ResponseEntity<Cliente> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Cliente newCliente)
    {
        Optional<Cliente> oldCliente = repository.findById(id);
        if(oldCliente.isPresent()){
        	Cliente cliente = oldCliente.get();
            cliente.setNome(newCliente.getNome());
            cliente.setStatus(newCliente.getStatus());
            repository.save(cliente);
            return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}











