Micro serviço 
pegando paramentro do profile e expondo no endpoint;
configuração de liberação de endpoints pelo actuator;
por fim vamos pegar configurações de profile do github;
e fazer o refresh das configurações do profile e passar direto para as aplicações que consomem o seviço;

testando App;

se eu não passar nenhum paramentro apenas fazer um get no endpoint, teremos o resultado abaixo:
http://localhost:8081/greeting

{
"id": 1,
"content": "Olá, Mundo!"
}
-----------------------------------------------------------------------

se eu passar paramentos no endpoint conforme abaixo:
http://localhost:8081/greeting?name=FernandoSilva

teremos o seguinte resultado:

{
"id": 2,
"content": "Olá, FernandoSilva!"
-------------------------------------------------------------------------------------------------------------------------------------------------

agora vamos verificar se a App esta UP!

com o actuator; 

http://localhost:8081/actuator

para pesquisar sobre o actuator: https://docs.spring.io/spring-boot/docs/2.5.6/reference/html/actuator.html

nos resultará na seguinte informação, veja abaixo:

{
"_links": {
"self": {
"href": "http://localhost:8081/actuator",
"templated": false
},
"health": {
"href": "http://localhost:8081/actuator/health",
"templated": false
},
"health-path": {
"href": "http://localhost:8081/actuator/health/{*path}",
"templated": true
}
}
}

para verificar se a app esta UP basta verificar o seguinte endpoint:

http://localhost:8081/actuator/health

seu resultado é:
{
"status": "UP"
}
---------------------------------------------------------------------------------------------------------------------------------------------
#agora vamos liberar endpoints, para testes e saber sobre os endpoints;

----------------
management:
  endpoints:
    web:
      exposure:
        include:
        - '*'
-------------------------        
        
passando estes paramentos no application.yml libera 13 endpoints que estavam bloqueados por padrão do Actuator

veja os dados do console nos logs: Exposing 13 endpoint(s) beneath base path '/actuator'


depois de liberados os edpoints nos retorna estes endpoints pelo actuator:


http://localhost:8081/actuator


{
"_links": {
"self": {
"href": "http://localhost:8081/actuator",
"templated": false
},
"beans": {
"href": "http://localhost:8081/actuator/beans",
"templated": false
},
"caches-cache": {
"href": "http://localhost:8081/actuator/caches/{cache}",
"templated": true
},
"caches": {
"href": "http://localhost:8081/actuator/caches",
"templated": false
},
"health": {
"href": "http://localhost:8081/actuator/health",
"templated": false
},
"health-path": {
"href": "http://localhost:8081/actuator/health/{*path}",
"templated": true
},
"info": {
"href": "http://localhost:8081/actuator/info",
"templated": false
},
"conditions": {
"href": "http://localhost:8081/actuator/conditions",
"templated": false
},
"configprops": {
"href": "http://localhost:8081/actuator/configprops",
"templated": false
},
"configprops-prefix": {
"href": "http://localhost:8081/actuator/configprops/{prefix}",
"templated": true
},
"env": {
"href": "http://localhost:8081/actuator/env",
"templated": false
},
"env-toMatch": {
"href": "http://localhost:8081/actuator/env/{toMatch}",
"templated": true
},
"loggers": {
"href": "http://localhost:8081/actuator/loggers",
"templated": false
},
"loggers-name": {
"href": "http://localhost:8081/actuator/loggers/{name}",
"templated": true
},
"heapdump": {
"href": "http://localhost:8081/actuator/heapdump",
"templated": false
},
"threaddump": {
"href": "http://localhost:8081/actuator/threaddump",
"templated": false
},
"metrics-requiredMetricName": {
"href": "http://localhost:8081/actuator/metrics/{requiredMetricName}",
"templated": true
},
"metrics": {
"href": "http://localhost:8081/actuator/metrics",
"templated": false
},
"scheduledtasks": {
"href": "http://localhost:8081/actuator/scheduledtasks",
"templated": false
},
"mappings": {
"href": "http://localhost:8081/actuator/mappings",
"templated": false
}
}
}
-----------------------------------------------------------------------------------------------------------------------------
acessando novamente o actuator, http://localhost:8081/actuator

vamos dentro do actuator acessar o endpoint env:

veja as inofrmaçoes que nos propoem, as configs de portas, do sistema em geral, 
{
"activeProfiles": [],
"propertySources": [
{
"name": "server.ports",
"properties": {
"local.server.port": {
"value": 8081
}
}
},
{
"name": "commandLineArgs",
"properties": {
"spring.output.ansi.enabled": {
"value": "always"
}
}
},
{
"name": "servletContextInitParams",
"properties": {}
},
{
"name": "systemProperties",
"properties": {
"java.specification.version": {
"value": "15"
},
"sun.cpu.isalist": {
"value": "amd64"
},
"sun.jnu.encoding": {
"value": "Cp1252"
},
"java.class.path": {
"value": "C:\\temp\\work-Space-microservices\\greeting-service\\target\\classes;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\springframework\\boot\\spring-boot-starter-actuator\\2.5.10\\spring-boot-starter-actuator-2.5.10.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\springframework\\boot\\spring-boot-starter\\2.5.10\\spring-boot-starter-2.5.10.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\springframework\\boot\\spring-boot-starter-logging\\2.5.10\\spring-boot-starter-logging-2.5.10.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\ch\\qos\\logback\\logback-classic\\1.2.10\\logback-classic-1.2.10.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\ch\\qos\\logback\\logback-core\\1.2.10\\logback-core-1.2.10.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\apache\\logging\\log4j\\log4j-to-slf4j\\2.17.1\\log4j-to-slf4j-2.17.1.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\apache\\logging\\log4j\\log4j-api\\2.17.1\\log4j-api-2.17.1.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\slf4j\\jul-to-slf4j\\1.7.36\\jul-to-slf4j-1.7.36.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\jakarta\\annotation\\jakarta.annotation-api\\1.3.5\\jakarta.annotation-api-1.3.5.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\yaml\\snakeyaml\\1.28\\snakeyaml-1.28.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\springframework\\boot\\spring-boot-actuator-autoconfigure\\2.5.10\\spring-boot-actuator-autoconfigure-2.5.10.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\springframework\\boot\\spring-boot-actuator\\2.5.10\\spring-boot-actuator-2.5.10.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\com\\fasterxml\\jackson\\core\\jackson-databind\\2.12.6\\jackson-databind-2.12.6.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\com\\fasterxml\\jackson\\core\\jackson-annotations\\2.12.6\\jackson-annotations-2.12.6.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\com\\fasterxml\\jackson\\core\\jackson-core\\2.12.6\\jackson-core-2.12.6.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\com\\fasterxml\\jackson\\datatype\\jackson-datatype-jsr310\\2.12.6\\jackson-datatype-jsr310-2.12.6.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\io\\micrometer\\micrometer-core\\1.7.9\\micrometer-core-1.7.9.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\hdrhistogram\\HdrHistogram\\2.1.12\\HdrHistogram-2.1.12.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\latencyutils\\LatencyUtils\\2.0.3\\LatencyUtils-2.0.3.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\springframework\\boot\\spring-boot-starter-web\\2.5.10\\spring-boot-starter-web-2.5.10.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\springframework\\boot\\spring-boot-starter-json\\2.5.10\\spring-boot-starter-json-2.5.10.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\com\\fasterxml\\jackson\\datatype\\jackson-datatype-jdk8\\2.12.6\\jackson-datatype-jdk8-2.12.6.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\com\\fasterxml\\jackson\\module\\jackson-module-parameter-names\\2.12.6\\jackson-module-parameter-names-2.12.6.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\springframework\\boot\\spring-boot-starter-tomcat\\2.5.10\\spring-boot-starter-tomcat-2.5.10.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\apache\\tomcat\\embed\\tomcat-embed-core\\9.0.58\\tomcat-embed-core-9.0.58.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\apache\\tomcat\\embed\\tomcat-embed-el\\9.0.58\\tomcat-embed-el-9.0.58.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\apache\\tomcat\\embed\\tomcat-embed-websocket\\9.0.58\\tomcat-embed-websocket-9.0.58.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\springframework\\spring-web\\5.3.16\\spring-web-5.3.16.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\springframework\\spring-beans\\5.3.16\\spring-beans-5.3.16.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\springframework\\spring-webmvc\\5.3.16\\spring-webmvc-5.3.16.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\springframework\\spring-aop\\5.3.16\\spring-aop-5.3.16.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\springframework\\spring-context\\5.3.16\\spring-context-5.3.16.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\springframework\\spring-expression\\5.3.16\\spring-expression-5.3.16.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\springframework\\boot\\spring-boot-devtools\\2.5.10\\spring-boot-devtools-2.5.10.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\springframework\\boot\\spring-boot\\2.5.10\\spring-boot-2.5.10.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\springframework\\boot\\spring-boot-autoconfigure\\2.5.10\\spring-boot-autoconfigure-2.5.10.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\slf4j\\slf4j-api\\1.7.36\\slf4j-api-1.7.36.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\springframework\\spring-core\\5.3.16\\spring-core-5.3.16.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\springframework\\spring-jcl\\5.3.16\\spring-jcl-5.3.16.jar;C:\\Users\\Rcell Asus\\.m2\\repository\\org\\springframework\\boot\\spring-boot-configuration-processor\\2.5.10\\spring-boot-configuration-processor-2.5.10.jar"
},
"com.sun.management.jmxremote.authenticate": {
"value": "false"
},
"java.vm.vendor": {
"value": "Oracle Corporation"
},
"sun.arch.data.model": {
"value": "64"
},
"user.variant": {
"value": ""
},
"java.vendor.url": {
"value": "https://java.oracle.com/"
},
"catalina.useNaming": {
"value": "false"
},
"user.timezone": {
"value": "America/Sao_Paulo"
},
"java.vm.specification.version": {
"value": "15"
},
"os.name": {
"value": "Windows 10"
},
"sun.java.launcher": {
"value": "SUN_STANDARD"
},
"user.country": {
"value": "BR"
},
"sun.boot.library.path": {
"value": "C:\\sts-4.9.0.RELEASE\\plugins\\org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_15.0.2.v20210201-0955\\jre\\bin"
},
"com.sun.management.jmxremote.ssl": {
"value": "false"
},
"spring.application.admin.enabled": {
"value": "true"
},
"sun.java.command": {
"value": "******"
},
"com.sun.management.jmxremote": {
"value": ""
},
"jdk.debug": {
"value": "release"
},
"sun.cpu.endian": {
"value": "little"
},
"spring.boot.project.name": {
"value": "greeting-service"
},
"user.home": {
"value": "C:\\Users\\Rcell Asus"
},
"user.language": {
"value": "pt"
},
"java.specification.vendor": {
"value": "Oracle Corporation"
},
"java.version.date": {
"value": "2021-01-19"
},
"java.home": {
"value": "C:\\sts-4.9.0.RELEASE\\plugins\\org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_15.0.2.v20210201-0955\\jre"
},
"file.separator": {
"value": "\\"
},
"java.vm.compressedOopsMode": {
"value": "32-bit"
},
"line.separator": {
"value": "\r\n"
},
"java.vm.specification.vendor": {
"value": "Oracle Corporation"
},
"java.specification.name": {
"value": "Java Platform API Specification"
},
"FILE_LOG_CHARSET": {
"value": "UTF-8"
},
"java.awt.headless": {
"value": "true"
},
"user.script": {
"value": ""
},
"sun.management.compiler": {
"value": "HotSpot 64-Bit Tiered Compilers"
},
"java.runtime.version": {
"value": "15.0.2+7-27"
},
"user.name": {
"value": "Rcell Asus"
},
"spring.jmx.enabled": {
"value": "true"
},
"path.separator": {
"value": ";"
},
"os.version": {
"value": "10.0"
},
"java.runtime.name": {
"value": "OpenJDK Runtime Environment"
},
"file.encoding": {
"value": "UTF-8"
},
"spring.beaninfo.ignore": {
"value": "true"
},
"java.vm.name": {
"value": "OpenJDK 64-Bit Server VM"
},
"java.vendor.url.bug": {
"value": "https://bugreport.java.com/bugreport/"
},
"java.io.tmpdir": {
"value": "C:\\Users\\RCELLA~1\\AppData\\Local\\Temp\\"
},
"catalina.home": {
"value": "C:\\Users\\Rcell Asus\\AppData\\Local\\Temp\\tomcat.8081.5497301061988462996"
},
"com.sun.management.jmxremote.port": {
"value": "51129"
},
"java.version": {
"value": "15.0.2"
},
"user.dir": {
"value": "C:\\temp\\work-Space-microservices\\greeting-service"
},
"os.arch": {
"value": "amd64"
},
"java.vm.specification.name": {
"value": "Java Virtual Machine Specification"
},
"PID": {
"value": "13352"
},
"sun.os.patch.level": {
"value": ""
},
"CONSOLE_LOG_CHARSET": {
"value": "UTF-8"
},
"catalina.base": {
"value": "C:\\Users\\Rcell Asus\\AppData\\Local\\Temp\\tomcat.8081.5497301061988462996"
},
"java.library.path": {
"value": "C:\\sts-4.9.0.RELEASE\\plugins\\org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_15.0.2.v20210201-0955\\jre\\bin;C:\\WINDOWS\\Sun\\Java\\bin;C:\\WINDOWS\\system32;C:\\WINDOWS;C:/sts-4.9.0.RELEASE//plugins/org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_15.0.2.v20210201-0955/jre/bin/server;C:/sts-4.9.0.RELEASE//plugins/org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_15.0.2.v20210201-0955/jre/bin;C:\\WINDOWS\\system32;C:\\WINDOWS;C:\\WINDOWS\\System32\\Wbem;C:\\WINDOWS\\System32\\WindowsPowerShell\\v1.0\\;C:\\WINDOWS\\System32\\OpenSSH\\;C:\\Program Files\\Java\\jdk-11.0.11\\bin;C:\\Program Files\\nodejs\\;C:\\ProgramData\\UNIVALI\\Portugol Studio;C:\\Program Files\\Git\\cmd;C:\\gradle-7.2\\bin;C:\\Program Files\\Docker\\Docker\\resources\\bin;C:\\ProgramData\\DockerDesktop\\version-bin;C:\\Program Files\\apache-maven-3.8.3\\bin\\;C:\\Users\\Rcell Asus\\AppData\\Local\\Microsoft\\WindowsApps;C:\\Users\\Rcell Asus\\AppData\\Local\\Programs\\Microsoft VS Code\\bin;C:\\Users\\Rcell Asus\\AppData\\Roaming\\npm;C:\\Users\\Rcell Asus\\AppData\\Local\\GitHubDesktop\\bin;C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2021.2.3\\bin;;C:\\Program Files\\heroku\\bin;C:\\Program Files\\MySQL\\mysql-8.0.26-winx64\\bin;;C:\\Program Files\\JetBrains\\PyCharm Community Edition 2021.3.2\\bin;;C:\\sts-4.9.0.RELEASE;;."
},
"java.vm.info": {
"value": "mixed mode"
},
"java.vendor": {
"value": "Oracle Corporation"
},
"java.vm.version": {
"value": "15.0.2+7-27"
},
"java.rmi.server.hostname": {
"value": "localhost"
},
"java.rmi.server.randomIDs": {
"value": "true"
},
"sun.io.unicode.encoding": {
"value": "UnicodeLittle"
},
"java.class.version": {
"value": "59.0"
}
}
},
{
"name": "systemEnvironment",
"properties": {
"USERDOMAIN_ROAMINGPROFILE": {
"value": "FERNANDOSILVA",
"origin": "System Environment Property \"USERDOMAIN_ROAMINGPROFILE\""
},
"LOCALAPPDATA": {
"value": "C:\\Users\\Rcell Asus\\AppData\\Local",
"origin": "System Environment Property \"LOCALAPPDATA\""
},
"PROCESSOR_LEVEL": {
"value": "23",
"origin": "System Environment Property \"PROCESSOR_LEVEL\""
},
"USERDOMAIN": {
"value": "FERNANDOSILVA",
"origin": "System Environment Property \"USERDOMAIN\""
},
"FPS_BROWSER_APP_PROFILE_STRING": {
"value": "Internet Explorer",
"origin": "System Environment Property \"FPS_BROWSER_APP_PROFILE_STRING\""
},
"LOGONSERVER": {
"value": "\\\\FERNANDOSILVA",
"origin": "System Environment Property \"LOGONSERVER\""
},
"JAVA_HOME": {
"value": "C:\\Program Files\\Java\\jdk-11.0.11",
"origin": "System Environment Property \"JAVA_HOME\""
},
"SESSIONNAME": {
"value": "Console",
"origin": "System Environment Property \"SESSIONNAME\""
},
"ALLUSERSPROFILE": {
"value": "C:\\ProgramData",
"origin": "System Environment Property \"ALLUSERSPROFILE\""
},
"PROCESSOR_ARCHITECTURE": {
"value": "AMD64",
"origin": "System Environment Property \"PROCESSOR_ARCHITECTURE\""
},
"PSModulePath": {
"value": "C:\\Program Files\\WindowsPowerShell\\Modules;C:\\WINDOWS\\system32\\WindowsPowerShell\\v1.0\\Modules",
"origin": "System Environment Property \"PSModulePath\""
},
"SystemDrive": {
"value": "C:",
"origin": "System Environment Property \"SystemDrive\""
},
"MAVEN_HOME": {
"value": "C:\\Program Files\\apache-maven-3.8.3",
"origin": "System Environment Property \"MAVEN_HOME\""
},
"OneDrive": {
"value": "C:\\Users\\Rcell Asus\\OneDrive",
"origin": "System Environment Property \"OneDrive\""
},
"APPDATA": {
"value": "C:\\Users\\Rcell Asus\\AppData\\Roaming",
"origin": "System Environment Property \"APPDATA\""
},
"USERNAME": {
"value": "Rcell Asus",
"origin": "System Environment Property \"USERNAME\""
},
"ProgramFiles(x86)": {
"value": "C:\\Program Files (x86)",
"origin": "System Environment Property \"ProgramFiles(x86)\""
},
"CommonProgramFiles": {
"value": "C:\\Program Files\\Common Files",
"origin": "System Environment Property \"CommonProgramFiles\""
},
"Path": {
"value": "C:/sts-4.9.0.RELEASE//plugins/org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_15.0.2.v20210201-0955/jre/bin/server;C:/sts-4.9.0.RELEASE//plugins/org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_15.0.2.v20210201-0955/jre/bin;C:\\WINDOWS\\system32;C:\\WINDOWS;C:\\WINDOWS\\System32\\Wbem;C:\\WINDOWS\\System32\\WindowsPowerShell\\v1.0\\;C:\\WINDOWS\\System32\\OpenSSH\\;C:\\Program Files\\Java\\jdk-11.0.11\\bin;C:\\Program Files\\nodejs\\;C:\\ProgramData\\UNIVALI\\Portugol Studio;C:\\Program Files\\Git\\cmd;C:\\gradle-7.2\\bin;C:\\Program Files\\Docker\\Docker\\resources\\bin;C:\\ProgramData\\DockerDesktop\\version-bin;C:\\Program Files\\apache-maven-3.8.3\\bin\\;C:\\Users\\Rcell Asus\\AppData\\Local\\Microsoft\\WindowsApps;C:\\Users\\Rcell Asus\\AppData\\Local\\Programs\\Microsoft VS Code\\bin;C:\\Users\\Rcell Asus\\AppData\\Roaming\\npm;C:\\Users\\Rcell Asus\\AppData\\Local\\GitHubDesktop\\bin;C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2021.2.3\\bin;;C:\\Program Files\\heroku\\bin;C:\\Program Files\\MySQL\\mysql-8.0.26-winx64\\bin;;C:\\Program Files\\JetBrains\\PyCharm Community Edition 2021.3.2\\bin;;C:\\sts-4.9.0.RELEASE;",
"origin": "System Environment Property \"Path\""
},
"FPS_BROWSER_USER_PROFILE_STRING": {
"value": "Default",
"origin": "System Environment Property \"FPS_BROWSER_USER_PROFILE_STRING\""
},
"PATHEXT": {
"value": ".COM;.EXE;.BAT;.CMD;.VBS;.VBE;.JS;.JSE;.WSF;.WSH;.MSC",
"origin": "System Environment Property \"PATHEXT\""
},
"DriverData": {
"value": "C:\\Windows\\System32\\Drivers\\DriverData",
"origin": "System Environment Property \"DriverData\""
},
"OS": {
"value": "Windows_NT",
"origin": "System Environment Property \"OS\""
},
"OneDriveConsumer": {
"value": "C:\\Users\\Rcell Asus\\OneDrive",
"origin": "System Environment Property \"OneDriveConsumer\""
},
"COMPUTERNAME": {
"value": "FERNANDOSILVA",
"origin": "System Environment Property \"COMPUTERNAME\""
},
"IntelliJ IDEA Community Edition": {
"value": "C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2021.2.3\\bin;",
"origin": "System Environment Property \"IntelliJ IDEA Community Edition\""
},
"PROCESSOR_REVISION": {
"value": "1801",
"origin": "System Environment Property \"PROCESSOR_REVISION\""
},
"CommonProgramW6432": {
"value": "C:\\Program Files\\Common Files",
"origin": "System Environment Property \"CommonProgramW6432\""
},
"ComSpec": {
"value": "C:\\WINDOWS\\system32\\cmd.exe",
"origin": "System Environment Property \"ComSpec\""
},
"PyCharm Community Edition": {
"value": "C:\\Program Files\\JetBrains\\PyCharm Community Edition 2021.3.2\\bin;",
"origin": "System Environment Property \"PyCharm Community Edition\""
},
"ProgramData": {
"value": "C:\\ProgramData",
"origin": "System Environment Property \"ProgramData\""
},
"ProgramW6432": {
"value": "C:\\Program Files",
"origin": "System Environment Property \"ProgramW6432\""
},
"GRADLE-HOME": {
"value": "C:\\Gradle\\gradle-7.2\\bin",
"origin": "System Environment Property \"GRADLE-HOME\""
},
"HOMEPATH": {
"value": "\\Users\\Rcell Asus",
"origin": "System Environment Property \"HOMEPATH\""
},
"SystemRoot": {
"value": "C:\\WINDOWS",
"origin": "System Environment Property \"SystemRoot\""
},
"TEMP": {
"value": "C:\\Users\\RCELLA~1\\AppData\\Local\\Temp",
"origin": "System Environment Property \"TEMP\""
},
"HOMEDRIVE": {
"value": "C:",
"origin": "System Environment Property \"HOMEDRIVE\""
},
"PROCESSOR_IDENTIFIER": {
"value": "AMD64 Family 23 Model 24 Stepping 1, AuthenticAMD",
"origin": "System Environment Property \"PROCESSOR_IDENTIFIER\""
},
"USERPROFILE": {
"value": "C:\\Users\\Rcell Asus",
"origin": "System Environment Property \"USERPROFILE\""
},
"TMP": {
"value": "C:\\Users\\RCELLA~1\\AppData\\Local\\Temp",
"origin": "System Environment Property \"TMP\""
},
"CommonProgramFiles(x86)": {
"value": "C:\\Program Files (x86)\\Common Files",
"origin": "System Environment Property \"CommonProgramFiles(x86)\""
},
"ProgramFiles": {
"value": "C:\\Program Files",
"origin": "System Environment Property \"ProgramFiles\""
},
"PUBLIC": {
"value": "C:\\Users\\Public",
"origin": "System Environment Property \"PUBLIC\""
},
"NUMBER_OF_PROCESSORS": {
"value": "8",
"origin": "System Environment Property \"NUMBER_OF_PROCESSORS\""
},
"windir": {
"value": "C:\\WINDOWS",
"origin": "System Environment Property \"windir\""
},
"=::": {
"value": "::\\",
"origin": "System Environment Property \"=::\""
}
}
},
{
"name": "Config resource 'class path resource [application.yml]' via location 'optional:classpath:/'",
"properties": {
"server.port": {
"value": 8081,
"origin": "class path resource [application.yml] - 2:9"
},
"spring.application.name": {
"value": "greeting-service",
"origin": "class path resource [application.yml] - 6:11"
},
"management.endpoints.web.exposure.include[0]": {
"value": "*",
"origin": "class path resource [application.yml] - 13:11"
},
"greeting-service.greeting": {
"value": "Olá",
"origin": "class path resource [application.yml] - 16:13"
},
"greeting-service.default-value": {
"value": "Mundo",
"origin": "class path resource [application.yml] - 17:18"
}
}
},
{
"name": "devtools",
"properties": {
"spring.groovy.template.cache": {
"value": "false"
},
"server.servlet.jsp.init-parameters.development": {
"value": "true"
},
"spring.mvc.log-resolved-exception": {
"value": "true"
},
"spring.web.resources.chain.cache": {
"value": "false"
},
"spring.thymeleaf.cache": {
"value": "false"
},
"spring.freemarker.cache": {
"value": "false"
},
"server.error.include-stacktrace": {
"value": "ALWAYS"
},
"spring.reactor.debug": {
"value": "true"
},
"spring.mustache.cache": {
"value": "false"
},
"spring.h2.console.enabled": {
"value": "true"
},
"server.servlet.session.persistent": {
"value": "true"
},
"server.error.include-binding-errors": {
"value": "ALWAYS"
},
"spring.template.provider.cache": {
"value": "false"
},
"server.error.include-message": {
"value": "ALWAYS"
},
"spring.web.resources.cache.period": {
"value": "0"
}
}
}
]
}

------------------------------------------------------------------------------------------------------------------------------------------
ao acessar o endpoint de beans: http://localhost:8081/actuator/beans ele nos expos varios endpoints, detre eles o unico endpoint que criei;

vaja abaixo os endpoints: 

este é o unico endpoint que desenvolvi nesta aplicação, todo o restante o sring boot se encarrega de nos fornece! abaixo dos traços;

-------------------------------------------------------------------------------------------------------
"greetingServiceApplication": {
"aliases": [],
"scope": "singleton",
"type": "com.systempro.greetingservice.GreetingServiceApplication$$EnhancerBySpringCGLIB$$df325b99",
"resource": null,
"dependencies": []
},
------------------------------------------------------------------------------------------------------

{
"contexts": {
"greeting-service": {
"beans": {
"endpointCachingOperationInvokerAdvisor": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.endpoint.invoker.cache.CachingOperationInvokerAdvisor",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/EndpointAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.endpoint.EndpointAutoConfiguration",
"environment"
]
},
"defaultServletHandlerMapping": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.web.servlet.HandlerMapping",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
]
},
"metricsRestTemplateCustomizer": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.metrics.web.client.MetricsRestTemplateCustomizer",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/web/client/RestTemplateMetricsConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.metrics.web.client.RestTemplateMetricsConfiguration",
"simpleMeterRegistry",
"restTemplateExchangeTagsProvider",
"management.metrics-org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties"
]
},
"applicationTaskExecutor": {
"aliases": [
"taskExecutor"
],
"scope": "singleton",
"type": "org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor",
"resource": "class path resource [org/springframework/boot/autoconfigure/task/TaskExecutionAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration",
"taskExecutorBuilder"
]
},
"characterEncodingFilter": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/HttpEncodingAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration"
]
},
"forceAutoProxyCreatorToUseClassProxying": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.aop.AopAutoConfiguration$ClassProxyingConfiguration$$Lambda$461/0x00000001003ccee8",
"resource": "class path resource [org/springframework/boot/autoconfigure/aop/AopAutoConfiguration$ClassProxyingConfiguration.class]",
"dependencies": []
},
"healthEndpointGroups": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.health.AutoConfiguredHealthEndpointGroups",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/health/HealthEndpointConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.health.HealthEndpointConfiguration",
"org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@955f77b",
"management.endpoint.health-org.springframework.boot.actuate.autoconfigure.health.HealthEndpointProperties"
]
},
"management.endpoint.health-org.springframework.boot.actuate.autoconfigure.health.HealthEndpointProperties": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.health.HealthEndpointProperties",
"resource": null,
"dependencies": []
},
"webEndpointDiscoverer": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.endpoint.web.annotation.WebEndpointDiscoverer",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/web/WebEndpointAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration",
"endpointOperationParameterMapper",
"endpointMediaTypes"
]
},
"org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration",
"resource": null,
"dependencies": [
"spring.servlet.multipart-org.springframework.boot.autoconfigure.web.servlet.MultipartProperties"
]
},
"org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration$DispatcherServletRegistrationConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration$DispatcherServletRegistrationConfiguration",
"resource": null,
"dependencies": []
},
"preserveErrorControllerTargetClassPostProcessor": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$PreserveErrorControllerTargetClassPostProcessor",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/error/ErrorMvcAutoConfiguration.class]",
"dependencies": []
},
"org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonObjectMapperBuilderConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonObjectMapperBuilderConfiguration",
"resource": null,
"dependencies": []
},
"logbackMetrics": {
"aliases": [],
"scope": "singleton",
"type": "io.micrometer.core.instrument.binder.logging.LogbackMetrics",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/LogbackMetricsAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.metrics.LogbackMetricsAutoConfiguration"
]
},
"management.info-org.springframework.boot.actuate.autoconfigure.info.InfoContributorProperties": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.info.InfoContributorProperties",
"resource": null,
"dependencies": []
},
"org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration",
"resource": null,
"dependencies": [
"org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@955f77b",
"management.endpoints.web-org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties"
]
},
"webEndpointPathMapper": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.endpoint.web.MappingWebEndpointPathMapper",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/web/WebEndpointAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration"
]
},
"org.springframework.boot.actuate.autoconfigure.trace.http.HttpTraceEndpointAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.trace.http.HttpTraceEndpointAutoConfiguration",
"resource": null,
"dependencies": []
},
"org.springframework.boot.actuate.autoconfigure.cache.CachesEndpointAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.cache.CachesEndpointAutoConfiguration",
"resource": null,
"dependencies": []
},
"propertySourcesPlaceholderConfigurer": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.context.support.PropertySourcesPlaceholderConfigurer",
"resource": "class path resource [org/springframework/boot/autoconfigure/context/PropertyPlaceholderAutoConfiguration.class]",
"dependencies": []
},
"org.springframework.boot.actuate.autoconfigure.endpoint.jmx.JmxEndpointAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.endpoint.jmx.JmxEndpointAutoConfiguration",
"resource": null,
"dependencies": [
"org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@955f77b",
"management.endpoints.jmx-org.springframework.boot.actuate.autoconfigure.endpoint.jmx.JmxEndpointProperties"
]
},
"jmxMBeanExporter": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.endpoint.jmx.JmxEndpointExporter",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/jmx/JmxEndpointAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.endpoint.jmx.JmxEndpointAutoConfiguration",
"mbeanServer",
"endpointObjectNameFactory",
"jmxAnnotationEndpointDiscoverer"
]
},
"beanNameViewResolver": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.web.servlet.view.BeanNameViewResolver",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/error/ErrorMvcAutoConfiguration$WhitelabelErrorViewConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$WhitelabelErrorViewConfiguration"
]
},
"restTemplateExchangeTagsProvider": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.metrics.web.client.DefaultRestTemplateExchangeTagsProvider",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/web/client/RestTemplateMetricsConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.metrics.web.client.RestTemplateMetricsConfiguration"
]
},
"endpointObjectNameFactory": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.endpoint.jmx.DefaultEndpointObjectNameFactory",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/jmx/JmxEndpointAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.endpoint.jmx.JmxEndpointAutoConfiguration",
"mbeanServer",
"environment"
]
},
"org.springframework.boot.actuate.autoconfigure.endpoint.web.servlet.WebMvcEndpointManagementContextConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.endpoint.web.servlet.WebMvcEndpointManagementContextConfiguration",
"resource": null,
"dependencies": []
},
"viewResolver": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.web.servlet.view.ContentNegotiatingViewResolver",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter",
"org.springframework.beans.factory.support.DefaultListableBeanFactory@3eb4493d"
]
},
"management.endpoints.web.cors-org.springframework.boot.actuate.autoconfigure.endpoint.web.CorsEndpointProperties": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.endpoint.web.CorsEndpointProperties",
"resource": null,
"dependencies": []
},
"org.springframework.boot.devtools.autoconfigure.LocalDevToolsAutoConfiguration$LiveReloadConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.devtools.autoconfigure.LocalDevToolsAutoConfiguration$LiveReloadConfiguration",
"resource": null,
"dependencies": []
},
"stringHttpMessageConverter": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.http.converter.StringHttpMessageConverter",
"resource": "class path resource [org/springframework/boot/autoconfigure/http/HttpMessageConvertersAutoConfiguration$StringHttpMessageConverterConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration$StringHttpMessageConverterConfiguration",
"environment"
]
},
"org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration$TomcatWebServerFactoryCustomizerConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration$TomcatWebServerFactoryCustomizerConfiguration",
"resource": null,
"dependencies": []
},
"tomcatServletWebServerFactoryCustomizer": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.servlet.TomcatServletWebServerFactoryCustomizer",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/ServletWebServerFactoryAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration",
"server-org.springframework.boot.autoconfigure.web.ServerProperties"
]
},
"org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration",
"resource": null,
"dependencies": []
},
"server-org.springframework.boot.autoconfigure.web.ServerProperties": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.ServerProperties",
"resource": null,
"dependencies": []
},
"messageConverters": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.http.HttpMessageConverters",
"resource": "class path resource [org/springframework/boot/autoconfigure/http/HttpMessageConvertersAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration"
]
},
"jsonComponentModule": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.jackson.JsonComponentModule",
"resource": "class path resource [org/springframework/boot/autoconfigure/jackson/JacksonAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration"
]
},
"websocketServletWebServerCustomizer": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.websocket.servlet.TomcatWebSocketServletWebServerCustomizer",
"resource": "class path resource [org/springframework/boot/autoconfigure/websocket/servlet/WebSocketServletAutoConfiguration$TomcatWebSocketConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration$TomcatWebSocketConfiguration"
]
},
"jmxAnnotationEndpointDiscoverer": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.endpoint.jmx.annotation.JmxEndpointDiscoverer",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/jmx/JmxEndpointAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.endpoint.jmx.JmxEndpointAutoConfiguration",
"endpointOperationParameterMapper"
]
},
"org.springframework.boot.actuate.autoconfigure.web.mappings.MappingsEndpointAutoConfiguration$ServletWebConfiguration$SpringMvcConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.web.mappings.MappingsEndpointAutoConfiguration$ServletWebConfiguration$SpringMvcConfiguration",
"resource": null,
"dependencies": []
},
"configurationPropertiesReportEndpointWebExtension": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.context.properties.ConfigurationPropertiesReportEndpointWebExtension",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/context/properties/ConfigurationPropertiesReportEndpointAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.context.properties.ConfigurationPropertiesReportEndpointAutoConfiguration",
"configurationPropertiesReportEndpoint"
]
},
"org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration",
"resource": null,
"dependencies": []
},
"scheduledBeanLazyInitializationExcludeFilter": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.task.ScheduledBeanLazyInitializationExcludeFilter",
"resource": "class path resource [org/springframework/boot/autoconfigure/task/TaskSchedulingAutoConfiguration.class]",
"dependencies": []
},
"org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration",
"resource": null,
"dependencies": []
},
"mappingJackson2HttpMessageConverter": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.http.converter.json.MappingJackson2HttpMessageConverter",
"resource": "class path resource [org/springframework/boot/autoconfigure/http/JacksonHttpMessageConvertersConfiguration$MappingJackson2HttpMessageConverterConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.http.JacksonHttpMessageConvertersConfiguration$MappingJackson2HttpMessageConverterConfiguration",
"jacksonObjectMapper"
]
},
"org.springframework.boot.actuate.autoconfigure.env.EnvironmentEndpointAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.env.EnvironmentEndpointAutoConfiguration",
"resource": null,
"dependencies": []
},
"meterRegistryPostProcessor": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryPostProcessor",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/MetricsAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@955f77b"
]
},
"mbeanExporter": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.jmx.export.annotation.AnnotationMBeanExporter",
"resource": "class path resource [org/springframework/boot/autoconfigure/jmx/JmxAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration",
"objectNamingStrategy",
"org.springframework.beans.factory.support.DefaultListableBeanFactory@3eb4493d"
]
},
"endpointMediaTypes": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.endpoint.web.EndpointMediaTypes",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/web/WebEndpointAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration"
]
},
"org.springframework.boot.actuate.autoconfigure.health.HealthEndpointWebExtensionConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.health.HealthEndpointWebExtensionConfiguration",
"resource": null,
"dependencies": []
},
"healthStatusAggregator": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.health.SimpleStatusAggregator",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/health/HealthEndpointConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.health.HealthEndpointConfiguration",
"management.endpoint.health-org.springframework.boot.actuate.autoconfigure.health.HealthEndpointProperties"
]
},
"org.springframework.boot.actuate.autoconfigure.metrics.SystemMetricsAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.metrics.SystemMetricsAutoConfiguration",
"resource": null,
"dependencies": []
},
"management.server-org.springframework.boot.actuate.autoconfigure.web.server.ManagementServerProperties": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.web.server.ManagementServerProperties",
"resource": null,
"dependencies": []
},
"mbeanServer": {
"aliases": [],
"scope": "singleton",
"type": "com.sun.jmx.mbeanserver.JmxMBeanServer",
"resource": "class path resource [org/springframework/boot/autoconfigure/jmx/JmxAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration"
]
},
"servletWebServerFactoryCustomizer": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryCustomizer",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/ServletWebServerFactoryAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration",
"server-org.springframework.boot.autoconfigure.web.ServerProperties"
]
},
"mvcUrlPathHelper": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.web.util.UrlPathHelper",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
]
},
"org.springframework.boot.actuate.autoconfigure.metrics.web.servlet.WebMvcMetricsAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.metrics.web.servlet.WebMvcMetricsAutoConfiguration",
"resource": null,
"dependencies": [
"management.metrics-org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties"
]
},
"servletMappingDescriptionProvider": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.web.mappings.servlet.ServletsMappingDescriptionProvider",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/web/mappings/MappingsEndpointAutoConfiguration$ServletWebConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.web.mappings.MappingsEndpointAutoConfiguration$ServletWebConfiguration"
]
},
"webServerFactoryCustomizerBeanPostProcessor": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.web.server.WebServerFactoryCustomizerBeanPostProcessor",
"resource": null,
"dependencies": []
},
"metricsHttpClientUriTagFilter": {
"aliases": [],
"scope": "singleton",
"type": "io.micrometer.core.instrument.config.MeterFilter$9",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/web/client/HttpClientMetricsAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.metrics.web.client.HttpClientMetricsAutoConfiguration",
"management.metrics-org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties"
]
},
"org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration",
"resource": null,
"dependencies": []
},
"management.health.diskspace-org.springframework.boot.actuate.autoconfigure.system.DiskSpaceHealthIndicatorProperties": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.system.DiskSpaceHealthIndicatorProperties",
"resource": null,
"dependencies": []
},
"spring.sql.init-org.springframework.boot.autoconfigure.sql.init.SqlInitializationProperties": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.sql.init.SqlInitializationProperties",
"resource": null,
"dependencies": []
},
"controllerEndpointHandlerMapping": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.endpoint.web.servlet.ControllerEndpointHandlerMapping",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/web/servlet/WebMvcEndpointManagementContextConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.endpoint.web.servlet.WebMvcEndpointManagementContextConfiguration",
"controllerEndpointDiscoverer",
"management.endpoints.web.cors-org.springframework.boot.actuate.autoconfigure.endpoint.web.CorsEndpointProperties",
"management.endpoints.web-org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties"
]
},
"management.endpoint.env-org.springframework.boot.actuate.autoconfigure.env.EnvironmentEndpointProperties": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.env.EnvironmentEndpointProperties",
"resource": null,
"dependencies": []
},
"org.springframework.boot.actuate.autoconfigure.metrics.JvmMetricsAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.metrics.JvmMetricsAutoConfiguration",
"resource": null,
"dependencies": []
},
"org.springframework.boot.devtools.autoconfigure.LocalDevToolsAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.devtools.autoconfigure.LocalDevToolsAutoConfiguration",
"resource": null,
"dependencies": []
},
"org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$Jackson2ObjectMapperBuilderCustomizerConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$Jackson2ObjectMapperBuilderCustomizerConfiguration",
"resource": null,
"dependencies": []
},
"org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration$StringHttpMessageConverterConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration$StringHttpMessageConverterConfiguration",
"resource": null,
"dependencies": []
},
"optionalLiveReloadServer": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.devtools.autoconfigure.OptionalLiveReloadServer",
"resource": "class path resource [org/springframework/boot/devtools/autoconfigure/LocalDevToolsAutoConfiguration$LiveReloadConfiguration.class]",
"dependencies": [
"org.springframework.boot.devtools.autoconfigure.LocalDevToolsAutoConfiguration$LiveReloadConfiguration",
"liveReloadServer"
]
},
"org.springframework.boot.actuate.autoconfigure.management.ThreadDumpEndpointAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.management.ThreadDumpEndpointAutoConfiguration",
"resource": null,
"dependencies": []
},
"org.springframework.boot.autoconfigure.availability.ApplicationAvailabilityAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.availability.ApplicationAvailabilityAutoConfiguration",
"resource": null,
"dependencies": []
},
"standardJacksonObjectMapperBuilderCustomizer": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$Jackson2ObjectMapperBuilderCustomizerConfiguration$StandardJackson2ObjectMapperBuilderCustomizer",
"resource": "class path resource [org/springframework/boot/autoconfigure/jackson/JacksonAutoConfiguration$Jackson2ObjectMapperBuilderCustomizerConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$Jackson2ObjectMapperBuilderCustomizerConfiguration",
"org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@955f77b",
"spring.jackson-org.springframework.boot.autoconfigure.jackson.JacksonProperties"
]
},
"taskSchedulerBuilder": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.task.TaskSchedulerBuilder",
"resource": "class path resource [org/springframework/boot/autoconfigure/task/TaskSchedulingAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration",
"spring.task.scheduling-org.springframework.boot.autoconfigure.task.TaskSchedulingProperties"
]
},
"metricsEndpoint": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.metrics.MetricsEndpoint",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/MetricsEndpointAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.metrics.MetricsEndpointAutoConfiguration",
"simpleMeterRegistry"
]
},
"org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration",
"resource": null,
"dependencies": []
},
"org.springframework.boot.autoconfigure.aop.AopAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.aop.AopAutoConfiguration",
"resource": null,
"dependencies": []
},
"org.springframework.boot.actuate.autoconfigure.info.InfoContributorAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.info.InfoContributorAutoConfiguration",
"resource": null,
"dependencies": []
},
"org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration",
"resource": null,
"dependencies": []
},
"simpleMeterRegistry": {
"aliases": [],
"scope": "singleton",
"type": "io.micrometer.core.instrument.simple.SimpleMeterRegistry",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/export/simple/SimpleMetricsExportAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimpleMetricsExportAutoConfiguration",
"simpleConfig",
"micrometerClock"
]
},
"org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration",
"resource": null,
"dependencies": []
},
"environmentEndpoint": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.env.EnvironmentEndpoint",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/env/EnvironmentEndpointAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.env.EnvironmentEndpointAutoConfiguration",
"environment",
"management.endpoint.env-org.springframework.boot.actuate.autoconfigure.env.EnvironmentEndpointProperties"
]
},
"restartingClassPathChangedEventListener": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.devtools.autoconfigure.LocalDevToolsAutoConfiguration$RestartConfiguration$$Lambda$877/0x0000000100511a60",
"resource": "class path resource [org/springframework/boot/devtools/autoconfigure/LocalDevToolsAutoConfiguration$RestartConfiguration.class]",
"dependencies": [
"org.springframework.boot.devtools.autoconfigure.LocalDevToolsAutoConfiguration$RestartConfiguration",
"fileSystemWatcherFactory"
]
},
"conventionErrorViewResolver": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.servlet.error.DefaultErrorViewResolver",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/error/ErrorMvcAutoConfiguration$DefaultErrorViewResolverConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$DefaultErrorViewResolverConfiguration"
]
},
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration",
"resource": null,
"dependencies": [
"spring.resources-org.springframework.boot.autoconfigure.web.ResourceProperties",
"spring.mvc-org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties",
"spring.web-org.springframework.boot.autoconfigure.web.WebProperties",
"org.springframework.beans.factory.support.DefaultListableBeanFactory@3eb4493d",
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter",
"metricsWebMvcConfigurer"
]
},
"org.springframework.boot.actuate.autoconfigure.metrics.web.tomcat.TomcatMetricsAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.metrics.web.tomcat.TomcatMetricsAutoConfiguration",
"resource": null,
"dependencies": []
},
"org.springframework.boot.actuate.autoconfigure.metrics.LogbackMetricsAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.metrics.LogbackMetricsAutoConfiguration",
"resource": null,
"dependencies": []
},
"spring.mvc-org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties",
"resource": null,
"dependencies": []
},
"localeCharsetMappingsCustomizer": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration$LocaleCharsetMappingsCustomizer",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/HttpEncodingAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration"
]
},
"org.springframework.boot.actuate.autoconfigure.logging.LoggersEndpointAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.logging.LoggersEndpointAutoConfiguration",
"resource": null,
"dependencies": []
},
"configurationPropertiesReportEndpoint": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.context.properties.ConfigurationPropertiesReportEndpoint",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/context/properties/ConfigurationPropertiesReportEndpointAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.context.properties.ConfigurationPropertiesReportEndpointAutoConfiguration",
"management.endpoint.configprops-org.springframework.boot.actuate.autoconfigure.context.properties.ConfigurationPropertiesReportEndpointProperties"
]
},
"formContentFilter": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.web.servlet.filter.OrderedFormContentFilter",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration"
]
},
"multipartConfigElement": {
"aliases": [],
"scope": "singleton",
"type": "javax.servlet.MultipartConfigElement",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/MultipartAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration"
]
},
"requestContextFilter": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter.class]",
"dependencies": []
},
"defaultViewResolver": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.web.servlet.view.InternalResourceViewResolver",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter"
]
},
"routerFunctionMapping": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.web.servlet.function.support.RouterFunctionMapping",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration",
"mvcConversionService",
"mvcResourceUrlProvider"
]
},
"jacksonObjectMapperBuilder": {
"aliases": [],
"scope": "prototype",
"type": "org.springframework.http.converter.json.Jackson2ObjectMapperBuilder",
"resource": "class path resource [org/springframework/boot/autoconfigure/jackson/JacksonAutoConfiguration$JacksonObjectMapperBuilderConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonObjectMapperBuilderConfiguration",
"org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@955f77b",
"standardJacksonObjectMapperBuilderCustomizer"
]
},
"org.springframework.boot.actuate.autoconfigure.web.mappings.MappingsEndpointAutoConfiguration$ServletWebConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.web.mappings.MappingsEndpointAutoConfiguration$ServletWebConfiguration",
"resource": null,
"dependencies": []
},
"beansEndpoint": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.beans.BeansEndpoint",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/beans/BeansEndpointAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.beans.BeansEndpointAutoConfiguration",
"org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@955f77b"
]
},
"management.endpoints.jmx-org.springframework.boot.actuate.autoconfigure.endpoint.jmx.JmxEndpointProperties": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.endpoint.jmx.JmxEndpointProperties",
"resource": null,
"dependencies": []
},
"liveReloadServer": {
"aliases": [],
"scope": "restart",
"type": "org.springframework.boot.devtools.livereload.LiveReloadServer",
"resource": "class path resource [org/springframework/boot/devtools/autoconfigure/LocalDevToolsAutoConfiguration$LiveReloadConfiguration.class]",
"dependencies": [
"org.springframework.boot.devtools.autoconfigure.LocalDevToolsAutoConfiguration$LiveReloadConfiguration",
"spring.devtools-org.springframework.boot.devtools.autoconfigure.DevToolsProperties"
]
},
"spring.task.scheduling-org.springframework.boot.autoconfigure.task.TaskSchedulingProperties": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.task.TaskSchedulingProperties",
"resource": null,
"dependencies": []
},
"webMvcMetricsFilter": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.web.servlet.FilterRegistrationBean",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/web/servlet/WebMvcMetricsAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.metrics.web.servlet.WebMvcMetricsAutoConfiguration",
"simpleMeterRegistry",
"webMvcTagsProvider"
]
},
"healthEndpointWebExtension": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.health.HealthEndpointWebExtension",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/health/HealthEndpointWebExtensionConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.health.HealthEndpointWebExtensionConfiguration",
"healthContributorRegistry",
"healthEndpointGroups"
]
},
"multipartResolver": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.web.multipart.support.StandardServletMultipartResolver",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/MultipartAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration"
]
},
"localeResolver": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
]
},
"handlerFunctionAdapter": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.web.servlet.function.support.HandlerFunctionAdapter",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
]
},
"org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration$WebEndpointServletConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration$WebEndpointServletConfiguration",
"resource": null,
"dependencies": []
},
"requestMappingHandlerMapping": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration",
"mvcContentNegotiationManager",
"mvcConversionService",
"mvcResourceUrlProvider"
]
},
"webExposeExcludePropertyEndpointFilter": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.endpoint.expose.IncludeExcludeEndpointFilter",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/web/WebEndpointAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration"
]
},
"lifecycleProcessor": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.context.support.DefaultLifecycleProcessor",
"resource": "class path resource [org/springframework/boot/autoconfigure/context/LifecycleAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration",
"spring.lifecycle-org.springframework.boot.autoconfigure.context.LifecycleProperties"
]
},
"org.springframework.boot.actuate.autoconfigure.web.server.ManagementContextAutoConfiguration$SameManagementContextConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.web.server.ManagementContextAutoConfiguration$SameManagementContextConfiguration",
"resource": null,
"dependencies": [
"environment"
]
},
"requestMappingHandlerAdapter": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration",
"mvcContentNegotiationManager",
"mvcConversionService",
"mvcValidator"
]
},
"tomcatMetricsBinder": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.metrics.web.tomcat.TomcatMetricsBinder",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/web/tomcat/TomcatMetricsAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.metrics.web.tomcat.TomcatMetricsAutoConfiguration",
"simpleMeterRegistry"
]
},
"classPathFileSystemWatcher": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.devtools.classpath.ClassPathFileSystemWatcher",
"resource": "class path resource [org/springframework/boot/devtools/autoconfigure/LocalDevToolsAutoConfiguration$RestartConfiguration.class]",
"dependencies": [
"org.springframework.boot.devtools.autoconfigure.LocalDevToolsAutoConfiguration$RestartConfiguration",
"fileSystemWatcherFactory",
"classPathRestartStrategy"
]
},
"org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration",
"resource": null,
"dependencies": [
"server-org.springframework.boot.autoconfigure.web.ServerProperties"
]
},
"org.springframework.boot.actuate.autoconfigure.endpoint.web.ServletEndpointManagementContextConfiguration$WebMvcServletEndpointManagementContextConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.endpoint.web.ServletEndpointManagementContextConfiguration$WebMvcServletEndpointManagementContextConfiguration",
"resource": null,
"dependencies": []
},
"org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration",
"resource": null,
"dependencies": []
},
"org.springframework.boot.actuate.autoconfigure.logging.LogFileWebEndpointAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.logging.LogFileWebEndpointAutoConfiguration",
"resource": null,
"dependencies": []
},
"springApplicationAdminRegistrar": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.admin.SpringApplicationAdminMXBeanRegistrar",
"resource": "class path resource [org/springframework/boot/autoconfigure/admin/SpringApplicationAdminJmxAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration",
"environment"
]
},
"spring.info-org.springframework.boot.autoconfigure.info.ProjectInfoProperties": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.info.ProjectInfoProperties",
"resource": null,
"dependencies": []
},
"org.springframework.boot.actuate.autoconfigure.metrics.MetricsEndpointAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.metrics.MetricsEndpointAutoConfiguration",
"resource": null,
"dependencies": []
},
"endpointOperationParameterMapper": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.endpoint.invoke.convert.ConversionServiceParameterValueMapper",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/EndpointAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.endpoint.EndpointAutoConfiguration"
]
},
"infoEndpoint": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.info.InfoEndpoint",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/info/InfoEndpointAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.info.InfoEndpointAutoConfiguration"
]
},
"org.springframework.boot.actuate.autoconfigure.metrics.web.client.HttpClientMetricsAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.metrics.web.client.HttpClientMetricsAutoConfiguration",
"resource": null,
"dependencies": []
},
"spring.resources-org.springframework.boot.autoconfigure.web.ResourceProperties": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.ResourceProperties",
"resource": null,
"dependencies": []
},
"eagerlyInitializeJmxEndpointExporter": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.LazyInitializationExcludeFilter$$Lambda$850/0x00000001004eacb8",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/jmx/JmxEndpointAutoConfiguration.class]",
"dependencies": []
},
"org.springframework.boot.actuate.autoconfigure.health.HealthContributorAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.health.HealthContributorAutoConfiguration",
"resource": null,
"dependencies": []
},
"org.springframework.boot.actuate.autoconfigure.info.InfoEndpointAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.info.InfoEndpointAutoConfiguration",
"resource": null,
"dependencies": []
},
"classLoaderMetrics": {
"aliases": [],
"scope": "singleton",
"type": "io.micrometer.core.instrument.binder.jvm.ClassLoaderMetrics",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/JvmMetricsAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.metrics.JvmMetricsAutoConfiguration"
]
},
"servletWebChildContextFactory": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.web.servlet.ServletManagementContextFactory",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/web/servlet/ServletManagementContextAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.web.servlet.ServletManagementContextAutoConfiguration"
]
},
"org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration",
"resource": null,
"dependencies": []
},
"org.springframework.boot.autoconfigure.internalCachingMetadataReaderFactory": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.core.type.classreading.CachingMetadataReaderFactory",
"resource": null,
"dependencies": []
},
"org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$ParameterNamesModuleConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$ParameterNamesModuleConfiguration",
"resource": null,
"dependencies": []
},
"mvcContentNegotiationManager": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.web.accept.ContentNegotiationManager",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
]
},
"objectNamingStrategy": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.jmx.ParentAwareNamingStrategy",
"resource": "class path resource [org/springframework/boot/autoconfigure/jmx/JmxAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration"
]
},
"conditionEvaluationDeltaLoggingListener": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.devtools.autoconfigure.ConditionEvaluationDeltaLoggingListener",
"resource": "class path resource [org/springframework/boot/devtools/autoconfigure/LocalDevToolsAutoConfiguration$RestartConfiguration.class]",
"dependencies": [
"org.springframework.boot.devtools.autoconfigure.LocalDevToolsAutoConfiguration$RestartConfiguration"
]
},
"org.springframework.boot.actuate.autoconfigure.metrics.CompositeMeterRegistryAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.metrics.CompositeMeterRegistryAutoConfiguration",
"resource": null,
"dependencies": []
},
"org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration",
"resource": null,
"dependencies": []
},
"org.springframework.boot.actuate.autoconfigure.audit.AuditEventsEndpointAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.audit.AuditEventsEndpointAutoConfiguration",
"resource": null,
"dependencies": []
},
"errorAttributes": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.web.servlet.error.DefaultErrorAttributes",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/error/ErrorMvcAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration"
]
},
"httpRequestHandlerAdapter": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
]
},
"org.springframework.boot.actuate.autoconfigure.web.mappings.MappingsEndpointAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.web.mappings.MappingsEndpointAutoConfiguration",
"resource": null,
"dependencies": []
},
"beanNameHandlerMapping": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration",
"mvcConversionService",
"mvcResourceUrlProvider"
]
},
"org.springframework.boot.actuate.autoconfigure.health.HealthEndpointConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.health.HealthEndpointConfiguration",
"resource": null,
"dependencies": []
},
"webMvcTagsProvider": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.metrics.web.servlet.DefaultWebMvcTagsProvider",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/web/servlet/WebMvcMetricsAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.metrics.web.servlet.WebMvcMetricsAutoConfiguration"
]
},
"spring.servlet.multipart-org.springframework.boot.autoconfigure.web.servlet.MultipartProperties": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.servlet.MultipartProperties",
"resource": null,
"dependencies": []
},
"org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration",
"resource": null,
"dependencies": [
"spring.info-org.springframework.boot.autoconfigure.info.ProjectInfoProperties"
]
},
"org.springframework.boot.actuate.autoconfigure.metrics.web.client.RestTemplateMetricsConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.metrics.web.client.RestTemplateMetricsConfiguration",
"resource": null,
"dependencies": []
},
"org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryConfiguration$EmbeddedTomcat": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryConfiguration$EmbeddedTomcat",
"resource": null,
"dependencies": []
},
"org.springframework.boot.actuate.autoconfigure.management.HeapDumpWebEndpointAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.management.HeapDumpWebEndpointAutoConfiguration",
"resource": null,
"dependencies": []
},
"org.springframework.boot.devtools.autoconfigure.LocalDevToolsAutoConfiguration$RestartConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.devtools.autoconfigure.LocalDevToolsAutoConfiguration$RestartConfiguration",
"resource": null,
"dependencies": [
"spring.devtools-org.springframework.boot.devtools.autoconfigure.DevToolsProperties"
]
},
"resourceHandlerMapping": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.web.servlet.handler.SimpleUrlHandlerMapping",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration",
"mvcContentNegotiationManager",
"mvcConversionService",
"mvcResourceUrlProvider"
]
},
"simpleControllerHandlerAdapter": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
]
},
"org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimpleMetricsExportAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimpleMetricsExportAutoConfiguration",
"resource": null,
"dependencies": []
},
"cachesEndpointWebExtension": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.cache.CachesEndpointWebExtension",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/cache/CachesEndpointAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.cache.CachesEndpointAutoConfiguration",
"cachesEndpoint"
]
},
"org.springframework.boot.actuate.autoconfigure.context.properties.ConfigurationPropertiesReportEndpointAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.context.properties.ConfigurationPropertiesReportEndpointAutoConfiguration",
"resource": null,
"dependencies": []
},
"spring.lifecycle-org.springframework.boot.autoconfigure.context.LifecycleProperties": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.context.LifecycleProperties",
"resource": null,
"dependencies": []
},
"management.metrics-org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties",
"resource": null,
"dependencies": []
},
"flashMapManager": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.web.servlet.support.SessionFlashMapManager",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
]
},
"healthContributorRegistry": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.health.AutoConfiguredHealthContributorRegistry",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/health/HealthEndpointConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.health.HealthEndpointConfiguration",
"org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@955f77b",
"healthEndpointGroups"
]
},
"management.endpoint.configprops-org.springframework.boot.actuate.autoconfigure.context.properties.ConfigurationPropertiesReportEndpointProperties": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.context.properties.ConfigurationPropertiesReportEndpointProperties",
"resource": null,
"dependencies": []
},
"parameterNamesModule": {
"aliases": [],
"scope": "singleton",
"type": "com.fasterxml.jackson.module.paramnames.ParameterNamesModule",
"resource": "class path resource [org/springframework/boot/autoconfigure/jackson/JacksonAutoConfiguration$ParameterNamesModuleConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$ParameterNamesModuleConfiguration"
]
},
"micrometerClock": {
"aliases": [],
"scope": "singleton",
"type": "io.micrometer.core.instrument.Clock$1",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/MetricsAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.metrics.MetricsAutoConfiguration"
]
},
"org.springframework.boot.actuate.autoconfigure.beans.BeansEndpointAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.beans.BeansEndpointAutoConfiguration",
"resource": null,
"dependencies": []
},
"fileSystemWatcherFactory": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.devtools.autoconfigure.LocalDevToolsAutoConfiguration$RestartConfiguration$$Lambda$876/0x0000000100511218",
"resource": "class path resource [org/springframework/boot/devtools/autoconfigure/LocalDevToolsAutoConfiguration$RestartConfiguration.class]",
"dependencies": [
"org.springframework.boot.devtools.autoconfigure.LocalDevToolsAutoConfiguration$RestartConfiguration"
]
},
"propertiesMeterFilter": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.metrics.PropertiesMeterFilter",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/MetricsAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.metrics.MetricsAutoConfiguration",
"management.metrics-org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties"
]
},
"healthHttpCodeStatusMapper": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.health.SimpleHttpCodeStatusMapper",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/health/HealthEndpointConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.health.HealthEndpointConfiguration",
"management.endpoint.health-org.springframework.boot.actuate.autoconfigure.health.HealthEndpointProperties"
]
},
"org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration",
"resource": null,
"dependencies": []
},
"uptimeMetrics": {
"aliases": [],
"scope": "singleton",
"type": "io.micrometer.core.instrument.binder.system.UptimeMetrics",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/SystemMetricsAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.metrics.SystemMetricsAutoConfiguration"
]
},
"controllerExposeExcludePropertyEndpointFilter": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.endpoint.expose.IncludeExcludeEndpointFilter",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/web/WebEndpointAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration"
]
},
"pathMappedEndpoints": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.endpoint.web.PathMappedEndpoints",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/web/WebEndpointAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration",
"jmxAnnotationEndpointDiscoverer",
"servletEndpointDiscoverer",
"webEndpointDiscoverer",
"controllerEndpointDiscoverer"
]
},
"jvmThreadMetrics": {
"aliases": [],
"scope": "singleton",
"type": "io.micrometer.core.instrument.binder.jvm.JvmThreadMetrics",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/JvmMetricsAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.metrics.JvmMetricsAutoConfiguration"
]
},
"scheduledTasksEndpoint": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.scheduling.ScheduledTasksEndpoint",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/scheduling/ScheduledTasksEndpointAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.scheduling.ScheduledTasksEndpointAutoConfiguration"
]
},
"heapDumpWebEndpoint": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.management.HeapDumpWebEndpoint",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/management/HeapDumpWebEndpointAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.management.HeapDumpWebEndpointAutoConfiguration"
]
},
"managementServletContext": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.web.servlet.ServletManagementContextAutoConfiguration$$Lambda$813/0x00000001004d1a48",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/web/servlet/ServletManagementContextAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.web.servlet.ServletManagementContextAutoConfiguration",
"management.endpoints.web-org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties"
]
},
"fileDescriptorMetrics": {
"aliases": [],
"scope": "singleton",
"type": "io.micrometer.core.instrument.binder.system.FileDescriptorMetrics",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/SystemMetricsAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.metrics.SystemMetricsAutoConfiguration"
]
},
"org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration",
"resource": null,
"dependencies": [
"server-org.springframework.boot.autoconfigure.web.ServerProperties"
]
},
"servletEndpointDiscoverer": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.endpoint.web.annotation.ServletEndpointDiscoverer",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/web/WebEndpointAutoConfiguration$WebEndpointServletConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration$WebEndpointServletConfiguration",
"org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@955f77b"
]
},
"environmentEndpointWebExtension": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.env.EnvironmentEndpointWebExtension",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/env/EnvironmentEndpointAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.env.EnvironmentEndpointAutoConfiguration",
"environmentEndpoint"
]
},
"metricsHttpServerUriTagFilter": {
"aliases": [],
"scope": "singleton",
"type": "io.micrometer.core.instrument.config.MeterFilter$9",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/web/servlet/WebMvcMetricsAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.metrics.web.servlet.WebMvcMetricsAutoConfiguration"
]
},
"mvcValidator": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport$NoOpValidator",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
]
},
"org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration$TomcatWebSocketConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration$TomcatWebSocketConfiguration",
"resource": null,
"dependencies": []
},
"conditionsReportEndpoint": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.condition.ConditionsReportEndpoint",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/condition/ConditionsReportEndpointAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.condition.ConditionsReportEndpointAutoConfiguration",
"org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@955f77b"
]
},
"applicationAvailability": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.availability.ApplicationAvailabilityBean",
"resource": "class path resource [org/springframework/boot/autoconfigure/availability/ApplicationAvailabilityAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.availability.ApplicationAvailabilityAutoConfiguration"
]
},
"org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration",
"resource": null,
"dependencies": []
},
"mvcResourceUrlProvider": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.web.servlet.resource.ResourceUrlProvider",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
]
},
"healthEndpoint": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.health.HealthEndpoint",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/health/HealthEndpointConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.health.HealthEndpointConfiguration",
"healthContributorRegistry",
"healthEndpointGroups"
]
},
"org.springframework.boot.actuate.autoconfigure.web.server.ManagementContextAutoConfiguration$SameManagementContextConfiguration$EnableSameManagementContextConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.web.server.ManagementContextAutoConfiguration$SameManagementContextConfiguration$EnableSameManagementContextConfiguration",
"resource": null,
"dependencies": []
},
"spring.task.execution-org.springframework.boot.autoconfigure.task.TaskExecutionProperties": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.task.TaskExecutionProperties",
"resource": null,
"dependencies": []
},
"viewControllerHandlerMapping": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.web.servlet.HandlerMapping",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration",
"mvcConversionService",
"mvcResourceUrlProvider"
]
},
"themeResolver": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.web.servlet.theme.FixedThemeResolver",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
]
},
"org.springframework.boot.actuate.autoconfigure.availability.AvailabilityHealthContributorAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.availability.AvailabilityHealthContributorAutoConfiguration",
"resource": null,
"dependencies": []
},
"mvcPatternParser": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.web.util.pattern.PathPatternParser",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
]
},
"servletEndpointRegistrar": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.endpoint.web.ServletEndpointRegistrar",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/web/ServletEndpointManagementContextConfiguration$WebMvcServletEndpointManagementContextConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.endpoint.web.ServletEndpointManagementContextConfiguration$WebMvcServletEndpointManagementContextConfiguration",
"management.endpoints.web-org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties",
"servletEndpointDiscoverer",
"dispatcherServletRegistration"
]
},
"dumpEndpoint": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.management.ThreadDumpEndpoint",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/management/ThreadDumpEndpointAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.management.ThreadDumpEndpointAutoConfiguration"
]
},
"org.springframework.boot.sql.init.dependency.DatabaseInitializationDependencyConfigurer$DependsOnDatabaseInitializationPostProcessor": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.sql.init.dependency.DatabaseInitializationDependencyConfigurer$DependsOnDatabaseInitializationPostProcessor",
"resource": null,
"dependencies": []
},
"dispatcherServlet": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.web.servlet.DispatcherServlet",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/DispatcherServletAutoConfiguration$DispatcherServletConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration$DispatcherServletConfiguration",
"spring.mvc-org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties"
]
},
"classPathRestartStrategy": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.devtools.classpath.PatternClassPathRestartStrategy",
"resource": "class path resource [org/springframework/boot/devtools/autoconfigure/LocalDevToolsAutoConfiguration$RestartConfiguration.class]",
"dependencies": [
"org.springframework.boot.devtools.autoconfigure.LocalDevToolsAutoConfiguration$RestartConfiguration"
]
},
"greetingController": {
"aliases": [],
"scope": "singleton",
"type": "com.systempro.greetingservice.controller.GreetingController",
"resource": "file [C:\\temp\\work-Space-microservices\\greeting-service\\target\\classes\\com\\systempro\\greetingservice\\controller\\GreetingController.class]",
"dependencies": [
"greetingConfig"
]
},
"org.springframework.boot.actuate.autoconfigure.endpoint.web.ServletEndpointManagementContextConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.endpoint.web.ServletEndpointManagementContextConfiguration",
"resource": null,
"dependencies": []
},
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration",
"resource": null,
"dependencies": []
},
"spring.devtools-org.springframework.boot.devtools.autoconfigure.DevToolsProperties": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.devtools.autoconfigure.DevToolsProperties",
"resource": null,
"dependencies": []
},
"webEndpointServletHandlerMapping": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.endpoint.web.servlet.WebMvcEndpointHandlerMapping",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/web/servlet/WebMvcEndpointManagementContextConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.endpoint.web.servlet.WebMvcEndpointManagementContextConfiguration",
"webEndpointDiscoverer",
"servletEndpointDiscoverer",
"controllerEndpointDiscoverer",
"endpointMediaTypes",
"management.endpoints.web.cors-org.springframework.boot.actuate.autoconfigure.endpoint.web.CorsEndpointProperties",
"management.endpoints.web-org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties",
"environment"
]
},
"processorMetrics": {
"aliases": [],
"scope": "singleton",
"type": "io.micrometer.core.instrument.binder.system.ProcessorMetrics",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/SystemMetricsAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.metrics.SystemMetricsAutoConfiguration"
]
},
"dispatcherServletMappingDescriptionProvider": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.web.mappings.servlet.DispatcherServletsMappingDescriptionProvider",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/web/mappings/MappingsEndpointAutoConfiguration$ServletWebConfiguration$SpringMvcConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.web.mappings.MappingsEndpointAutoConfiguration$ServletWebConfiguration$SpringMvcConfiguration"
]
},
"org.springframework.boot.actuate.autoconfigure.scheduling.ScheduledTasksEndpointAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.scheduling.ScheduledTasksEndpointAutoConfiguration",
"resource": null,
"dependencies": []
},
"org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration",
"resource": null,
"dependencies": []
},
"org.springframework.boot.actuate.autoconfigure.metrics.integration.IntegrationMetricsAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.metrics.integration.IntegrationMetricsAutoConfiguration",
"resource": null,
"dependencies": []
},
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter",
"resource": null,
"dependencies": [
"spring.resources-org.springframework.boot.autoconfigure.web.ResourceProperties",
"spring.web-org.springframework.boot.autoconfigure.web.WebProperties",
"spring.mvc-org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties",
"org.springframework.beans.factory.support.DefaultListableBeanFactory@3eb4493d"
]
},
"greetingConfig": {
"aliases": [],
"scope": "singleton",
"type": "com.systempro.greetingservice.config.GreetingConfig",
"resource": "file [C:\\temp\\work-Space-microservices\\greeting-service\\target\\classes\\com\\systempro\\greetingservice\\config\\GreetingConfig.class]",
"dependencies": []
},
"errorPageRegistrarBeanPostProcessor": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.web.server.ErrorPageRegistrarBeanPostProcessor",
"resource": null,
"dependencies": []
},
"errorPageCustomizer": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$ErrorPageCustomizer",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/error/ErrorMvcAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration",
"dispatcherServletRegistration"
]
},
"mvcConversionService": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.format.WebConversionService",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
]
},
"metricsWebMvcConfigurer": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.metrics.web.servlet.WebMvcMetricsAutoConfiguration$MetricsWebMvcConfigurer",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/web/servlet/WebMvcMetricsAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.metrics.web.servlet.WebMvcMetricsAutoConfiguration",
"simpleMeterRegistry",
"webMvcTagsProvider"
]
},
"loggersEndpoint": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.logging.LoggersEndpoint",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/logging/LoggersEndpointAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.logging.LoggersEndpointAutoConfiguration",
"springBootLoggingSystem"
]
},
"org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$DefaultErrorViewResolverConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$DefaultErrorViewResolverConfiguration",
"resource": null,
"dependencies": [
"org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@955f77b",
"spring.resources-org.springframework.boot.autoconfigure.web.ResourceProperties",
"spring.web-org.springframework.boot.autoconfigure.web.WebProperties"
]
},
"jmxIncludeExcludePropertyEndpointFilter": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.endpoint.expose.IncludeExcludeEndpointFilter",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/jmx/JmxEndpointAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.endpoint.jmx.JmxEndpointAutoConfiguration"
]
},
"controllerEndpointDiscoverer": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.endpoint.web.annotation.ControllerEndpointDiscoverer",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/web/WebEndpointAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration"
]
},
"diskSpaceHealthIndicator": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.system.DiskSpaceHealthIndicator",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/system/DiskSpaceHealthContributorAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.system.DiskSpaceHealthContributorAutoConfiguration",
"management.health.diskspace-org.springframework.boot.actuate.autoconfigure.system.DiskSpaceHealthIndicatorProperties"
]
},
"tomcatWebServerFactoryCustomizer": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.embedded.TomcatWebServerFactoryCustomizer",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/embedded/EmbeddedWebServerFactoryCustomizerAutoConfiguration$TomcatWebServerFactoryCustomizerConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration$TomcatWebServerFactoryCustomizerConfiguration",
"environment",
"server-org.springframework.boot.autoconfigure.web.ServerProperties"
]
},
"jvmMemoryMetrics": {
"aliases": [],
"scope": "singleton",
"type": "io.micrometer.core.instrument.binder.jvm.JvmMemoryMetrics",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/JvmMetricsAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.metrics.JvmMetricsAutoConfiguration"
]
},
"org.springframework.boot.actuate.autoconfigure.endpoint.EndpointAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.endpoint.EndpointAutoConfiguration",
"resource": null,
"dependencies": []
},
"org.springframework.boot.actuate.autoconfigure.condition.ConditionsReportEndpointAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.condition.ConditionsReportEndpointAutoConfiguration",
"resource": null,
"dependencies": []
},
"viewNameTranslator": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.web.servlet.view.DefaultRequestToViewNameTranslator",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
]
},
"org.springframework.boot.autoconfigure.http.JacksonHttpMessageConvertersConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.http.JacksonHttpMessageConvertersConfiguration",
"resource": null,
"dependencies": []
},
"mvcPathMatcher": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.util.AntPathMatcher",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
]
},
"handlerExceptionResolver": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.web.servlet.handler.HandlerExceptionResolverComposite",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration",
"mvcContentNegotiationManager"
]
},
"org.springframework.boot.actuate.autoconfigure.system.DiskSpaceHealthContributorAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.system.DiskSpaceHealthContributorAutoConfiguration",
"resource": null,
"dependencies": []
},
"management.metrics.export.simple-org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimpleProperties": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimpleProperties",
"resource": null,
"dependencies": []
},
"org.springframework.boot.actuate.autoconfigure.metrics.MetricsAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.metrics.MetricsAutoConfiguration",
"resource": null,
"dependencies": []
},
"basicErrorController": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/error/ErrorMvcAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration",
"errorAttributes"
]
},
"cachesEndpoint": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.cache.CachesEndpoint",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/cache/CachesEndpointAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.cache.CachesEndpointAutoConfiguration"
]
},
"pingHealthContributor": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.health.PingHealthIndicator",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/health/HealthContributorAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.health.HealthContributorAutoConfiguration"
]
},
"dispatcherServletRegistration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/DispatcherServletAutoConfiguration$DispatcherServletRegistrationConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration$DispatcherServletRegistrationConfiguration",
"dispatcherServlet",
"spring.mvc-org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties"
]
},
"mappingsEndpoint": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.web.mappings.MappingsEndpoint",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/web/mappings/MappingsEndpointAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.web.mappings.MappingsEndpointAutoConfiguration",
"org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@955f77b"
]
},
"healthEndpointGroupsBeanPostProcessor": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.health.HealthEndpointConfiguration$HealthEndpointGroupsBeanPostProcessor",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/health/HealthEndpointConfiguration.class]",
"dependencies": []
},
"management.endpoints.web-org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties",
"resource": null,
"dependencies": []
},
"tomcatServletWebServerFactory": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/ServletWebServerFactoryConfiguration$EmbeddedTomcat.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryConfiguration$EmbeddedTomcat"
]
},
"org.springframework.boot.autoconfigure.http.JacksonHttpMessageConvertersConfiguration$MappingJackson2HttpMessageConverterConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.http.JacksonHttpMessageConvertersConfiguration$MappingJackson2HttpMessageConverterConfiguration",
"resource": null,
"dependencies": []
},
"liveReloadServerEventListener": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.devtools.autoconfigure.LocalDevToolsAutoConfiguration$LiveReloadServerEventListener",
"resource": "class path resource [org/springframework/boot/devtools/autoconfigure/LocalDevToolsAutoConfiguration$LiveReloadConfiguration.class]",
"dependencies": [
"org.springframework.boot.devtools.autoconfigure.LocalDevToolsAutoConfiguration$LiveReloadConfiguration",
"optionalLiveReloadServer"
]
},
"spring.jackson-org.springframework.boot.autoconfigure.jackson.JacksonProperties": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.jackson.JacksonProperties",
"resource": null,
"dependencies": []
},
"greetingServiceApplication": {
"aliases": [],
"scope": "singleton",
"type": "com.systempro.greetingservice.GreetingServiceApplication$$EnhancerBySpringCGLIB$$df325b99",
"resource": null,
"dependencies": []
},
"error": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$StaticView",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/error/ErrorMvcAutoConfiguration$WhitelabelErrorViewConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$WhitelabelErrorViewConfiguration"
]
},
"org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration",
"resource": null,
"dependencies": []
},
"org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonObjectMapperConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonObjectMapperConfiguration",
"resource": null,
"dependencies": []
},
"org.springframework.boot.actuate.autoconfigure.health.HealthEndpointAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.health.HealthEndpointAutoConfiguration",
"resource": null,
"dependencies": []
},
"org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$WhitelabelErrorViewConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$WhitelabelErrorViewConfiguration",
"resource": null,
"dependencies": []
},
"org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration$DispatcherServletConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration$DispatcherServletConfiguration",
"resource": null,
"dependencies": []
},
"spring.web-org.springframework.boot.autoconfigure.web.WebProperties": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.WebProperties",
"resource": null,
"dependencies": []
},
"org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration",
"resource": null,
"dependencies": [
"environment"
]
},
"jvmGcMetrics": {
"aliases": [],
"scope": "singleton",
"type": "io.micrometer.core.instrument.binder.jvm.JvmGcMetrics",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/JvmMetricsAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.metrics.JvmMetricsAutoConfiguration"
]
},
"mvcViewResolver": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.web.servlet.view.ViewResolverComposite",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration",
"mvcContentNegotiationManager"
]
},
"simpleConfig": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimplePropertiesConfigAdapter",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/export/simple/SimpleMetricsExportAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimpleMetricsExportAutoConfiguration",
"management.metrics.export.simple-org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimpleProperties"
]
},
"welcomePageHandlerMapping": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.web.servlet.WelcomePageHandlerMapping",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration",
"org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@955f77b",
"mvcConversionService",
"mvcResourceUrlProvider"
]
},
"servletExposeExcludePropertyEndpointFilter": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.endpoint.expose.IncludeExcludeEndpointFilter",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/web/ServletEndpointManagementContextConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.endpoint.web.ServletEndpointManagementContextConfiguration",
"management.endpoints.web-org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties"
]
},
"org.springframework.boot.actuate.autoconfigure.web.servlet.ServletManagementContextAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.web.servlet.ServletManagementContextAutoConfiguration",
"resource": null,
"dependencies": []
},
"mvcUriComponentsContributor": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.web.method.support.CompositeUriComponentsContributor",
"resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration",
"mvcConversionService",
"requestMappingHandlerAdapter"
]
},
"filterMappingDescriptionProvider": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.web.mappings.servlet.FiltersMappingDescriptionProvider",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/web/mappings/MappingsEndpointAutoConfiguration$ServletWebConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.web.mappings.MappingsEndpointAutoConfiguration$ServletWebConfiguration"
]
},
"org.springframework.boot.actuate.autoconfigure.web.server.ManagementContextAutoConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.web.server.ManagementContextAutoConfiguration",
"resource": null,
"dependencies": []
},
"jacksonObjectMapper": {
"aliases": [],
"scope": "singleton",
"type": "com.fasterxml.jackson.databind.ObjectMapper",
"resource": "class path resource [org/springframework/boot/autoconfigure/jackson/JacksonAutoConfiguration$JacksonObjectMapperConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonObjectMapperConfiguration",
"jacksonObjectMapperBuilder"
]
},
"envInfoContributor": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.info.EnvironmentInfoContributor",
"resource": "class path resource [org/springframework/boot/actuate/autoconfigure/info/InfoContributorAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.actuate.autoconfigure.info.InfoContributorAutoConfiguration",
"environment"
]
},
"org.springframework.boot.autoconfigure.aop.AopAutoConfiguration$ClassProxyingConfiguration": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.autoconfigure.aop.AopAutoConfiguration$ClassProxyingConfiguration",
"resource": null,
"dependencies": []
},
"management.endpoint.logfile-org.springframework.boot.actuate.autoconfigure.logging.LogFileWebEndpointProperties": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.actuate.autoconfigure.logging.LogFileWebEndpointProperties",
"resource": null,
"dependencies": []
},
"taskExecutorBuilder": {
"aliases": [],
"scope": "singleton",
"type": "org.springframework.boot.task.TaskExecutorBuilder",
"resource": "class path resource [org/springframework/boot/autoconfigure/task/TaskExecutionAutoConfiguration.class]",
"dependencies": [
"org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration",
"spring.task.execution-org.springframework.boot.autoconfigure.task.TaskExecutionProperties"
]
}
},
"parentId": null
}
}
}
