package sk.qbsw.sonarcleanuputility.domain.port.in;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface SonarClientAuthenticationUseCase {

    void login(String root, String login, String password);

    boolean validate() throws JsonProcessingException;

    void logout();
}
