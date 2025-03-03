package hw3;

import org.testng.annotations.DataProvider;

public class CustomCargo {

    @DataProvider(name = "CustomCargo")
    public static Object[][] createData1() {
        return new Object[][]{
                {new Cargo(2, true, true), 550},
                {new Cargo(2, false, false), 150},
                {new Cargo(7, false, true), 500},
                {new Cargo(7, true, false), 300},
                {new Cargo(21, true, true), 700},
                {new Cargo(21, false, false), 300},
                {new Cargo(31, true, false), 500}
        };
    }
}
