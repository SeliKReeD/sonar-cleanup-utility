package sk.qbsw.sonarcleanuputility.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.sonar.wsclient.SonarClient;
import org.springframework.stereotype.Service;
import sk.qbsw.sonarcleanuputility.domain.model.SonarAuthenticationValidationResult;
import sk.qbsw.sonarcleanuputility.domain.port.in.SonarClientAuthenticationUseCase;
import sk.qbsw.sonarcleanuputility.domain.port.out.SonarAuthenticationPort;

@Service
@RequiredArgsConstructor
public class SonarClientAuthenticationService implements SonarClientAuthenticationUseCase {

    private final SonarAuthenticationPort sonarAuthenticationPort;

    @Override
    public void login(String root, String login, String password) {
        sonarAuthenticationPort.login(root, login, password);
    }

    @Override
    public boolean validate() {
        return sonarAuthenticationPort.validate().getValid();
    }

    @Override
    public void logout() {
        sonarAuthenticationPort.logout();
    }
}
