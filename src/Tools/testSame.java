package Tools;

import java.util.function.Supplier;

public class testSame {
    /**
     * Tests a function and compares its output to the expected output.
     * @param script Supplier function that returns a test value.
     * @param expectedOutput The expected output of the function.
     * @param name The name of the test.
     */
    public static <T> void testSame(Supplier<T> script, T expectedOutput, String name) {
        T actualOutput = script.get();
        if (actualOutput == null ? expectedOutput == null : actualOutput.equals(expectedOutput))
            System.out.println("Test (" + name + "): Passed");
        else
            System.out.println(String.format("Test (%s): Got = %s, Expected = %s", name, actualOutput, expectedOutput));
    }
}
