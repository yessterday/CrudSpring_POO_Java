package com.applicationcrud.appcrud.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.applicationcrud.appcrud.Entities.Players;

@Repository
public interface PlayersRepository extends JpaRepository<Players, Long>{

    
} 
    

