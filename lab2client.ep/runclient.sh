#/bin/bash

# Run in project directory

# Possible need to change here
main_class=edu.gu.hajo.mbclient.Main

java -Djava.security.policy=security.policy -cp ./bin ${main_class}\
 Pelle Pelle 127.0.0.1 6666 7890

exit 0

