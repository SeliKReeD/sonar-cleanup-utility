package sk.qbsw.sonarcleanuputility.domain.port.out;

import com.fasterxml.jackson.core.JsonProcessingException;
import sk.qbsw.sonarcleanuputility.domain.model.SonarProjectSearchResult;

public interface SearchSonarProjectsPort {

    SonarProjectSearchResult searchByAnalyzedBeforeAndName(String analyzedBefore, String name) throws JsonProcessingException;
}
