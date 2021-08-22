package sk.qbsw.sonarcleanuputility.configuration.provider;

import org.sonar.wsclient.SonarClient;
import org.springframework.stereotype.Component;

@Component
public class SonarClientProviderImpl implements SonarClientProvider {

    private SonarClient sonarClient;

    @Override
    public void updateSonarClient(SonarClient sonarClient) {
        this.sonarClient = sonarClient;
    }

    @Override
    public SonarClient getSonarClient() {
        return sonarClient;
    }
}
