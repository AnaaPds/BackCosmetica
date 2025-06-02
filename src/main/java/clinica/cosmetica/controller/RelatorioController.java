package clinica.cosmetica.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@RestController
public class RelatorioController {

    @GetMapping("/relatorio/salvar")
    public String gerarRelatorioPdf() {
        // Troque esse caminho conforme o seu sistema:
        String diretorio = "C:/imagens";
        String nomeArquivo = "relatorio.pdf";
        String caminhoCompleto = diretorio + File.separator + nomeArquivo;

        try {
            File pasta = new File(diretorio);
            if (!pasta.exists()) {
                boolean criada = pasta.mkdirs();
                if (!criada) {
                    return "Erro: não conseguiu criar a pasta " + diretorio;
                }
            }

            File arquivo = new File(caminhoCompleto);
            FileOutputStream fos = new FileOutputStream(arquivo);

            Document document = new Document();
            PdfWriter.getInstance(document, fos);

            document.open();
            document.add(new Paragraph("Relatório da Clínica - Consultas, Médicos e Pacientes"));
            document.add(new Paragraph("Data: " + java.time.LocalDate.now()));
            document.close();

            fos.close();

            return "PDF gerado com sucesso: " + caminhoCompleto;

        } catch (DocumentException e) {
            e.printStackTrace();
            return "Erro de DocumentException: " + e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "Erro de IOException: " + e.getMessage();
        }
    }
}
