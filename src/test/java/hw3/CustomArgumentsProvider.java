package hw3;

import org.testng.annotations.DataProvider;

import static hw3.Workload.*;

public class CustomArgumentsProvider {

    @DataProvider(name = "CustomArgumentsProvider")
    public static Object[][] createData1() {
        return new Object[][]{
                {new Cargo(2, false, false), LOW_WORKLOAD, 400},
                {new Cargo(7, false, true), LOW_WORKLOAD, 500},
                {new Cargo(2, false, false), NORMAL_WORKLOAD, 400},
                {new Cargo(7, false, true), NORMAL_WORKLOAD, 600},
                {new Cargo(2, false, false), HIGH_WORKLOAD, 400},
                {new Cargo(7, false, true), HIGH_WORKLOAD, 700},
                {new Cargo(2, false, false), VERY_HIGH_WORKLOAD, 400},
                {new Cargo(7, false, true), VERY_HIGH_WORKLOAD, 800}
        };
    }
}
