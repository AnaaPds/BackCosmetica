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

<<<<<<< HEAD
    // Utiliza BCrypt para criptografar senhas
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Chave secreta para assinatura do token
    private final String JWT_SECRET = "minhaChaveSecretaMuitoSegura1234567890";

    // Salva paciente com senha segura
=======
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Chave secreta com pelo menos 32 caracteres
    private final String JWT_SECRET = "minhaChaveSecretaMuitoSegura1234567890";

    // Cadastrar paciente com senha criptografada
>>>>>>> af3506727525665f87d5b676e754d1c05ce51add
    public Paciente salvar(Paciente paciente) {
        String senhaCriptografada = passwordEncoder.encode(paciente.getSenha());
        paciente.setSenha(senhaCriptografada);
        return pacienteRepository.save(paciente);
    }

<<<<<<< HEAD
    // Autentica e retorna JWT, ou null se inválido
=======
    // Login que retorna token JWT ou null se falhar
>>>>>>> af3506727525665f87d5b676e754d1c05ce51add
    public String autenticar(String email, String senha) {
        Optional<Paciente> pacienteOpt = pacienteRepository.findByEmail(email);
        if (pacienteOpt.isPresent()) {
            Paciente paciente = pacienteOpt.get();
            if (passwordEncoder.matches(senha, paciente.getSenha())) {
<<<<<<< HEAD
                // Cria chave com a senha definida
                SecretKey key = Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));

                // Gera o token com validade de 1 dia
                String token = Jwts.builder()
                    .setSubject(email)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 86400000))
=======
                SecretKey key = Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));

                String token = Jwts.builder()
                    .setSubject(email)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 dia validade
>>>>>>> af3506727525665f87d5b676e754d1c05ce51add
                    .signWith(key, SignatureAlgorithm.HS256)
                    .compact();

                return token;
            }
        }
        return null;
    }
}
