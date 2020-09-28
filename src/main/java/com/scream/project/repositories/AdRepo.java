package com.scream.project.repositories;

import com.scream.project.models.Ad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AdRepo extends CrudRepository<Ad,Long> {
    Optional<Ad> findByTitle(String title);
}
