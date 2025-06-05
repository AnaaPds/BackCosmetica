package clinica.cosmetica.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> af3506727525665f87d5b676e754d1c05ce51add

import clinica.cosmetica.dto.ConsultaDTO;
import clinica.cosmetica.entities.Consulta;
import clinica.cosmetica.service.ConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

<<<<<<< HEAD
    // Injeta o serviço de consultas
    @Autowired
    private ConsultaService consultaService;

    // Retorna todas as consultas
    @GetMapping
    public List<ConsultaDTO> listarTodas() {
        return consultaService.listarTodas();
    }

    // Busca consulta por ID
    @GetMapping("/{id}")
    public ResponseEntity<ConsultaDTO> buscarPorId(@PathVariable Long id) {
        return consultaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Cadastra nova consulta
    @PostMapping
    public ResponseEntity<ConsultaDTO> salvar(@RequestBody ConsultaDTO dto) {
        Consulta consultaSalva = consultaService.salvar(dto);
        return ResponseEntity.ok(new ConsultaDTO(consultaSalva));
    }

    // Atualiza consulta existente
    @PutMapping("/{id}")
    public ResponseEntity<ConsultaDTO> atualizar(@PathVariable Long id, @RequestBody ConsultaDTO dto) {
        try {
            Consulta atualizada = consultaService.atualizar(id, dto);
            return ResponseEntity.ok(new ConsultaDTO(atualizada));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Remove consulta pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        consultaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    // Filtra por nome do profissional
    @GetMapping("/profissional")
    public List<ConsultaDTO> buscarPorProfissional(@RequestParam String nome) {
        return consultaService.buscarPorProfissional(nome);
    }

    // Filtra por especialidade
    @GetMapping("/especialidade")
    public List<ConsultaDTO> buscarPorEspecialidade(@RequestParam String especialidade) {
        return consultaService.buscarPorEspecialidade(especialidade);
    }

    // Filtra por data
    @GetMapping("/data")
    public List<ConsultaDTO> buscarPorData(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        return consultaService.buscarPorData(data);
    }

    // Filtra por profissional e data
    @GetMapping("/profissional-data")
    public List<ConsultaDTO> buscarPorProfissionalEData(@RequestParam String nome,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        return consultaService.buscarPorProfissionalEData(nome, data);
    }

    // Filtra por especialidade e data
    @GetMapping("/especialidade-data")
    public List<ConsultaDTO> buscarPorEspecialidadeEData(@RequestParam String especialidade,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        return consultaService.buscarPorEspecialidadeEData(especialidade, data);
    }
}
=======
	 @Autowired
	    private ConsultaService consultaService;

	    @GetMapping
	    public List<ConsultaDTO> listarTodas() {
	        return consultaService.listarTodas();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<ConsultaDTO> buscarPorId(@PathVariable Long id) {
	        return consultaService.buscarPorId(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public ResponseEntity<ConsultaDTO> salvar(@RequestBody ConsultaDTO dto) {
	        Consulta consultaSalva = consultaService.salvar(dto);
	        return ResponseEntity.ok(new ConsultaDTO(consultaSalva));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<ConsultaDTO> atualizar(@PathVariable Long id, @RequestBody ConsultaDTO dto) {
	        try {
	            Consulta atualizada = consultaService.atualizar(id, dto);
	            return ResponseEntity.ok(new ConsultaDTO(atualizada));
	        } catch (RuntimeException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletar(@PathVariable Long id) {
	        consultaService.deletar(id);
	        return ResponseEntity.noContent().build();
	    }

	    @GetMapping("/profissional")
	    public List<ConsultaDTO> buscarPorProfissional(@RequestParam String nome) {
	        return consultaService.buscarPorProfissional(nome);
	    }

	    @GetMapping("/especialidade")
	    public List<ConsultaDTO> buscarPorEspecialidade(@RequestParam String especialidade) {
	        return consultaService.buscarPorEspecialidade(especialidade);
	    }

	    @GetMapping("/data")
	    public List<ConsultaDTO> buscarPorData(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
	        return consultaService.buscarPorData(data);
	    }

	    @GetMapping("/profissional-data")
	    public List<ConsultaDTO> buscarPorProfissionalEData(@RequestParam String nome,
	            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
	        return consultaService.buscarPorProfissionalEData(nome, data);
	    }

	    @GetMapping("/especialidade-data")
	    public List<ConsultaDTO> buscarPorEspecialidadeEData(@RequestParam String especialidade,
	            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
	        return consultaService.buscarPorEspecialidadeEData(especialidade, data);
	    }
	}
>>>>>>> af3506727525665f87d5b676e754d1c05ce51add
