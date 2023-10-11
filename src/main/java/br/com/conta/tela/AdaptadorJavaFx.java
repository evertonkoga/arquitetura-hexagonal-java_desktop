package br.com.conta.tela;

import br.com.conta.dev.Build2;
import br.com.conta.hml.Build3;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Responsável por fazer o ponto de inicio de execução
public class AdaptadorJavaFx extends Application {
    private ApplicationContext spring;

    @Override
    public void init() {
        System.out.println("iniciando spring..");
        // spring = new AnnotationConfigApplicationContext(Build2.class); // Config de Dev
        spring = new AnnotationConfigApplicationContext(Build3.class);
    }

    @Override
    public void start(Stage stage) {
        var form = spring.getBean(TransferenciaForm.class);
        form.mostrar(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
