package com.projeto.seo.repositories;

import com.projeto.seo.entities.Refeicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefeicaoRepository extends JpaRepository<Refeicao, Long> {
}
