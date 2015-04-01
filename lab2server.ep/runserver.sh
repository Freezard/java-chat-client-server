#/bin/bash

# Run in project directory

# Possible need to change here
main_class=edu.gu.hajo.mbserver.Main

reg_port=6666
server_port=7777

java -Djava.rmi.server.logCalls=true -Djava.security.policy=security.policy -Djava.rmi.server.hostname=127.0.0.1  -cp ./bin ${main_class} ${reg_port} ${server_port}

exit 0

