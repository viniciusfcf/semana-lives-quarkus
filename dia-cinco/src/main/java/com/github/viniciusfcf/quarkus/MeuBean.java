package com.github.viniciusfcf.quarkus;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import io.quarkus.scheduler.Scheduled;

@ApplicationScoped
public class MeuBean {
    
    // @Scheduled(
    //     every = "{vinicius.every}",
    //     identity = "joao"
    //     )
    // @Transactional
    public void execute() throws InterruptedException {
        System.out.println("MeuBean.execute() "+LocalDateTime.now());
    }

}
