#/bin/bash

# Run in project directory

# Possible need to change here
main_class=edu.gu.hajo.mbclient.Main

java -Djava.security.policy=security.policy -cp ./bin ${main_class}\
 Fia Fia 127.0.0.1 6666 7891

exit 0

