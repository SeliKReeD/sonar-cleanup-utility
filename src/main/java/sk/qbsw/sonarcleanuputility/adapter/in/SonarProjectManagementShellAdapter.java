package sk.qbsw.sonarcleanuputility.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import sk.qbsw.sonarcleanuputility.domain.model.SonarProjectSearchResult;
import sk.qbsw.sonarcleanuputility.domain.port.in.SonarProjectManagementUseCase;

import java.util.Locale;
import java.util.Scanner;

@ShellComponent
@RequiredArgsConstructor
public class SonarProjectManagementShellAdapter {

    private final SonarProjectManagementUseCase sonarProjectManagementUseCase;

    @ShellMethod("Filter sonar projects by given parameters.")
    public void find(
            @ShellOption(help = "Limit search to: " +
                    "1) component names that contain the supplied string; " +
                    "2) component keys that contain the supplied string.") String q,
            @ShellOption(help = "Filter the projects for which last analysis is older than the given date (exclusive). " +
                    "Either a date (server timezone) or datetime can be provided. " +
                    "Example value 2017-10-19 or 2017-10-19T13:00:00+0200") String analyzedBefore
    ) {
        SonarProjectSearchResult result = sonarProjectManagementUseCase.searchByAnalyzedBeforeAndName(analyzedBefore, q);
        if (result.getComponents().size()>0) {
            String leftAlignFormat = "| %-15s | %-15s | %-15s |%n";
            for (SonarProjectSearchResult.SonarProject project : result.getComponents()) {
                System.out.format(leftAlignFormat, project.getKey(), project.getName(), project.getLastAnalysisDate());
            }
        }
        Scanner myObj = new Scanner(System.in);
        System.out.print("Proceed to delete [y/N]: ");
        String choice = myObj.nextLine();
        if (choice.toLowerCase(Locale.ROOT).equals("y")) {
            sonarProjectManagementUseCase.bulkDelete(analyzedBefore, q);
            System.out.println("Projects successfully deleted: ");
            String leftAlignFormat = "| %-15s | %-15s | %-15s |%n";
            for (SonarProjectSearchResult.SonarProject project : result.getComponents()) {
                System.out.format(leftAlignFormat, project.getKey(), project.getName(), project.getLastAnalysisDate());
            }
        }
    }

    @ShellMethod("Delete sonar projects by given parameters.")
    public void delete(
            @ShellOption(help = "Limit search to: " +
                    "1) component names that contain the supplied string; " +
                    "2) component keys that contain the supplied string.") String q,
            @ShellOption(help = "Filter the projects for which last analysis is older than the given date (exclusive). " +
                    "Either a date (server timezone) or datetime can be provided. " +
                    "Example value 2017-10-19 or 2017-10-19T13:00:00+0200") String analyzedBefore
    ) {
        System.out.println(q);
        System.out.println(analyzedBefore);
    }
}
