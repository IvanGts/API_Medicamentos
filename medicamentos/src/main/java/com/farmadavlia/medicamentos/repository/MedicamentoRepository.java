package com.farmadavlia.medicamentos.repository;

import com.farmadavlia.medicamentos.domain.models.MedicamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MedicamentoRepository extends JpaRepository<MedicamentoEntity, Long> {

}
