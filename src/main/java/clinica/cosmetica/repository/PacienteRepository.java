package clinica.cosmetica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import clinica.cosmetica.entities.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}