package clinica.cosmetica.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
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

    // Repositório de consultas
    @Autowired
    private ConsultaRepository consultaRepository;

    // Repositório de pacientes
    @Autowired
    private PacienteRepository pacienteRepository;

    // Repositório de médicos
    @Autowired
    private MedicoRepository medicoRepository;

    // Lista todas as consultas
    public List<ConsultaDTO> listarTodas() {
        List<Consulta> consultas = consultaRepository.findAll();
        return consultas.stream().map(ConsultaDTO::new).collect(Collectors.toList());
    }

    // Busca consulta por ID
    public Optional<ConsultaDTO> buscarPorId(Long id) {
        return consultaRepository.findById(id).map(ConsultaDTO::new);
    }

    // Salva nova consulta
    public Consulta salvar(ConsultaDTO dto) {
        Consulta consulta = new Consulta();
        consulta.setData(dto.getDataConsulta());

        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        Medico medico = medicoRepository.findById(dto.getMedicoId())
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado"));

        consulta.setPaciente(paciente);
        consulta.setMedico(medico);

        return consultaRepository.save(consulta);
    }

    // Atualiza consulta existente
    public Consulta atualizar(Long id, ConsultaDTO dto) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

        consulta.setData(dto.getDataConsulta());

        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        Medico medico = medicoRepository.findById(dto.getMedicoId())
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado"));

        consulta.setPaciente(paciente);
        consulta.setMedico(medico);

        return consultaRepository.save(consulta);
    }

    // Deleta consulta
    public void deletar(Long id) {
        consultaRepository.deleteById(id);
    }

    // Filtra por profissional
    public List<ConsultaDTO> buscarPorProfissional(String nome) {
        List<Consulta> consultas = consultaRepository.findByMedicoNomeContainingIgnoreCase(nome);
        return consultas.stream().map(ConsultaDTO::new).collect(Collectors.toList());
    }

    // Filtra por especialidade
    public List<ConsultaDTO> buscarPorEspecialidade(String especialidade) {
        List<Consulta> consultas = consultaRepository.findByMedicoEspecialidadeIgnoreCase(especialidade);
        return consultas.stream().map(ConsultaDTO::new).collect(Collectors.toList());
    }

    // Filtra por data
    public List<ConsultaDTO> buscarPorData(LocalDate data) {
        LocalDate start = data;
        LocalDate end = data;
        List<Consulta> consultas = consultaRepository.findByDataBetween(start, end);
        return consultas.stream().map(ConsultaDTO::new).collect(Collectors.toList());
    }

    // Filtra por profissional e data
    public List<ConsultaDTO> buscarPorProfissionalEData(String nome, LocalDate data) {
        LocalDate start = data;
        LocalDate end = data;
        List<Consulta> consultas = consultaRepository.findByMedicoNomeContainingIgnoreCaseAndDataBetween(nome, start, end);
        return consultas.stream().map(ConsultaDTO::new).collect(Collectors.toList());
    }

    // Filtra por especialidade e data
    public List<ConsultaDTO> buscarPorEspecialidadeEData(String especialidade, LocalDate data) {
        LocalDate start = data;
        LocalDate end = data;
        List<Consulta> consultas = consultaRepository.findByMedicoEspecialidadeIgnoreCaseAndDataBetween(especialidade, start, end);
        return consultas.stream().map(ConsultaDTO::new).collect(Collectors.toList());
    }
}
