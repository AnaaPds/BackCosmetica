package clinica.cosmetica.dto;

import java.time.LocalDate;

import clinica.cosmetica.entities.Consulta;

public class ConsultaDTO {
    private Long id;
    private LocalDate dataConsulta;
    private Long pacienteId;
    private String nomePaciente;
    private Long medicoId;
    private String nomeMedico;
    private String especialidade;

    public ConsultaDTO() {
    }

    public ConsultaDTO(Long id, LocalDate dataConsulta, Long pacienteId, String nomePaciente, Long medicoId, String nomeMedico, String especialidade) {
        this.id = id;
        this.dataConsulta = dataConsulta;
        this.pacienteId = pacienteId;
        this.nomePaciente = nomePaciente;
        this.medicoId = medicoId;
        this.nomeMedico = nomeMedico;
        this.especialidade = especialidade;
    }

    public ConsultaDTO(Consulta entity) {
        this.id = entity.getId();
        this.dataConsulta = entity.getData();
        this.pacienteId = entity.getPaciente().getId();
        this.nomePaciente = entity.getPaciente().getNome();
        this.medicoId = entity.getMedico().getId();
        this.nomeMedico = entity.getMedico().getNome();
        this.especialidade = entity.getMedico().getEspecialidade();
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public Long getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Long medicoId) {
        this.medicoId = medicoId;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
	}