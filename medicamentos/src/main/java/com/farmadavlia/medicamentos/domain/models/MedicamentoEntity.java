package com.farmadavlia.medicamentos.domain.models;

import com.farmadavlia.medicamentos.domain.dto.MedicamentoDTO;
import com.farmadavlia.medicamentos.domain.enums.TipoAplicacao;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
    @Column(name = "categoria")
    private String tipoAplicacao;

}
