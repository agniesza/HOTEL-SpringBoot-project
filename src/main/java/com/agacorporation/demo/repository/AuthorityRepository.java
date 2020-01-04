package com.agacorporation.demo.repository;

import com.agacorporation.demo.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority,String> {
    Authority findAuthorityByName(String name);

}
