package sk.qbsw.sonarcleanuputility.domain.port.out;

import com.fasterxml.jackson.core.JsonProcessingException;
import sk.qbsw.sonarcleanuputility.domain.model.SonarAuthenticationValidationResult;

public interface SonarAuthenticationPort {

    void login(String root, String login, String password);

    SonarAuthenticationValidationResult validate();

    void logout();

}
