package clinica.cosmetica.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import clinica.cosmetica.dto.MedicoDTO;
import clinica.cosmetica.entities.Medico;
import clinica.cosmetica.service.MedicoService;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

	 private final MedicoService service;

	    public MedicoController(MedicoService service) {
	        this.service = service;
	    }

	    @PostMapping
	    public MedicoDTO salvar(@RequestBody MedicoDTO medicoDTO) {
	        Medico medico = service.toEntity(medicoDTO);
	        Medico salvo = service.salvar(medico);
	        return service.toDTO(salvo);
	    }

	    @GetMapping
	    public List<MedicoDTO> listarTodos() {
	        return service.listarTodos().stream()
	                .map(service::toDTO)
	                .collect(Collectors.toList());
	    }
	}