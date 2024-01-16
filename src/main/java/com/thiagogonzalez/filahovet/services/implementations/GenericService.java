package com.thiagogonzalez.filahovet.services.implementations;

import com.thiagogonzalez.filahovet.domain.entities.AbstractEntity;
import com.thiagogonzalez.filahovet.domain.exception.ResourceNotFoundException;
import com.thiagogonzalez.filahovet.repositories.GenericRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenericService<T extends AbstractEntity> {
    private final GenericRepository<T> repository;

    public GenericService(GenericRepository<T> repository) {
        this.repository = repository;
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public T findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
    }

    public T create(T entity) {
        return repository.save(entity);
    }

    public T update(Long id, T entity) {
        if (repository.existsById(id)) {
            return repository.save(entity);
        }
        throw new ResourceNotFoundException("Erro ao atualizar. Entidade não encontrada");
    }

    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        throw new ResourceNotFoundException("Erro ao atualizar. Entidade não encontrada");
    }
}
