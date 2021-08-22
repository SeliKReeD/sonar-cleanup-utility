package sk.qbsw.sonarcleanuputility.configuration.provider;

import org.sonar.wsclient.SonarClient;

public interface SonarClientProvider {

    void updateSonarClient(SonarClient sonarClient);

    SonarClient getSonarClient();
}
