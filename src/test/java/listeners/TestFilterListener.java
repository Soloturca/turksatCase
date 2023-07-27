package listeners;

import org.testng.*;

import java.util.*;
import java.util.regex.Pattern;

public class TestFilterListener implements IMethodInterceptor {

    private static Set<Pattern> patterns;

    private boolean includeTest(String testsToInclude, String currentTestName) {
        boolean result = false;

        if (patterns == null) {
            patterns = new HashSet<>();
            String[] testPatterns = testsToInclude.split(",");
            for (String testPattern : testPatterns) {
                patterns.add(Pattern.compile(testPattern, Pattern.CASE_INSENSITIVE));
            }
        }

        for (Pattern pattern : patterns) {
            if (pattern.matcher(currentTestName).find()) {
                result = true;
                break;
            }
        }

        return result;
    }

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        String testNames = System.getProperty("testname");
        if (testNames == null || testNames.trim().isEmpty()) {
            return methods;
        } else {
            if (includeTest(testNames, context.getName())) {
                System.out.println(testNames);
                return methods;
            } else {
                return new ArrayList<IMethodInstance>();
            }
        }
    }
}
