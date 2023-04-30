# openjdk sets default Xmx as 512m. Raaspi needs at least 800m
# can be overridden by using sudo java -Xmx1024m -jar ROOT-exex.jar
export CATALINA_OPTS="-Xms512m -Xmx800m"