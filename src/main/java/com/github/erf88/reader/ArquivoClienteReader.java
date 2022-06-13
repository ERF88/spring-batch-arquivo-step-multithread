package com.github.erf88.reader;

import com.github.erf88.model.in.ClienteIn;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ArquivoClienteReader {

    @Value("${spring.batch.file.clientes.in}")
    private Resource resource;

    @Bean
    public FlatFileItemReader<ClienteIn> clienteReader() {
        return new FlatFileItemReaderBuilder<ClienteIn>()
                .name("clienteReader")
                .resource(resource)
                .delimited()
                .delimiter(";")
                .names(new String[] {  "id", "nome", "sobrenome", "email", "status" })
                .targetType(ClienteIn.class)
                .saveState(false)
                .build();
    }

}
