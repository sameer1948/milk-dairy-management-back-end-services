package com.milk_dairy_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.milk_dairy_management.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}