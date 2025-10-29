@ECHO OFF
REM Apache Maven Wrapper startup script v3.3.2

SETLOCAL

SET WRAPPER_DIR=%~dp0\.mvn\wrapper
SET MVNW_JAR=%WRAPPER_DIR%\maven-wrapper.jar
SET MVNW_PROPERTIES=%WRAPPER_DIR%\maven-wrapper.properties

IF NOT EXIST "%MVNW_JAR%" (
  FOR /F "usebackq tokens=2 delims==" %%A IN (`findstr ^wrapperUrl= "%MVNW_PROPERTIES%"`) DO SET WRAPPER_URL=%%A
  WHERE curl >NUL 2>&1
  IF %ERRORLEVEL% EQU 0 (
    ECHO Downloading Maven Wrapper JAR from %WRAPPER_URL% 1>&2
    curl -fsSL "%WRAPPER_URL%" -o "%MVNW_JAR%"
  ) ELSE (
    WHERE wget >NUL 2>&1
    IF %ERRORLEVEL% EQU 0 (
      ECHO Downloading Maven Wrapper JAR from %WRAPPER_URL% 1>&2
      wget -q "%WRAPPER_URL%" -O "%MVNW_JAR%"
    ) ELSE (
      ECHO ERROR: curl or wget is required to download maven-wrapper.jar 1>&2
      EXIT /B 1
    )
  )
)

SET JAVA_EXEC=%JAVA_HOME%\bin\java.exe
IF NOT EXIST "%JAVA_EXEC%" SET JAVA_EXEC=java

SET WRAPPER_LAUNCHER=org.apache.maven.wrapper.MavenWrapperMain
SET CP="%MVNW_JAR%"

"%JAVA_EXEC%" %MAVEN_OPTS% -classpath %CP% %WRAPPER_LAUNCHER% %*
ENDLOCAL
