package com.example.demo.data;

import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<ContactEntity, Long> {
}
