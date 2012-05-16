rm -rf reports generated_tests
mkdir reports
mkdir generated_tests
bin/muxer_rel1_mlogin.pl rel1_testcases/*
ls generated_tests

# REMOVE any TC not needed, like the Linux/Windows/etc tests.
rm generated_tests/*inux*
rm generated_tests/*indows*
#rm generated_tests/*FireFox*
#rm generated_tests/*OS_X*

rm generated_tests/*r1_slogin*
#rm generated_tests/*sample*
#rm generated_tests/*heart*
#rm generated_tests/*orig*
#rm generated_tests/*r1_login*
#rm generated_tests/*00A*
#rm generated_tests/*00B*

echo ant jar
ant jar

echo ant junit
ant junit
