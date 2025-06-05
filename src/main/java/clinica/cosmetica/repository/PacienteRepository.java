package clinica.cosmetica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import clinica.cosmetica.entities.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findByEmail(String email);
}
