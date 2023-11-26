package com.applicationcrud.appcrud.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.applicationcrud.appcrud.Entities.Players;
import com.applicationcrud.appcrud.Repositories.PlayersRepository;

@RestController
@RequestMapping("/api/Players")
public class PlayersController {

    @Autowired
    private PlayersRepository PlayersRepository;
    
    @GetMapping
    public Iterable<Players> getAllPlayers() {
        return PlayersRepository.findAll();

    }
    
    @GetMapping("/{id}")
    public Players getPlayerById(@PathVariable Long id) {
        return PlayersRepository.findById(id).orElse(null);
    
    } 

    @PostMapping
    public Players creatPlayers(@RequestBody Players players) {
        return PlayersRepository.save(players);
    }

    @PutMapping("/{id}")
    public Players updatPlayers(@PathVariable Long id, @RequestBody Players players) {
        if (PlayersRepository.findById(id).orElse(null) == null) {
            return null;
        } else {
            players.setId(id);
            return PlayersRepository.save(players);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayers(@PathVariable Long id) {
        try {
            PlayersRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    
}
