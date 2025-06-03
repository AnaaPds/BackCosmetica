package clinica.cosmetica.service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Optional;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import clinica.cosmetica.entities.Paciente;
import clinica.cosmetica.repository.PacienteRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Chave secreta com pelo menos 32 caracteres
    private final String JWT_SECRET = "minhaChaveSecretaMuitoSegura1234567890";

    // Cadastrar paciente com senha criptografada
    public Paciente salvar(Paciente paciente) {
        String senhaCriptografada = passwordEncoder.encode(paciente.getSenha());
        paciente.setSenha(senhaCriptografada);
        return pacienteRepository.save(paciente);
    }

    // Login que retorna token JWT ou null se falhar
    public String autenticar(String email, String senha) {
        Optional<Paciente> pacienteOpt = pacienteRepository.findByEmail(email);
        if (pacienteOpt.isPresent()) {
            Paciente paciente = pacienteOpt.get();
            if (passwordEncoder.matches(senha, paciente.getSenha())) {
                SecretKey key = Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));

                String token = Jwts.builder()
                    .setSubject(email)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 dia validade
                    .signWith(key, SignatureAlgorithm.HS256)
                    .compact();

                return token;
            }
        }
        return null;
    }
}
