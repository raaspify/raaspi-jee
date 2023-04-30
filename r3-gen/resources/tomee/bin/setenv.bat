rem openjdk sets default Xmx as 512m. Raaspi needs at least 800m
rem can be overridden by using java -Xmx1024m -jar ROOT-exex.jar
set "JAVA_OPTS=%JAVA_OPTS% -Xms512m -Xmx800m"