package clinica.cosmetica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import clinica.cosmetica.entities.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {}
