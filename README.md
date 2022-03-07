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


se eu passar paramentos no endpoint conforme abaixo:
http://localhost:8081/greeting?name=FernandoSilva

teremos o seguinte resultado:

{
"id": 2,
"content": "Olá, FernandoSilva!"


agora vamos verificar se a App esta UP!

com o actuator; 

http://localhost:8081/actuator

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

#agora vamos liberar endpoints, para testes e saber sobre os endpoints;


management:
  endpoints:
    web:
      exposure:
        include:
        - '*'
        
        
passando estes paramentos no application.yml libera 13 endpoints que estavam bloqueados por padrão do Actuator

veja os dados do console nos logs: Exposing 13 endpoint(s) beneath base path '/actuator'


depois de liberados os edpoints nos retorna estes endpoints pelo actuator:


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
