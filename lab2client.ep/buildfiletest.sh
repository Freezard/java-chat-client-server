#!/bin/bash

# Script to build the environment for file transmission
# Run in project directory


# Creates another dir (test) where the (second) client will run
# Probably not very robust script

# Possible need to change here
main_class=edu.gu.hajo.mbclient.Main

# Always create a fresh jar
cd ./bin
jar -cvf client.jar edu/ > /dev/null
cd -

# if directory filetest not exists, create
if [ ! -e "../filetest" ]
then
	mkdir ../filetest
	mkdir ../filetest/upload
	mkdir ../filetest/download
fi 

# Copy files
cp ./pics/*.* ../filetest/upload
cp security.policy ../filetest

# Need this else a warning (??)
rm -f ../filetest/client.jar 
mv  ./bin/client.jar ../filetest/ 

# if not exists, create script to start the client
if [ ! -e "../filetest/runfileclient.sh" ]
then
	echo '#!/bin/bash' > runfileclient.sh
	echo '#MUST BE RUN FROM filetest directory' >> runfileclient.sh
	echo java -Djava.security.policy=security.policy -cp client.jar ${main_class}\
 File File 127.0.0.1 1099 7895 >> runfileclient.sh
	echo exit 0 >> runfileclient.sh
	
	# Make script executable
	chmod u+x runfileclient.sh
	mv -f runfileclient.sh ../filetest
fi

exit 0;