package clinica.cosmetica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import clinica.cosmetica.service.RelatorioConsultaService;

@RestController
@RequestMapping("/relatorios")
public class RelatorioConsultaController {

    // Injeta o serviço de relatórios
    @Autowired
    private RelatorioConsultaService relatorioConsultaService;

    // Gera e retorna o PDF do relatório por profissional
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
