package sk.qbsw.sonarcleanuputility.adapter.out;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.sonar.wsclient.SonarClient;
import org.springframework.stereotype.Component;
import sk.qbsw.sonarcleanuputility.domain.model.SonarAuthenticationValidationResult;
import sk.qbsw.sonarcleanuputility.domain.port.out.SonarAuthenticationPort;

import java.util.HashMap;

@Component
@RequiredArgsConstructor
public class SonarAuthenticationApiAdapter implements SonarAuthenticationPort {

    private final SonarClient sonarClient;
    private final ObjectMapper objectMapper;

    @Override
    public SonarAuthenticationValidationResult authenticate() throws JsonProcessingException {
        String restEndpoint = "api/authentication/validate";
        return objectMapper.readValue(sonarClient.get(restEndpoint, new HashMap<>()), SonarAuthenticationValidationResult.class);
    }
}
