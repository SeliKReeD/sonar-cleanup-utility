package sk.qbsw.sonarcleanuputility.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SonarProjectSearchResult {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SonarProject {

        private String key;
        private String name;
        private String qualifier;
        private String visibility;
        private String lastAnalysisDate;
        private String revision;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Pagination {

        private int pageIndex;
        private int pageSize;
        private int total;
    }

    private Pagination paging;
    private List<SonarProject> components;
}
