package com.projeto.seo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Refeicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dia;

    private int semana;

    private LocalTime horario;

    private String descricao;

    @OneToMany(mappedBy = "refeicao", cascade = CascadeType.ALL)
    private List<Alimento> alimentos;

    @ManyToOne
    @JsonIgnore
    private Usuario usuario;
}
