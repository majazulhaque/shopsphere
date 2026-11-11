package com.shopsphere.config.integration;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Starts the real Config Server on a random port and checks it over HTTP.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ConfigServerIT {

    private static final HttpClient HTTP = HttpClient.newHttpClient();

    @Value("${local.server.port}")
    private int port;

    @Test
    @DisplayName("Health endpoint reports UP once the server has started")
    void healthEndpoint_whenServerStarts_reportsUp() throws Exception {
        HttpResponse<String> response = get("/actuator/health");

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.body()).contains("\"status\":\"UP\"");
    }

    @Test
    @DisplayName("Native backend serves the shared defaults from config-repo/application.yml")
    void nativeBackend_servesSharedDefaultsFromConfigRepo() throws Exception {
        HttpResponse<String> response = get("/application/default");

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.body()).contains("management.endpoints.web.exposure.include");
    }

    private HttpResponse<String> get(String path) throws Exception {
        HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:" + port + path)).GET().build();
        return HTTP.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
