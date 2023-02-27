package com.stackabuse.hibernatedemo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, UUID> {

}
