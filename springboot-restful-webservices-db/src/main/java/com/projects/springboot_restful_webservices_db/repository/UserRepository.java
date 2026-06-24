package com.projects.springboot_restful_webservices_db.repository;

import com.projects.springboot_restful_webservices_db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //annotation is optional because jpa simplejparepositoy class already has this
public interface UserRepository extends JpaRepository<User, Long> {
}
