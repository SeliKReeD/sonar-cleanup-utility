# sonar-cleanup-utility usage
To start using utility run command:
java -jar [your jar file] analyzedBefore projectName --sonar.login=[login] --sonar.password=[password] --sonar.root=[sonar url]
# run sonarqube localy
docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:latest
