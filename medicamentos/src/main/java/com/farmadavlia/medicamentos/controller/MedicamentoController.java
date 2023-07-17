package com.farmadavlia.medicamentos.controller;

import com.farmadavlia.medicamentos.domain.dto.MedicamentoDTO;
import com.farmadavlia.medicamentos.domain.dto.MedicamentoInjetavelDTO;
import com.farmadavlia.medicamentos.domain.enums.TipoAplicacao;
import com.farmadavlia.medicamentos.domain.models.MedicamentoEntity;
import com.farmadavlia.medicamentos.repository.MedicamentoRepository;
import com.farmadavlia.medicamentos.service.MedicamentoService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@AllArgsConstructor
@RequestMapping("/medicamento")
public class MedicamentoController {

    MedicamentoService medicamentoService;

    MedicamentoRepository medicamentoRepository;


    private static final String ERRO_AO_BUSCAR = "ERRO AO PROCESSAR SOLICITAÇÃO";
    private static final String SUCESSO_AO_PROCESSAR = "SUCESSO AO PROCESSAR SOLICITAÇÃO";

        @PostMapping("/cadastro")
        public ResponseEntity<String> cadastrarMedicamento(@RequestBody MedicamentoDTO medicamentoDto, MedicamentoInjetavelDTO medicamentoInjetavelDTO){



            if (medicamentoInjetavelDTO.getTipoAplicacao() == null){
                try {
                    medicamentoService.salvarMedicamentoNaoInjetavel(medicamentoDto);
                    return ResponseEntity.ok("Medicamento cadastrado com sucesso e n\u00E3o teve erro!");
                } catch (Exception e) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body("Ocorreu um erro ao cadastrar o medicamento: " + e.getMessage());
                }
            }
                try{
                    medicamentoService.salvarMedicamentoInjetavel(medicamentoInjetavelDTO);
                    return ResponseEntity.ok("Medicamento injet\u00E1vel cadastrado com sucesso e n\u00E3o teve erro!");
                }catch (Exception e){
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body("Ocorreu um erro ao cadastrar o medicamento injet\u00E1vel: " + e.getMessage());
                }
        }


    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id){
        try {
            return ResponseEntity.ok(medicamentoRepository.findById(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ERRO_AO_BUSCAR);
        }
    }

    @PutMapping("/atualizar-preco/{id}")
    public ResponseEntity<String> atualizarMedicamento(
            @PathVariable Long id, BigDecimal preco, BigDecimal precoComDesconto) {
        MedicamentoDTO medicamentoAtualizado = medicamentoService.atualizarMedicamento(id, preco, precoComDesconto);
        return ResponseEntity.ok(SUCESSO_AO_PROCESSAR);
    }

    @GetMapping("/listarMedicamentos")
    public ResponseEntity<Page<MedicamentoDTO>>buscarTodos(
            @PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        Page<MedicamentoDTO> medicamentosDTO = medicamentoService.listarMedicamentos(pageable);
        return ResponseEntity.ok(medicamentosDTO);
    }

    @GetMapping("/filtrar")
    public ResponseEntity<List<MedicamentoDTO>> filtrarMedicamentos(
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) String fabricante,
            @RequestParam(required = false) BigDecimal precoMenorQue,
            @RequestParam(required = false) BigDecimal precoMaiorQue) {
        List<MedicamentoDTO> medicamentosFiltradosDTO = medicamentoService.buscarMedicamentoPorFiltro(marca, fabricante, precoMenorQue, precoMaiorQue);
        return ResponseEntity.ok(medicamentosFiltradosDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMedicamento(@PathVariable Long id) {
        medicamentoService.deletarMedicamento(id);
        return ResponseEntity.noContent().build();
    }


}
