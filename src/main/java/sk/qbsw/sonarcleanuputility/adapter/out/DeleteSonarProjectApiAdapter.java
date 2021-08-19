package sk.qbsw.sonarcleanuputility.adapter.out;

import lombok.RequiredArgsConstructor;
import org.sonar.wsclient.SonarClient;
import org.springframework.stereotype.Component;
import sk.qbsw.sonarcleanuputility.domain.port.out.DeleteSonarProjectPort;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class DeleteSonarProjectApiAdapter implements DeleteSonarProjectPort {

    private final SonarClient sonarClient;

    @Override
    public void bulkDelete(String analyzedBefore, String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("analyzedBefore", analyzedBefore);
        params.put("q", name);
        sonarClient.post("api/projects/bulk_delete", params);
    }
}
