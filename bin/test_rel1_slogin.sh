rm -rf reports generated_tests
mkdir reports
mkdir generated_tests
bin/multiplex_rel1_slogin.pl rel1_testcases/*
ls generated_tests

# REMOVE any that's not needed, like the OSX tests.
rm generated_tests/*inux*
rm generated_tests/*indows*
rm generated_tests/*sample*
rm generated_tests/*heart*
rm generated_tests/*orig*
#rm generated_tests/*FireFox*

echo ant jar
ant jar

echo ant junit
ant junit