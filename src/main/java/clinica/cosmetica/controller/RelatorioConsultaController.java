package clinica.cosmetica.controller;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> af3506727525665f87d5b676e754d1c05ce51add

import clinica.cosmetica.service.RelatorioConsultaService;

@RestController
@RequestMapping("/relatorios")
public class RelatorioConsultaController {

<<<<<<< HEAD
    // Injeta o serviço de relatórios
    @Autowired
    private RelatorioConsultaService relatorioConsultaService;

    // Gera e retorna o PDF do relatório por profissional
=======
    @Autowired
    private RelatorioConsultaService relatorioConsultaService;

>>>>>>> af3506727525665f87d5b676e754d1c05ce51add
    @GetMapping("/profissional/{id}")
    public ResponseEntity<byte[]> gerarRelatorio(@PathVariable Long id) throws Exception {
        byte[] pdfBytes = relatorioConsultaService.gerarPdfRelatorioPorProfissional(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("attachment")
            .filename("relatorio_profissional_" + id + ".pdf")
            .build());

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
}
