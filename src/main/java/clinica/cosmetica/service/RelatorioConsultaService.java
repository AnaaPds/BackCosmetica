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

    // Gera relatório PDF para um profissional
    public byte[] gerarPdfRelatorioPorProfissional(Long medicoId) throws DocumentException {
        // Busca médico pelo ID
        Optional<Medico> medicoOpt = medicoRepository.findById(medicoId);

        // Obtém nome ou define padrão
        String nomeMedico = medicoOpt.map(Medico::getNome).orElse("Profissional não encontrado");

        // Obtém especialidade ou define padrão
        String especialidadeMedico = medicoOpt.map(Medico::getEspecialidade).orElse("Especialidade não informada");

        // Busca todas as consultas do médico
        List<Consulta> consultas = consultaRepository.findByMedicoId(medicoId);

        // Inicializa fluxo de saída
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        // Cria novo documento PDF
        Document document = new Document();

        // Configura PDF para escrever no fluxo
        PdfWriter.getInstance(document, out);

        // Abre documento para edição
        document.open();

        // Adiciona título do relatório
        document.add(new Paragraph("Relatório de Consultas do Profissional: " + nomeMedico));

        // Adiciona especialidade
        document.add(new Paragraph("Especialidade: " + especialidadeMedico));

        // Adiciona quantidade total de consultas
        document.add(new Paragraph("Total de Consultas: " + consultas.size()));

        // Linha em branco para espaçamento
        document.add(new Paragraph(" "));

        // Itera sobre consultas e adiciona informações
        for (Consulta consulta : consultas) {
            String data = (consulta.getData() != null) ? consulta.getData().toString() : "Data não informada";

            String paciente = (consulta.getPaciente() != null && consulta.getPaciente().getNome() != null) 
                    ? consulta.getPaciente().getNome() : "Paciente não informado";

            String linha = "Data: " + data + ", Paciente: " + paciente;

            // Adiciona a linha ao PDF
            document.add(new Paragraph(linha));
        }

        // Fecha documento
        document.close();

        // Retorna PDF como array de bytes
        return out.toByteArray();
    }
}
