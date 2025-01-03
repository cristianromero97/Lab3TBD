package com.example.Lab1TBD.services;

import com.example.Lab1TBD.persistence.entities.CustomerOpinion;
import com.example.Lab1TBD.persistence.repositories.CustomerOpinionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerOpinionService {

    @Autowired
    private CustomerOpinionRepository customerOpinionRepository;

    //buscar por id de la opinion
    public CustomerOpinion findCustomerOpinionId(Long id) {
        return customerOpinionRepository.findCustomerOpinionById(id);
    }

    //buscar por el id del cliente asociada a la opinion
    public List<CustomerOpinion> findCustomerOpinionByCustomerId(Long customerId) {
        return customerOpinionRepository.findCustomerOpinionsByClientId(customerId);
    }

    //buscar por el id del producto asociado a la opinion
    public List<CustomerOpinion> findCustomerOpinionByProductId(Long productId) {
        return customerOpinionRepository.findCustomerOpinionsByProductId(productId);
    }

    //guardar la opinion del cliente
    public void keepCustomerOpinion(CustomerOpinion customerOpinion) {
        customerOpinionRepository.saveOpinion(customerOpinion);
    }

    //editar la opinion del cliente
    public void editCustomerOpinion(CustomerOpinion customerOpinion) {
        customerOpinionRepository.updateOpinion(customerOpinion);
    }

    //borrar la opinion
    public void eraseCustomerOpinion(Long opinion_id) {
        customerOpinionRepository.deleteOpinionById(opinion_id);
    }
}

