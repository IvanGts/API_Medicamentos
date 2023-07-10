package com.farmadavlia.medicamentos.mapper;


import com.farmadavlia.medicamentos.domain.dto.MedicamentoDTO;
import com.farmadavlia.medicamentos.domain.models.MedicamentoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MedicamentoMapper {

    public MedicamentoEntity converterMedicamentoDtoToEntity(MedicamentoDTO medicamentoDTO){
        MedicamentoEntity medicamentoEntity = new MedicamentoEntity();
        medicamentoEntity.setIdMedicamento(medicamentoDTO.getId());
        medicamentoEntity.setNomeMedicamento(medicamentoDTO.getNomeMedicamento());
        medicamentoEntity.setDescricao(medicamentoDTO.getDescricao());
        medicamentoEntity.setPreco(medicamentoDTO.getPreco());
        medicamentoEntity.setPrecoComDesconto(medicamentoDTO.getPrecoComDesconto());
        medicamentoEntity.setFabricante(medicamentoDTO.getFabricante());
        return medicamentoEntity;
    }

}
