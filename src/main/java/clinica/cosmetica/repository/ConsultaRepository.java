package clinica.cosmetica.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import clinica.cosmetica.entities.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    List<Consulta> findByMedicoNome(String nome);
    List<Consulta> findByMedicoEspecialidade(String especialidade);
}
