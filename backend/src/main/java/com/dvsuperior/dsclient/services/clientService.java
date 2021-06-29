package com.dvsuperior.dsclient.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvsuperior.dsclient.entities.Client;
import com.dvsuperior.dsclient.repositories.clientRepository;

@Service
public class clientService {
	
	@Autowired
	private clientRepository clientrepository;
	
	public List<Client> findAll(){	
		return clientrepository.findAll();	
	}

}
