package com.dvsuperior.dsclient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dvsuperior.dsclient.entities.Client;

@Repository
public interface clientRepository extends JpaRepository<Client, Long>{

}
