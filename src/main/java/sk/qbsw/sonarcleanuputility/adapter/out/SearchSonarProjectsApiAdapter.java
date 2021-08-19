package sk.qbsw.sonarcleanuputility.adapter.out;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.sonar.wsclient.SonarClient;
import org.springframework.stereotype.Component;
import sk.qbsw.sonarcleanuputility.domain.model.SonarProjectSearchResult;
import sk.qbsw.sonarcleanuputility.domain.port.out.SearchSonarProjectsPort;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class SearchSonarProjectsApiAdapter implements SearchSonarProjectsPort {

    private final SonarClient sonarClient;
    private final ObjectMapper objectMapper;

    @Override
    public SonarProjectSearchResult searchByAnalyzedBeforeAndName(String analyzedBefore, String name) throws JsonProcessingException {
        Map<String, Object> params = new HashMap<>();
        params.put("analyzedBefore", analyzedBefore);
        params.put("q", name);
        String result = sonarClient.get("api/projects/search", params);
        return objectMapper.readValue(result, SonarProjectSearchResult.class);
    }
}
