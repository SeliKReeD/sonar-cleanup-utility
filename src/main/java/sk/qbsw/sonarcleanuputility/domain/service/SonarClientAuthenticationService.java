package sk.qbsw.sonarcleanuputility.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sk.qbsw.sonarcleanuputility.domain.model.SonarAuthenticationValidationResult;
import sk.qbsw.sonarcleanuputility.domain.port.in.SonarClientAuthenticationUseCase;
import sk.qbsw.sonarcleanuputility.domain.port.out.SonarAuthenticationPort;

@Service
@RequiredArgsConstructor
public class SonarClientAuthenticationService implements SonarClientAuthenticationUseCase {

    private final SonarAuthenticationPort sonarAuthenticationPort;

    @Override
    public boolean authenticate() {
        SonarAuthenticationValidationResult validationResult;
        try {
            validationResult = sonarAuthenticationPort.authenticate();
        } catch (JsonProcessingException e) {
            return false;
        }
        return validationResult.getValid();
    }
}
