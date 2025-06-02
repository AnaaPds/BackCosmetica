package clinica.cosmetica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import clinica.cosmetica.dto.ConsultaDTO;
import clinica.cosmetica.service.ConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

	 @Autowired
	    private ConsultaService consultaService;

	    @GetMapping
	    public ResponseEntity<List<ConsultaDTO>> findAll() {
	        List<ConsultaDTO> list = consultaService.findAll();
	        return ResponseEntity.ok().body(list);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<ConsultaDTO> findById(@PathVariable Long id) {
	        ConsultaDTO dto = consultaService.findById(id);
	        return ResponseEntity.ok().body(dto);
	    }

	    @PostMapping
	    public ResponseEntity<ConsultaDTO> insert(@RequestBody ConsultaDTO dto) {
	        ConsultaDTO newDto = consultaService.insert(dto);
	        return ResponseEntity.ok().body(newDto);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<ConsultaDTO> update(@PathVariable Long id, @RequestBody ConsultaDTO dto) {
	        ConsultaDTO updatedDto = consultaService.update(id, dto);
	        return ResponseEntity.ok().body(updatedDto);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id) {
	        consultaService.delete(id);
	        return ResponseEntity.noContent().build();
	    }
	}