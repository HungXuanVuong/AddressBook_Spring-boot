package com.hung.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hung.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
