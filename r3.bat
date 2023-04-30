@echo off
@if "%OS%" == "Windows_NT" setlocal

rem ##############################################
rem #                                            #
rem # r3-gen - Seam project and code generator #
rem #                                            #
rem ##############################################

set WORKING_DIR=%CD%
if "%WORKING_DIR:~-1%" == "\" (
    set WORKING_DIR=%WORKING_DIR:~0,-1%
)

if ["%R3_HOME%"] == [""] (
    set R3_HOME=%~dp0
) else (
    if not exist "%R3_HOME%\r3.bat" (goto nor3)
)
if "%R3_HOME:~-1%" == "\" (
    set R3_HOME=%R3_HOME:~0,-1%
)

set R3_GEN_DIR=%R3_HOME%\r3-gen
set COMMAND=%1%

if [%COMMAND%] == [] (goto usage)

if %COMMAND% == help (goto help)

if ["%JAVA_HOME%"] == [""] (goto nojava)

if not exist "%JAVA_HOME%\bin\javac.exe" (goto nojdk)

echo R3_HOME: %R3_HOME%
echo Using r3-gen sources from: %R3_GEN_DIR%

"%JAVA_HOME%\bin\java" -cp "%JAVA_HOME%\lib\tools.jar;%R3_HOME%\lib\gen\ant-launcher.jar;%R3_HOME%\lib\gen\ant-nodeps.jar;%R3_HOME%\lib\gen\ant.jar" -Dant.home="%R3_HOME%\lib" org.apache.tools.ant.launch.Launcher -buildfile "%R3_GEN_DIR%\build-r3model.xml" -Dworking.dir="%WORKING_DIR%" %*

goto END_NO_PAUSE

:nojava
echo The JAVA_HOME environment variable is not set
echo Please point it to a JDK installation
goto END_NO_PAUSE

:nojdk
echo The JAVA_HOME environment variable should point to a JDK, not a JRE
goto END_NO_PAUSE

:nor3
echo The R3_HOME environment variable should point to a Seam distribution
goto END_NO_PAUSE

:usage
more "%R3_GEN_DIR%\USAGE"
goto END_NO_PAUSE

:help
more "%r3_GEN_DIR%\README"
goto END_NO_PAUSE

:END_NO_PAUSE
