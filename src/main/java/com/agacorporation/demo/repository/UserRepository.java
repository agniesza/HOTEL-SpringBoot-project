package com.agacorporation.demo.repository;

import com.agacorporation.demo.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {


    User findByLogin(String login);

    @Query("SELECT v FROM User v WHERE " +
            "(" +
            ":phrase is null OR :phrase = '' OR "+
            "upper(v.firstName) LIKE upper(:phrase) OR " +
            "upper(v.lastName) LIKE upper(:phrase) OR " +
            "upper(v.phoneNumber) LIKE upper(:phrase) OR " +
            "upper(v.email) LIKE upper(:phrase) OR " +
            "upper(v.login) LIKE upper(:phrase)" +
            ") "

    )
    Page<User> findAllUsersUsingFilter(@Param("phrase") String p, Pageable pageable);

}
