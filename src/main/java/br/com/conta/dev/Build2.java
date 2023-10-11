package br.com.conta.dev;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Responsável por configurar os serviços do spring
@Configuration
@ComponentScan({
        "br.com.conta.dev", // adptadores front-end javafx
        "br.com.conta.tela",
        "br.com.conta.sistema", // core do sistema
        "br.com.conta.adaptador" // adptadores falsos
})
public class Build2 {
    // Build 2 - Adaptador JavaFX -> Sistema <- Adaptadores Mocks
}
