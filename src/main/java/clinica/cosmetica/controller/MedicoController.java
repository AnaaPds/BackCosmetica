package clinica.cosmetica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> af3506727525665f87d5b676e754d1c05ce51add

import clinica.cosmetica.entities.Medico;
import clinica.cosmetica.service.MedicoService;

@RestController
@RequestMapping("/profissionais")
public class MedicoController {

<<<<<<< HEAD
    // Injeta o serviço de médicos
    @Autowired
    private MedicoService medicoService;

    // Cadastra um novo médico
=======
    @Autowired
    private MedicoService medicoService;

>>>>>>> af3506727525665f87d5b676e754d1c05ce51add
    @PostMapping("/cadastro")
    public ResponseEntity<Medico> cadastrarMedico(@RequestBody Medico medico) {
        Medico salvo = medicoService.salvar(medico);
        return ResponseEntity.ok(salvo);
    }

<<<<<<< HEAD
    // Realiza login do médico
=======
>>>>>>> af3506727525665f87d5b676e754d1c05ce51add
    @PostMapping("/login")
    public ResponseEntity<?> loginMedico(@RequestBody Medico medico) {
        String token = medicoService.autenticar(medico.getEmail(), medico.getSenha());
        if (token != null) {
            return ResponseEntity.ok("Login realizado com sucesso!");
        } else {
            return ResponseEntity.status(401).body("Email ou senha inválidos");
        }
    }
}
