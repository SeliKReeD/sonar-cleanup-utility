package sk.qbsw.sonarcleanuputility.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.wsclient.SonarClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SonarClientConfiguration {

    @Value("${sonar.login}")
    private String login;
    @Value("${sonar.password}")
    private String password;
    @Value("${sonar.root}")
    private String url;

    private Logger LOG = LoggerFactory.getLogger(SonarClientConfiguration.class);

    @Bean
    public SonarClient sonarClient() {
        LOG.info("SonarClient initialization with root:{}; login:{};", url, login);
        return SonarClient.builder()
                .login(login)
                .password(password)
                .url(url)
                .build();
    }
}
