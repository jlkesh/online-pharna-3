package uz.online.pharma.onlinepharma.response;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AppError {
    private String code;
    private String path;
    private Integer status;
    private String message;
    private LocalDateTime time;
    private WebRequest request;

    public AppError(String message, WebRequest request, HttpStatus status) {
        this(message, ((ServletWebRequest) request).getRequest().getRequestURI(), status);
    }

    public AppError(String message, String path, HttpStatus status) {
        this.path = path;
        this.message = message;
        this.time = LocalDateTime.now();
        this.status = status.value();
        this.code = status.getReasonPhrase();
    }

    @Builder
    public AppError(HttpStatus status, String message, String path, WebRequest request) {
        this.path = path;
        this.message = message;
        this.request = request;
        this.time = LocalDateTime.now();
        this.status = status.value();
        this.code = status.getReasonPhrase();
    }
}
