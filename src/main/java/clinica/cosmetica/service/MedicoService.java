package clinica.cosmetica.service;

import java.util.Date;
import java.util.Optional;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import clinica.cosmetica.entities.Medico;
import clinica.cosmetica.repository.MedicoRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Chave segura gerada automaticamente para HS256
    private final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public Medico salvar(Medico medico) {
        medico.setSenha(passwordEncoder.encode(medico.getSenha()));
        return medicoRepository.save(medico);
    }

    public String autenticar(String email, String senha) {
        Optional<Medico> medicoOpt = medicoRepository.findByEmail(email);

        if (medicoOpt.isPresent()) {
            Medico medico = medicoOpt.get();
            if (passwordEncoder.matches(senha, medico.getSenha())) {
                // Criar token JWT válido por 24 horas
                return Jwts.builder()
                    .setSubject(email)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24h
                    .signWith(key)
                    .compact();
            }
        }
        return null; // Falha na autenticação
    }
}
