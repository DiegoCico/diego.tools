package Tools;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class runTest {
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
