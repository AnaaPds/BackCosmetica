package clinica.cosmetica.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clinica.cosmetica.dto.ConsultaDTO;
import clinica.cosmetica.entities.Consulta;
import clinica.cosmetica.entities.Medico;
import clinica.cosmetica.entities.Paciente;
import clinica.cosmetica.repository.ConsultaRepository;
import clinica.cosmetica.repository.MedicoRepository;
import clinica.cosmetica.repository.PacienteRepository;

@Service
public class ConsultaService {

	 @Autowired
	    private ConsultaRepository consultaRepository;

	    @Autowired
	    private MedicoRepository medicoRepository;

	    @Autowired
	    private PacienteRepository pacienteRepository;

	    public List<ConsultaDTO> findAll() {
	        List<Consulta> list = consultaRepository.findAll();
	        return list.stream().map(ConsultaDTO::new).collect(Collectors.toList());
	    }

	    public ConsultaDTO findById(Long id) {
	        Consulta consulta = consultaRepository.findById(id).orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
	        return new ConsultaDTO(consulta);
	    }

	    public ConsultaDTO insert(ConsultaDTO dto) {
	        Consulta consulta = new Consulta();
	        copyDtoToEntity(dto, consulta);
	        consulta = consultaRepository.save(consulta);
	        return new ConsultaDTO(consulta);
	    }

	    public ConsultaDTO update(Long id, ConsultaDTO dto) {
	        Consulta consulta = consultaRepository.findById(id).orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
	        copyDtoToEntity(dto, consulta);
	        consulta = consultaRepository.save(consulta);
	        return new ConsultaDTO(consulta);
	    }

	    public void delete(Long id) {
	        consultaRepository.deleteById(id);
	    }

	    private void copyDtoToEntity(ConsultaDTO dto, Consulta entity) {
	        entity.setDataConsulta(dto.getDataConsulta());

	        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
	                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
	        entity.setPaciente(paciente);

	        Medico medico = medicoRepository.findById(dto.getMedicoId())
	                .orElseThrow(() -> new RuntimeException("Médico não encontrado"));
	        entity.setMedico(medico);
	    }
	}