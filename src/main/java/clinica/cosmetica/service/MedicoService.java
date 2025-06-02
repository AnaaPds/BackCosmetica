package clinica.cosmetica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import clinica.cosmetica.dto.MedicoDTO;
import clinica.cosmetica.entities.Medico;
import clinica.cosmetica.repository.MedicoRepository;

@Service
public class MedicoService {

	 private final MedicoRepository repository;

	    public MedicoService(MedicoRepository repository) {
	        this.repository = repository;
	    }

	    public Medico salvar(Medico medico) {
	        return repository.save(medico);
	    }

	    public List<Medico> listarTodos() {
	        return repository.findAll();
	    }

	    // Conversão: Entity -> DTO
	    public MedicoDTO toDTO(Medico medico) {
	        MedicoDTO dto = new MedicoDTO();
	        dto.setId(medico.getId());
	        dto.setNome(medico.getNome());
	        dto.setEspecialidade(medico.getEspecialidade());
	        dto.setEmail(medico.getEmail());
	        dto.setTelefone(medico.getTelefone());
	        return dto;
	    }

	    // Conversão: DTO -> Entity
	    public Medico toEntity(MedicoDTO dto) {
	        Medico medico = new Medico();
	        medico.setId(dto.getId());
	        medico.setNome(dto.getNome());
	        medico.setEspecialidade(dto.getEspecialidade());
	        medico.setEmail(dto.getEmail());
	        medico.setTelefone(dto.getTelefone());
	        return medico;
	    }
	}