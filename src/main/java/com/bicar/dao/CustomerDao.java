package com.bicar.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bicar.entity.Customer;

@Repository
@Transactional
public interface CustomerDao extends JpaRepository<Customer, Integer>  {

}
