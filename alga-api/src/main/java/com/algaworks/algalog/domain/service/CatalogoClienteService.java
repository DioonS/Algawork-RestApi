package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.exception.DomainException;
import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CatalogoClienteService {
    private ClienteRepository clienteRepository;

    public Cliente buscar(Long clienteId) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new DomainException("Cliente não encontrado!"));
    }
    @Transactional
    public Cliente salvar(Cliente cliente) {
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

        if (emailEmUso) {
            throw new DomainException("Já existe um cliente cadastrado com este e-mail.");
        }

        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long clientId) {
        clienteRepository.deleteById(clientId);
    }
}
