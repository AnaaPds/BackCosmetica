package clinica.cosmetica.repository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import clinica.cosmetica.entities.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    List<Consulta> findByMedicoNomeContainingIgnoreCase(String nome);

    List<Consulta> findByMedicoEspecialidadeIgnoreCase(String especialidade);

    List<Consulta> findByDataBetween(LocalDate start, LocalDate end);

    List<Consulta> findByMedicoNomeContainingIgnoreCaseAndDataBetween(String nome, LocalDate start, LocalDate end);

    List<Consulta> findByMedicoEspecialidadeIgnoreCaseAndDataBetween(String especialidade, LocalDate start, LocalDate end);

	List<Consulta> findByMedicoId(Long medicoId);
}
