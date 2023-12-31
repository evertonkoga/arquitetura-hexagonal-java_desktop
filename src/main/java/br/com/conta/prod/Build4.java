package br.com.conta.prod;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
// Responsável por configurar os serviços do spring
@Configuration
@EnableTransactionManagement
@ComponentScan({
        // adptadores front-end javafx
        "br.com.conta.tela",
        "br.com.conta.prod",
        "br.com.conta.sistema", // core do sistema
        "br.com.conta.servico.repositorio"}) // adptadores hsqdl

public class Build4 {
    //Build 4 - Adaptador JavaFX -> Sistema <- Adaptadores Real em Produção
    @Bean
    public DataSource dataSource() {
        var ds = new SimpleDriverDataSource();
        ds.setDriverClass(org.hsqldb.jdbcDriver.class);
        ds.setUrl("jdbc:hsqldb:file:D:/Java/hsql-2.4.1/conta/");
        ds.setUsername("sa");
        ds.setPassword("1234");
        return ds;
    }
    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
    @Bean
    public DataSourceTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
