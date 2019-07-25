%GRAALVM_HOME%\bin\native-image.cmd ^
  --enable-http ^
  --enable-https ^
  --no-fallback ^
  -H:EnableURLProtocols=http,https ^
  -H:+ReportExceptionStackTraces ^
  --initialize-at-build-time=scala.Symbol ^
  --initialize-at-build-time=scala.Function1 ^
  --initialize-at-build-time=scala.Function2 ^
  --allow-incomplete-classpath ^
  -J-Djava.security.properties=java.security.overrides ^
  -Djava.security.properties=java.security.overrides ^
  --report-unsupported-elements-at-runtime ^
  -jar target\scala-2.13\test-graalvm-windows-assembly-0.1.0-SNAPSHOT.jar ^
  test-graalvm
