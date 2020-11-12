package com.github.viniciusfcf.microprofile;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class HelloFaultService {
    
    @Retry
    public void executeAlgo() {
        System.out.println("HelloFaultService.executeAlgo()");
        throw new NullPointerException();
    }

}
