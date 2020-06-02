docker stop selenium-container || true && docker rm selenium-container  || true
docker run -it -v `pwd`/screenshots:/root/screenshots --name selenium-container selenium-first /bin/bash /root/run-test.sh 
