package sk.qbsw.sonarcleanuputility.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import sk.qbsw.sonarcleanuputility.SonarCleanupUtilityApplication;
import sk.qbsw.sonarcleanuputility.domain.model.SonarProjectSearchResult;
import sk.qbsw.sonarcleanuputility.domain.port.in.SonarProjectManagementUseCase;
import sk.qbsw.sonarcleanuputility.domain.port.out.DeleteSonarProjectPort;
import sk.qbsw.sonarcleanuputility.domain.port.out.SearchSonarProjectsPort;

@Service
@RequiredArgsConstructor
public class SonarProjectManagementService implements SonarProjectManagementUseCase {

    private final SearchSonarProjectsPort searchSonarProjectsPort;
    private final DeleteSonarProjectPort deleteSonarProjectPort;

    private Logger LOG = LoggerFactory.getLogger(SonarProjectManagementService.class);

    @Override
    public SonarProjectSearchResult searchByAnalyzedBeforeAndName(String analyzedBefore, String name) throws JsonProcessingException {
        return searchSonarProjectsPort.searchByAnalyzedBeforeAndName(analyzedBefore, name);
    }

    @Override
    public void bulkDelete(String analyzedBefore, String name) {
        deleteSonarProjectPort.bulkDelete(analyzedBefore, name);
    }
}
