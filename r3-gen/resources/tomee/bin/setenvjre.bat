set PORT=8080
rem goes into 100% cpu set CATALINA_OPTS=-Xms128M -Xmx400M -XX:MaxMetaspaceSize=120M
rem wildfly uses "-Xms64m -Xmx512m -XX:MetaspaceSize=96M -XX:MaxMetaspaceSize=256m
rem lots of memory set CATALINA_OPTS=-Xms128M -Xmx2000M
rem set CATALINA_OPTS=-Xms64m -Xmx2000m -XX:MetaspaceSize=96M -XX:MaxMetaspaceSize=1000m
rem becomes slow to respond set CATALINA_OPTS=-Xms64m -Xmx512m -XX:MetaspaceSize=96M -XX:MaxMetaspaceSize=400m
set CATALINA_OPTS=-Xms128M -Xmx2000M
set "CURRENT_DIR=%cd%"
pushd ..
pushd ..
set TOP_DIR=%cd%
echo top_dir %TOP_DIR%
set JRE_HOME=%cd%\jre
echo JRE_HOME  %JRE_HOME%
popd
popd
set CURRENT_DIR=%cd%
echo current_dir %CURRENT_DIR%
start "" cmd /c "echo Starting app and initializing data wait about 5 mts !&echo(&pause"
