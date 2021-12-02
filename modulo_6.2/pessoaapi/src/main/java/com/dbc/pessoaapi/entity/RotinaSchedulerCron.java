package com.dbc.pessoaapi.entity;

import com.dbc.pessoaapi.dto.EmailDTO;
import com.dbc.pessoaapi.entity.Pessoaentity;
import com.dbc.pessoaapi.kafka.Producer;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.dbc.pessoaapi.service.EmailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class RotinaSchedulerCron {
    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("HH:mm:ss");
    private final PessoaRepository pessoaRepository;
    private final EmailService emailService;
    private final Producer producer;
    private final ObjectMapper objectMapper;

    @Scheduled(cron = "0 0 8,20 * * *", zone = "GMT-3")
    public void rotinaScheduler() throws InterruptedException, MessagingException, TemplateException, IOException {
        List<Pessoaentity> pessoaentityList = pessoaRepository.procuraSemEndereco();
        log.info("total de pessoas sem endereço {}",pessoaentityList.stream().count() );
        for (Pessoaentity pessoaentity:  pessoaentityList) {
            log.info("enviando email para {}",pessoaentity.getEmail() );
            //emailService.enviarEmailPessoaSemEndereco(pessoaentity.getEmail(), pessoaentity.getNome());

            EmailDTO emailDTO = new EmailDTO(pessoaentity.getEmail(), "Adicione o seu endereço", String.format("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                    "<head>\n" +
                    "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                    "    <title>Java Mail</title>\n" +
                    "</head>\n" +
                    "\n" +
                    "<body>\n" +
                    "Ola ${nome}\n" +
                    "<br>\n" +
                    "<br>\n" +
                    "<br>\n" +
                    "Estamos felizes em ter você em nosso sistema :)\n" +
                    "<br>\n" +
                    "Para que possamos enviar-los um brinde exclusivo,por\n" +
                    "<br>\n" +
                    "gentileza,adicione ou atualize o seu endereço no seu cadastro.\n" +
                    "<br>\n" +
                    "<br>\n" +
                    "Muito obrigado,\n" +
                    "<br>\n" +
                    "Sistema de Pessoas.\n" +
                    "\n" +
                    "<br>\n" +
                    "<br>\n" +
                    "att\n" +
                    "<br>\n" +
                    "Sistema\n" +
                    "</body>\n" +
                    "</html>", pessoaentity.getNome()));

            producer.sendMessage(emailDTO);
        }
    }
    @Scheduled(cron = "0 0 0 23 12 ?")
    public void promocaoScheduler() throws InterruptedException, MessagingException, TemplateException, IOException {
        List<Pessoaentity> pessoaentityList = pessoaRepository.findAll();
        log.info("total de pessoas  {}", pessoaentityList.stream().count());
        for (Pessoaentity pessoaentity : pessoaentityList) {
            log.info("enviando email para {}", pessoaentity.getEmail());
            //emailService.enviarEmailPromocaodeNatal(pessoaentity.getEmail(), pessoaentity.getNome());


            EmailDTO emailDTO = new EmailDTO(pessoaentity.getEmail(), "Adicione o seu endereço", String.format("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                    "<head>\n" +
                    "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                    "    <title>Java Mail</title>\n" +
                    "</head>\n" +
                    "\n" +
                    "<body>\n" +
                    "Ola ${nome}\n" +
                    "<br>\n" +
                    "<br>\n" +
                    "<br>\n" +
                    "Selecionamos algumas das nossas super promoção de natal na nossa plataforma\n" +
                    "<br>\n" +
                    "especialmente para voçê:\n" +
                    "<br>\n" +
                    "- Na compra de 1 CDs do Chitãozinho e Xororó,ganhe 1 do Milionário e José Rico.\n" +
                    "<br>\n" +
                    "- Na Locação de um filme em VhS,a outra locação é grátis\n" +
                    "<br>\n" +
                    "- Fita de Super Nitendo com 50% de desconto.\n" +
                    "<br>\n" +
                    "Aproveite...\n" +
                    "<br>\n" +
                    "Magazine OldSchool.\n" +
                    "<br>\n" +
                    "att\n" +
                    "<br>\n" +
                    "Sistema\n" +
                    "</body>\n" +
                    "</html>", pessoaentity.getNome()));

            producer.sendMessage(emailDTO);
        }
    }

        @Scheduled(cron = "0 0 0 * * *")
        public void enviarEmailAniversario() throws JsonProcessingException {
            List<Pessoaentity> pessoas = pessoaRepository.findAll();

            for (Pessoaentity pessoa : pessoas) {
                if (pessoa.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM"))
                        .equals(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM")))){

                    EmailDTO emailDTO = new EmailDTO(pessoa.getEmail(), "Feliz Aniversario", "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                            "<head>\n" +
                            "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                            "    <title>Java Mail</title>\n" +
                            "</head>\n" +
                            "\n" +
                            "<body>\n" +
                            "Ola ${nome}\n" +
                            "<br>\n" +
                            "<br>\n" +
                            "<br>\n" +
                            "Seja Bem Vindo! :)\n" +
                            "\n" +
                            "<br>\n" +
                            "Olá ${nome},\n" +
                            "<br>\n" +
                            "<br>\n" +
                            "Essa data de Aniversário ${data} também é especial \n" +
                            "<br>\n" +
                            "para nós do Vem Ser.Estamos comemorando juntos com você. \\o/\n" +
                            "<br>\n" +
                            "Desejamos um feliz aniversário, que sejam ${idade} anos de muitos.\n" +
                            "<br>\n" +
                            "sucesso, alegria, felicidade e muitas realizações.\n" +
                            "<br>\n" +
                            "sucesso, alegria, felicidade e muitas realizações.\n" +
                            "<br>\n" +
                            "Forte Abraço!\n" +
                            "<br>\n" +
                            "Vem Ser 2021/2.\n" +
                            "<br>\n" +
                            "att\n" +
                            "<br>\n" +
                            "Sistema\n" +
                            "</body>\n" +
                            "</html>");

                    producer.sendMessage(emailDTO);
                }
            }
    }
}
