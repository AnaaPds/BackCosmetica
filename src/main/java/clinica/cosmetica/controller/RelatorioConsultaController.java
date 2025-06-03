package clinica.cosmetica.controller;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import clinica.cosmetica.entities.Consulta;
import clinica.cosmetica.repository.ConsultaRepository;

@RestController
@RequestMapping("/relatorios")
public class RelatorioConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @GetMapping("/profissional/{medicoId}")
    public ResponseEntity<byte[]> gerarRelatorio(@PathVariable Long medicoId) throws Exception {
        List<Consulta> consultas = consultaRepository.findByMedicoId(medicoId);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, baos);
        document.open();

        document.add(new Paragraph("Relatório de Consultas - Médico ID: " + medicoId));
        for (Consulta c : consultas) {
            document.add(new Paragraph("Consulta com: " + c.getPaciente().getNome() +
                                       " em " + c.getData().toString()));
        }
        document.close();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "relatorio.pdf");

        return new ResponseEntity<>(baos.toByteArray(), headers, HttpStatus.OK);
    }
}
