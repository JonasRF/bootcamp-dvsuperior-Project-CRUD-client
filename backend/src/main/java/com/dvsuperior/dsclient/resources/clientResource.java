package com.dvsuperior.dsclient.resources;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvsuperior.dsclient.entities.Client;

@RestController
@RequestMapping(value = "/clients")
public class clientResource {

	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		List<Client> list = new ArrayList<>();
		list.add(new Client(1L, "Maria Silva", "12345678901", 6500.0, Instant.parse("1994-07-20T10:30:00Z"), 2));
		list.add(new Client(2L, "Carlos Silva", "15695676701", 6500.0, Instant.parse("1999-07-10T10:50:00Z"), 2));
		return ResponseEntity.ok().body(list);
	}
}
