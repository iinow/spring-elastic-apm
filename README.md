```shell
java -javaagent:/Users/week/workspaces/apm/elastic-apm-agent.jar \
-Delastic.apm.service_name=my-service-name \
-Delastic.apm.server_urls=http://localhost:8200 \
-Delastic.apm.environment=my-environment \
-Delastic.apm.application_packages=com.elastic.apm \
-Delastic.apm.remote_config.enabled=false \
-jar build/libs/apm-0.0.1-SNAPSHOT.jar

docker-compose up -d elasticsearch
docker exec -it elasticsearch /bin/bash
bin/elasticsearch-service-tokens create elastic/kibana kibana-token


docker-compose up -d kibana apm-server

```