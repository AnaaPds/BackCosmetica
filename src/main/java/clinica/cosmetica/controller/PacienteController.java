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

import clinica.cosmetica.entities.Paciente;
import clinica.cosmetica.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

<<<<<<< HEAD
    // Injeta o serviço de pacientes
    @Autowired
    private PacienteService pacienteService;

    // Cadastra um paciente novo
=======
    @Autowired
    private PacienteService pacienteService;

>>>>>>> af3506727525665f87d5b676e754d1c05ce51add
    @PostMapping("/cadastro")
    public ResponseEntity<Paciente> cadastrarPaciente(@RequestBody Paciente paciente) {
        Paciente salvo = pacienteService.salvar(paciente);
        return ResponseEntity.ok(salvo);
    }

<<<<<<< HEAD
    // Realiza autenticação do paciente
=======
>>>>>>> af3506727525665f87d5b676e754d1c05ce51add
    @PostMapping("/login")
    public ResponseEntity<?> loginPaciente(@RequestBody Paciente paciente) {
        String token = pacienteService.autenticar(paciente.getEmail(), paciente.getSenha());
        if (token != null) {
            return ResponseEntity.ok("Login realizado com sucesso!");
        } else {
            return ResponseEntity.status(401).body("Email ou senha inválidos");
        }
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> af3506727525665f87d5b676e754d1c05ce51add
