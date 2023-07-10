package com.farmadavlia.medicamentos.controller;

import com.farmadavlia.medicamentos.domain.dto.MedicamentoDTO;
import com.farmadavlia.medicamentos.domain.models.MedicamentoEntity;
import com.farmadavlia.medicamentos.repository.MedicamentoRepository;
import com.farmadavlia.medicamentos.service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {

    @Autowired
    MedicamentoService medicamentoService;

    @Autowired
    MedicamentoRepository medicamentoRepository;

    @Autowired

    private static final String ERRO_AO_BUSCAR = "ERRO AO PROCESSAR SOLICITAÇÃO";

        @PostMapping("/cadastro")
        public ResponseEntity<String> cadastrarMedicamento(@RequestBody MedicamentoDTO medicamentoDto){

            try {
                medicamentoService.salvarMedicamentoNaoInjetavel(medicamentoDto);
                return ResponseEntity.ok("Medicamento cadastrado com sucesso e n\u00E3o teve erro!");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Ocorreu um erro ao cadastrar o medicamento: " + e.getMessage());
            }
        }

    @GetMapping("{/id}")
    public ResponseEntity buscarPorId(@PathVariable Long id){
        try {
            return ResponseEntity.ok(medicamentoService.buscarMedicamentoPorId(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ERRO_AO_BUSCAR);
        }
    }

    @GetMapping({"/todos"})
    public List<MedicamentoEntity> buscarTodos(){
        List<MedicamentoEntity> medicamentoEntities = medicamentoRepository.findAll();
        return medicamentoEntities;
    }
}
