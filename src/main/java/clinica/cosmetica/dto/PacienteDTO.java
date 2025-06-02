package clinica.cosmetica.dto;

import clinica.cosmetica.entities.Paciente;

public class PacienteDTO {

    private Long id;
    private String nome;
    private String email;
    private String fone;
    private String dataNasc;
    
    
    
	public PacienteDTO(Long id, String nome, String email, String fone, String dataNasc) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.fone = fone;
		this.dataNasc = dataNasc;
	}
	
	public PacienteDTO(Paciente entity) {
		id = entity.getId();
		nome = entity.getNome();
		email = entity.getEmail();
		fone = entity.getTelefone();
		dataNasc = entity.getDataNasc();
	}
	
	
	
	public PacienteDTO() {
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
    
    

}
