package org.in.utils;


import io.cucumber.java.Scenario;


public class TestContext {

    private static ThreadLocal<String> testName = new ThreadLocal<>();
    private static Scenario scenario;

    public static String getTestName() {
        return testName.get();
    }

    public static void setTestName(String name) {
                testName.set(name);
    }

    public static Scenario getScenario() {
        return scenario;
    }

    public static void setScenario(Scenario scenario) {
        TestContext.scenario = scenario;
    }

    public  static void clearTestName() { testName.remove();}


}
