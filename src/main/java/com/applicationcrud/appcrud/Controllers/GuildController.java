package com.applicationcrud.appcrud.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.applicationcrud.appcrud.Entities.Guild;
import com.applicationcrud.appcrud.Entities.Players;
import com.applicationcrud.appcrud.Repositories.GuildRepository;

@RestController
@RequestMapping("/api/Guilds")
public class GuildController {

    @Autowired
    private GuildRepository guildRepository;

    @GetMapping
    public Iterable<Guild> getAllGuilds() {
        Iterable<Guild> guilds = guildRepository.findAll();
        
        for (Guild guild : guilds) {
            guild.setPlayers(guild.getPlayers());
        }
        return guilds;
    }
    
    @GetMapping("/{id}")
    public Guild getGuildByid(@PathVariable Long id) {
        return guildRepository.findById(id).orElse(null);

    }

    @PostMapping
    public Guild createGuild(@RequestBody Guild guild) {
        return guildRepository.save(guild);

    }
    @PutMapping("/{id}")
    public Guild updateGuild(@PathVariable Long id, @RequestBody Guild guild) {
        
        if (guildRepository.findById(id).orElse(null) == null) {
            return null;
            
        } else {
            guild.setId(id);
            return guildRepository.save(guild);
        }

    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuild(@PathVariable Long id) {

        Guild guild = guildRepository.findById(id).orElse(null);

        if (guild != null) {
            try {

                List<Players> players = guild.getPlayers();
                for (Players player : players) {
                    player.setGuild(null);
                }
                guildRepository.delete(guild);
                return ResponseEntity.noContent().build();
            } catch (Exception e) {
                return ResponseEntity.status(500).build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
 }
