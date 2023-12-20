import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Supplier;

public class tools {

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

    /**
     * Reads input from the user and tries to parse it into Integer or Double.
     * If parsing fails, returns the raw string.
     * @return Parsed input or raw input string.
     */
    public static Object input() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ignored) {}

        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException ignored) {}

        return input;
    }

    /**
     * Prints elements of an ArrayList in a single line.
     * @param list The ArrayList to be printed.
     */
    public static void printArray(ArrayList<Object> list) {
        if (list.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            String stringL = "";
            for (Object obj : list) {
                stringL += obj + ", ";
            }
            System.out.println(stringL.substring(0, stringL.length() - 2));
        }
    }

    /**
     * Checks if an object is an instance of Integer.
     * @param s The object to check.
     * @return True if the object is an Integer, false otherwise.
     */
    public static boolean isAInteger(Object s) {
        return s instanceof Integer;
    }

    /**
     * Prints each element of a String array on a new line.
     * @param list The String array to print.
     */
    public static void linesToString(String[] list) {
        for (String str : list) {
            System.out.println(str);
        }
    }

    /**
     * Annotation for methods that should be tested.
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Test {}

    /**
     * Runs all methods annotated with @Test in a given class.
     * @param testClass The class containing test methods.
     */
    public static void runTest(Class<?> testClass) {
        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                try {
                    if (java.lang.reflect.Modifier.isStatic(method.getModifiers())) {
                        method.invoke(null); // Invoke static method with null
                    } else {
                        method.invoke(testClass.getDeclaredConstructor().newInstance()); // Invoke instance method
                    }
                    System.out.println("Test passed: " + method.getName());
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException e) {
                    System.out.println("Test failed: " + method.getName());
                    e.printStackTrace();
                }
            }
        }
    }
}
