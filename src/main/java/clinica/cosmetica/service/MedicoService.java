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

<<<<<<< HEAD
    // Chave secreta para gerar tokens
    private final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Salva o médico com senha criptografada
=======
    // Chave segura gerada automaticamente para HS256
    private final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

>>>>>>> af3506727525665f87d5b676e754d1c05ce51add
    public Medico salvar(Medico medico) {
        medico.setSenha(passwordEncoder.encode(medico.getSenha()));
        return medicoRepository.save(medico);
    }

<<<<<<< HEAD
    // Autentica e gera token JWT
=======
>>>>>>> af3506727525665f87d5b676e754d1c05ce51add
    public String autenticar(String email, String senha) {
        Optional<Medico> medicoOpt = medicoRepository.findByEmail(email);

        if (medicoOpt.isPresent()) {
            Medico medico = medicoOpt.get();
            if (passwordEncoder.matches(senha, medico.getSenha())) {
<<<<<<< HEAD
                // Gera token válido por 24h
=======
                // Criar token JWT válido por 24 horas
>>>>>>> af3506727525665f87d5b676e754d1c05ce51add
                return Jwts.builder()
                    .setSubject(email)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24h
                    .signWith(key)
                    .compact();
            }
        }
<<<<<<< HEAD
        return null; // Autenticação falhou
=======
        return null; // Falha na autenticação
>>>>>>> af3506727525665f87d5b676e754d1c05ce51add
    }
}
