package uz.online.pharma.onlinepharma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import uz.online.pharma.onlinepharma.domains.auth.Users;
import uz.online.pharma.onlinepharma.enums.Language;
import uz.online.pharma.onlinepharma.properties.OpenApiProperties;
import uz.online.pharma.onlinepharma.properties.ServiceProperties;
import uz.online.pharma.onlinepharma.repository.auth.UserRepository;


@SpringBootApplication
@EnableTransactionManagement
@EnableConfigurationProperties({
        OpenApiProperties.class,
        ServiceProperties.class
})

public class OnlinePharmaApplication {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public OnlinePharmaApplication(PasswordEncoder passwordEncoder,
                                   UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(OnlinePharmaApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return (args) -> {
            Users admin = new Users();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setLanguage(Language.EN);
            admin.setCreatedBy(-1L);
            admin.setPhone("998908115224");
            userRepository.save(admin);
        };
    }

}
