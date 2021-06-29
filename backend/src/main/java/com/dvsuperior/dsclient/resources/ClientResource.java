package com.dvsuperior.dsclient.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvsuperior.dsclient.entities.Client;
import com.dvsuperior.dsclient.services.clientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	@Autowired
	private clientService clientservice;
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		List<Client> list = clientservice.findAll();
		return ResponseEntity.ok().body(list);
	}
}
