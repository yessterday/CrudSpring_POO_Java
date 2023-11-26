package com.applicationcrud.appcrud.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Guild")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Guild {
    // Id único da Guilda
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    // Nome da Guilda
    private String Nome;
    // Relacionamento um-para-muitos com a entidade players
    @OneToMany(mappedBy = "Guild")
    // Anotação para evitar referências em loop
    @JsonManagedReference
    private List<Players> Players;


    
}