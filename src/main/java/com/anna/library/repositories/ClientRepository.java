package com.anna.library.repositories;

import com.anna.library.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,Long > {
}
