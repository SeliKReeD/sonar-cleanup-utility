package sk.qbsw.sonarcleanuputility.domain.port.in;

import com.fasterxml.jackson.core.JsonProcessingException;
import sk.qbsw.sonarcleanuputility.domain.model.SonarProjectSearchResult;

import java.util.List;

public interface SonarProjectManagementUseCase {

    SonarProjectSearchResult searchByAnalyzedBeforeAndName(String analyzedBefore, String name) throws JsonProcessingException;

    void bulkDelete(String analyzedBefore, String name);
}
