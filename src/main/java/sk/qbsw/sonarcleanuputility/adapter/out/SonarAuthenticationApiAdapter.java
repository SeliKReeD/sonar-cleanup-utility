package sk.qbsw.sonarcleanuputility.adapter.out;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.sonar.wsclient.SonarClient;
import org.springframework.stereotype.Component;
import sk.qbsw.sonarcleanuputility.configuration.provider.SonarClientProvider;
import sk.qbsw.sonarcleanuputility.domain.model.SonarAuthenticationValidationResult;
import sk.qbsw.sonarcleanuputility.domain.port.out.SonarAuthenticationPort;

import java.util.HashMap;

@Component
@RequiredArgsConstructor
public class SonarAuthenticationApiAdapter implements SonarAuthenticationPort {

    private final SonarClientProvider sonarClientProvider;
    private final ObjectMapper objectMapper;

    private final static String validationUrl = "api/authentication/validate";

    @Override
    public void login(String root, String login, String password) {
        SonarClient sonarClient = SonarClient.builder()
                .url(root)
                .login(login)
                .password(password)
                .build();
        sonarClientProvider.updateSonarClient(sonarClient);
    }

    @Override
    public SonarAuthenticationValidationResult validate() {
        SonarClient sonarClient = sonarClientProvider.getSonarClient();
        if (sonarClient == null) {
            throw new RuntimeException("Validation failure. No credentials found. Use <login> command to login to SonarQube.");
        }
        try {
            return objectMapper.readValue(sonarClient.get(validationUrl, new HashMap<>()), SonarAuthenticationValidationResult.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error processing response during credentials validation.");
        }
    }

    @Override
    public void logout() {
        sonarClientProvider.updateSonarClient(null);
    }
}
