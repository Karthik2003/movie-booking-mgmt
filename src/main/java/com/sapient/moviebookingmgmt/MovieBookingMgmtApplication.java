package com.sapient.moviebookingmgmt;

import io.r2dbc.spi.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

@SpringBootApplication
@Slf4j
public class MovieBookingMgmtApplication {
    public static void main(String[] args) {

        SpringApplication.run(MovieBookingMgmtApplication.class, args);
        log.info("...................Started Movie Booking Mgmt Service.....................");
    }

//    @Bean
//    CommandLineRunner commandLineRunner(ScreenService screenService){
//        return args -> {
//            ObjectMapper mapper = new ObjectMapper();
//            TypeReference<List<Screen>> typeReference = new TypeReference<List<Screen>>(){};
//            InputStream inputStream = TypeReference.class.getResourceAsStream("/data/screens_master.json");
//            try {
//                List<Screen> screenList = mapper.readValue(inputStream,typeReference);
//                screenService.saveAll(screenList);
//                log.info("------ data persisted completed --------");
//            } catch (Exception e){
//                log.error("----- data persistence failed ------");
//                throw new IOException(e.getMessage());
//            }
//        };
//    }

    @Bean
    ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {

        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("/data/data.sql")));

        return initializer;
    }
}
