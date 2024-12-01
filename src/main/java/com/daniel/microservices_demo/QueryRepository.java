package com.daniel.microservices_demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QueryRepository extends JpaRepository<QueryEntity, Long> {

}
