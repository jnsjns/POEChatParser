package se.kth.hogk.poe_chat_parser.hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {

            System.out.println("Listening to localhost:8080");
            FileParser fileParser = new FileParser();
            List<String> list = fileParser.getWhisperList();
            for(String string : list){
                System.out.println(string);
            }
        };
    }
}
