package clinica.cosmetica.service;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class RelatorioService {

    public static class RelatorioMedicoDTO {
        private String nomeMedico;
        private String especialidade;
        private int totalConsultas;

        public RelatorioMedicoDTO(String nomeMedico, String especialidade, int totalConsultas) {
            this.nomeMedico = nomeMedico;
            this.especialidade = especialidade;
            this.totalConsultas = totalConsultas;
        }

        public String getNomeMedico() {
            return nomeMedico;
        }

        public String getEspecialidade() {
            return especialidade;
        }

        public int getTotalConsultas() {
            return totalConsultas;
        }
    }

    public List<RelatorioMedicoDTO> buscarRelatorioMedicos() {
       
        throw new UnsupportedOperationException("Implementar consulta no banco para o relatório.");
    }

    public ByteArrayInputStream gerarRelatorioMedicosPdf(List<RelatorioMedicoDTO> dados) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            document.add(new Paragraph("Relatório de Consultas por Médico\n\n"));

            PdfPTable table = new PdfPTable(3);
            table.addCell("Nome do Médico");
            table.addCell("Especialidade");
            table.addCell("Total de Consultas");

            for (RelatorioMedicoDTO dto : dados) {
                table.addCell(dto.getNomeMedico());
                table.addCell(dto.getEspecialidade());
                table.addCell(String.valueOf(dto.getTotalConsultas()));
            }

            document.add(table);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}

