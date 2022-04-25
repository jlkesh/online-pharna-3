package uz.online.pharma.onlinepharma;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import uz.online.pharma.onlinepharma.properties.OpenApiProperties;
import uz.online.pharma.onlinepharma.properties.ServiceProperties;


@SpringBootApplication
@EnableTransactionManagement
@EnableConfigurationProperties({
        OpenApiProperties.class,
        ServiceProperties.class
})
@RequiredArgsConstructor
public class OnlinePharmaApplication {
    final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(OnlinePharmaApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return (args) -> {
            String admin = "admin";
            String emp = "emp";
            String man = "man";
            System.out.println("passwordEncoder.encode(admin) = " + passwordEncoder.encode(admin));
            System.out.println("passwordEncoder.encode(emp) = " + passwordEncoder.encode(emp));
            System.out.println("passwordEncoder.encode(man) = " + passwordEncoder.encode(man));
        };
    }

}
