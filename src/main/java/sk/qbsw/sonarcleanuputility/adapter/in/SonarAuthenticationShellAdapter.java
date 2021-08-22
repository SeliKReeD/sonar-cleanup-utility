package sk.qbsw.sonarcleanuputility.adapter.in;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import sk.qbsw.sonarcleanuputility.domain.port.in.SonarClientAuthenticationUseCase;
import sk.qbsw.sonarcleanuputility.domain.port.in.SonarProjectManagementUseCase;

@ShellComponent
@RequiredArgsConstructor
public class SonarAuthenticationShellAdapter {

    private final SonarClientAuthenticationUseCase sonarClientAuthenticationUseCase;

    @ShellMethod("Login into SonarQube.")
    public void login(@ShellOption String root, @ShellOption String login, @ShellOption String password) {
        sonarClientAuthenticationUseCase.login(root, login, password);
        validate();
    }

    @ShellMethod("Login from SonarQube.")
    public void logout() {
        sonarClientAuthenticationUseCase.logout();
    }

    @ShellMethod("Validate credentials to SonarQube.")
    public void validate() {
        try {
            if(sonarClientAuthenticationUseCase.validate()) {
                System.out.println("Login success.");
            } else {
                System.out.println("Login failure. Wrong username or password.");
            }
        } catch (JsonProcessingException e) {
            System.out.println("Failed to process response from SonarQube server.");
        }
    }
}
