package uz.online.pharma.onlinepharma.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "service")
public class ServiceProperties {
    private String port;
    private String ip;
    private String url;
    private String protocol;
}
