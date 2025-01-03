package com.example.Lab1TBD.persistence.repositories;

import com.example.Lab1TBD.persistence.entities.CustomerOpinion;

import java.util.List;

public interface CustomerOpinionRepository {
    CustomerOpinion findCustomerOpinionById(Long opinion_id);
    List<CustomerOpinion> findCustomerOpinionsByProductId(Long product_id);
    List<CustomerOpinion> findCustomerOpinionsByClientId(Long client_id);

    void saveOpinion(CustomerOpinion opinion);
    void updateOpinion(CustomerOpinion opinion);
    void deleteOpinionById(Long opinion_id);
}