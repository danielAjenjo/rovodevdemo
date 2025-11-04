@ECHO OFF
setlocal
set BASE_DIR=%~dp0
set WRAPPER_DIR=%BASE_DIR%\.mvn\wrapper
set WRAPPER_JAR=%WRAPPER_DIR%\maven-wrapper.jar
set PROPS_FILE=%WRAPPER_DIR%\maven-wrapper.properties

IF NOT EXIST "%WRAPPER_JAR%" (
  FOR /F "tokens=2 delims==" %%A IN ('findstr /R "^wrapperUrl=" "%PROPS_FILE%"') DO set WRAPPER_URL=%%A
  powershell -Command "Invoke-WebRequest -OutFile '%WRAPPER_JAR%' -Uri '%WRAPPER_URL%'"
)

set JAVA_EXE=%JAVA_HOME%\bin\java.exe
IF NOT EXIST "%JAVA_EXE%" set JAVA_EXE=java.exe

"%JAVA_EXE%" -Dmaven.multiModuleProjectDirectory="%BASE_DIR%" -classpath "%WRAPPER_JAR%" org.apache.maven.wrapper.MavenWrapperMain %*
