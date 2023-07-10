package com.farmadavlia.medicamentos.domain.models;


import com.farmadavlia.medicamentos.domain.enums.TipoAplicacao;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InformacoesInjetaveisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idInformacoesInjetaveis;
    private TipoAplicacao tipoAplicacao;
    @OneToOne(mappedBy = "informacoesInjetaveisEntity")
    private MedicamentoEntity medicamentoEntity;
}
