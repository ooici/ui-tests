rm -rf reports generated_tests
mkdir reports
mkdir generated_tests
bin/multiplex_rel1.pl rel1_testcases/*
ls generated_tests

# REMOVE ALL BUT THE OSX TESTS

rm generated_tests/*inux*
rm generated_tests/*indows*

echo ant jar
ant jar

echo ant junit
ant junit
