package Suites;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("org.example.users.api.regression")
@Execution(ExecutionMode.CONCURRENT)
public class RegressionTestSuite {
}
