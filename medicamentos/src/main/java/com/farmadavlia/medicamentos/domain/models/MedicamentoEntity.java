package com.farmadavlia.medicamentos.domain.models;

import com.farmadavlia.medicamentos.domain.dto.MedicamentoDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
@Table(name = "medicamento")
public class MedicamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idMedicamento;
    @Column(name = "nome")
    private String nomeMedicamento;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "preco")
    private BigDecimal preco;
    @Column(name = "preco_com_desconto")
    private BigDecimal precoComDesconto;
    @Column(name = "marca")
    private String marca;
    @Column(name = "fabricante")
    private String fabricante;

    @OneToOne(mappedBy = "medicamentoEntity")
    private InformacoesInjetaveisEntity informacoesInjetaveisEntity;

    public static class MedicamentoEntityBuilder {

        public MedicamentoEntityBuilder informacoesInjetaveisEntity(InformacoesInjetaveisEntity informacoesInjetaveisEntity) {
            this.informacoesInjetaveisEntity = informacoesInjetaveisEntity;
            return this;
        }
    }
}
