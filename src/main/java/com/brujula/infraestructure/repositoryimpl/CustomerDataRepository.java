package com.brujula.infraestructure.repositoryimpl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brujula.infraestructure.repositoryimpl.models.CustomerModel;

@Repository
public interface CustomerDataRepository extends JpaRepository<CustomerModel, Long>{

}
