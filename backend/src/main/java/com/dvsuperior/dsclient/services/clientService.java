package com.dvsuperior.dsclient.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dvsuperior.dsclient.DTO.ClientDTO;
import com.dvsuperior.dsclient.entities.Client;
import com.dvsuperior.dsclient.repositories.clientRepository;

@Service
public class clientService {
	
	@Autowired
	private clientRepository clientrepository;
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll(){	
		List<Client> list =  clientrepository.findAll();	
		return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id){
		Optional<Client> obj = clientrepository.findById(id);
		Client entity = obj.get();
		return new ClientDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public ClientDTO insert(ClientDTO dto) {
	  Client entity = new Client();
	  entity.setBithDate(dto.getBirthDate());
	  entity.setChildren(dto.getChildren());
	  entity.setCpf(dto.getCpf());
	  entity.setIncome(dto.getIncome());
	  entity.setName(dto.getName());
	  entity = clientrepository.save(entity);
	  return new ClientDTO(entity);
	}
}
