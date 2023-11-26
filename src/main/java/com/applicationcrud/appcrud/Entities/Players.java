package com.applicationcrud.appcrud.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "Players")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Players {
    // ID único dos players
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //nome dos players em questão
    private String nome;

     // Relacionamento muitos-para-um com a entidade Guilds
    @ManyToOne
    @JoinColumn(name = "Guild_id")
    // Anotação para evitar referências em loop
    @JsonBackReference
    private Guild Guild;

}