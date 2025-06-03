package clinica.cosmetica.service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import clinica.cosmetica.entities.Consulta;
import clinica.cosmetica.entities.Medico;
import clinica.cosmetica.repository.ConsultaRepository;
import clinica.cosmetica.repository.MedicoRepository;

@Service
public class RelatorioConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    public byte[] gerarPdfRelatorioPorProfissional(Long medicoId) throws DocumentException {
        Optional<Medico> medicoOpt = medicoRepository.findById(medicoId);
        String nomeMedico = medicoOpt.map(Medico::getNome).orElse("Profissional não encontrado");
        String especialidadeMedico = medicoOpt.map(Medico::getEspecialidade).orElse("Especialidade não informada");

        List<Consulta> consultas = consultaRepository.findByMedicoId(medicoId);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, out);
        document.open();

        document.add(new Paragraph("Relatório de Consultas do Profissional: " + nomeMedico));
        document.add(new Paragraph("Especialidade: " + especialidadeMedico));
        document.add(new Paragraph("Total de Consultas: " + consultas.size()));
        document.add(new Paragraph(" "));

        for (Consulta consulta : consultas) {
            String data = (consulta.getData() != null) ? consulta.getData().toString() : "Data não informada";

            String paciente = (consulta.getPaciente() != null && consulta.getPaciente().getNome() != null) 
                    ? consulta.getPaciente().getNome() : "Paciente não informado";

            String linha = "Data: " + data + ", Paciente: " + paciente;
            document.add(new Paragraph(linha));
        }

        document.close();
        return out.toByteArray();
    }
}
