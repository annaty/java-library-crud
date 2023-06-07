package com.anna.library.services;

import com.anna.library.entities.Author;
import com.anna.library.entities.Book;
import com.anna.library.entities.Client;
import com.anna.library.repositories.BookLendingRepository;
import com.anna.library.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    BookLendingRepository bookLendingRepository;

    public boolean isRepositoryEmpty() {
        return clientRepository.count() == 0;
    }

    public Client getClient(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Iterable<Client> getAuthors() {
        return clientRepository.findAll();
    }

    public Client newClient(Client client) {
        return clientRepository.save(client);
    }

}
