package com.dvsuperior.dsclient.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dvsuperior.dsclient.DTO.ClientDTO;
import com.dvsuperior.dsclient.entities.Client;
import com.dvsuperior.dsclient.repositories.clientRepository;
import com.dvsuperior.dsclient.services.exceptions.DataBaseException;
import com.dvsuperior.dsclient.services.exceptions.ResourceNotFoundException;

@Service
public class clientService {

	@Autowired
	private clientRepository clientrepository;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(Pageable pageable) {
	Page<Client> list = clientrepository.findAll(pageable);
		return list.map(x -> new ClientDTO(x));
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
	Optional<Client> obj = clientrepository.findById(id);
	Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
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

	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
			Client entity = clientrepository.getOne(id);
			entity.setBithDate(dto.getBirthDate());
			entity.setChildren(dto.getChildren());
			entity.setCpf(dto.getCpf());
			entity.setIncome(dto.getIncome());
			entity.setName(dto.getName());
			entity = clientrepository.save(entity);
			return new ClientDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Entity not found" + id);
		}
	}

	public void delete(Long id) {
		try {
			clientrepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new DataBaseException("Entity not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity Exception");
		}
	}
}
