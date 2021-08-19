package sk.qbsw.sonarcleanuputility.domain.port.out;

public interface DeleteSonarProjectPort {

    void bulkDelete(String analyzedBefore, String name);
}
