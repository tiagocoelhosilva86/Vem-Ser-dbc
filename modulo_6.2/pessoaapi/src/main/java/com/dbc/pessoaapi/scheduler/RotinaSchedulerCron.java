package com.dbc.pessoaapi.scheduler;

import com.dbc.pessoaapi.entity.Pessoaentity;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.dbc.pessoaapi.service.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
    private final ObjectMapper objectMapper;

    @Scheduled(cron = "0 0 8,20 * * *", zone = "GMT-3")
    public void rotinaScheduler() throws InterruptedException, MessagingException, TemplateException, IOException {
        List<Pessoaentity> pessoaentityList = pessoaRepository.procuraSemEndereco();
        log.info("total de pessoas sem endereço {}",pessoaentityList.stream().count() );
        for (Pessoaentity pessoaentity:  pessoaentityList) {
            log.info("enviando email para {}",pessoaentity.getEmail() );
            emailService.enviarEmailPessoaSemEndereco(pessoaentity.getEmail(), pessoaentity.getNome());
        }
    }
    @Scheduled(cron = "0 0 0 23 12 ?")
    public void promocaoScheduler() throws InterruptedException, MessagingException, TemplateException, IOException {
        List<Pessoaentity> pessoaentityList = pessoaRepository.findAll();
        log.info("total de pessoas  {}",pessoaentityList.stream().count() );
        for (Pessoaentity pessoaentity:  pessoaentityList) {
            log.info("enviando email para {}",pessoaentity.getEmail() );
            emailService.enviarEmailPromocaodeNatal(pessoaentity.getEmail(), pessoaentity.getNome());
        }
    }
}
