package dev.prompttrellis.info;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    private final String name;
    private final String version;

    public InfoController(
            @Value("${spring.application.name}") String name,
            @Value("${app.version}") String version
    ) {
        this.name = name;
        this.version = version;
    }

    @GetMapping("/api/v1/info")
    public ProjectInfo getInfo() {
        return new ProjectInfo(name, version);
    }

    public record ProjectInfo(String name, String version) {}
}