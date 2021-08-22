package sk.qbsw.sonarcleanuputility.adapter.in;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import sk.qbsw.sonarcleanuputility.SonarCleanupUtilityApplication;
import sk.qbsw.sonarcleanuputility.domain.model.SonarProjectSearchResult;
import sk.qbsw.sonarcleanuputility.domain.port.in.SonarClientAuthenticationUseCase;
import sk.qbsw.sonarcleanuputility.domain.port.in.SonarProjectManagementUseCase;

import java.util.Locale;
import java.util.Scanner;

//@Component
@RequiredArgsConstructor
public class SonarProjectsManagementCLIAdapter implements CommandLineRunner {

    private final SonarClientAuthenticationUseCase sonarClientAuthenticationUseCase;
    private final SonarProjectManagementUseCase sonarProjectManagementUseCase;
    private final ConfigurableApplicationContext configurableApplicationContext;

    private Logger LOG = LoggerFactory.getLogger(SonarCleanupUtilityApplication.class);

    @Override
    public void run(String... args) throws Exception {

//        try {
//            System.out.println("Application started with arguments: [ analyzedBefore : " + args[0] + " ] [ name : " + args[1] + " ]");
//            if (sonarClientAuthenticationUseCase.authenticate()) {
//                System.out.println("Authentication success.");
//                SonarProjectSearchResult result = sonarProjectManagementUseCase.searchByAnalyzedBeforeAndName(args[0], args[1]);
//                if (result.getComponents().size()>0) {
//                    System.out.println("Founded projects to delete: ");
//                    for (SonarProjectSearchResult.SonarProject project : result.getComponents()) {
//                        System.out.println("[ Key: "+project.getKey() + " Name: "+project.getName() + "]");
//                    }
//                    Scanner myObj = new Scanner(System.in);
//                    System.out.print("Proceed [y/N]: ");
//
//                    String choice = myObj.nextLine();
//                    if (choice.toLowerCase(Locale.ROOT).equals("y")) {
//                        sonarProjectManagementUseCase.bulkDelete(args[0], args[1]);
//                        System.out.println("Projects successfully deleted: ");
//                        for (SonarProjectSearchResult.SonarProject project : result.getComponents()) {
//                            System.out.println("[ Key: "+project.getKey() + " Name: "+project.getName() + "]");
//                        }
//                    }
//                } else {
//                    System.out.println("No projects found with given parameters.");
//                }
//            } else {
//                System.out.println("Authentication failed.");
//            }
//            configurableApplicationContext.close();
//        } catch (Exception e) {
//            System.out.println("Application stopped with exception: " + e.getMessage());
//            configurableApplicationContext.close();
//        }

    }
}
