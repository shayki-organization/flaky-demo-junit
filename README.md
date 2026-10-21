# flaky-demo-junit

Demo repository for exercising a flaky-test detector against GitHub Actions logs
(Maven Surefire + JUnit 5).

- `src/test/java/com/example/CalcTest.java` contains stable tests plus two
  intentionally flaky tests (`flaky*`) that fail with ~40% probability per run.
- `.github/workflows/tests.yml` (`Tests` → `unit-tests`) runs `mvn -B test` so the
  standard surefire output (`[ERROR] Failures:`, `<<< FAILURE!`) appears in the log.
