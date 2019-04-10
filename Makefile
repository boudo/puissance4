# BOUDO
# Ibrahim
# RENNES 1
# 2015-2016

run: clean compil exec
	
exec:
	java -jar ./target/puissance4-0.0.1-SNAPSHOT.jar

compil:
	mvn package

clean:
	rm -rf target