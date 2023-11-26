package com.applicationcrud.appcrud.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.applicationcrud.appcrud.Entities.Guild;

@Repository
public interface GuildRepository extends JpaRepository<Guild, Long> {

    
    
}
