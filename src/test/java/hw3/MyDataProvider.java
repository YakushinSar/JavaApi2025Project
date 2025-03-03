package hw3;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyDataProvider {
    @DataProvider(name = "different_distance")
    public static Object[][] provideData() throws IOException {
        String csvFile = "src/test/resources/different_distance.csv";
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        String line;
        List<Integer[]> data = new ArrayList<>();

        reader.readLine();

        while ((line = reader.readLine()) != null) {
            String[] values = line.split(", ");
            data.add(new Integer[]{Integer.parseInt(values[0]), Integer.parseInt(values[1])});
        }

        reader.close();
        return data.toArray(new Object[data.size()][]);
    }

    @DataProvider(name = "negativeDistance")
    public Object[][] createData1() {
        return new Object[][]{{0}, {-6}};
    }

    @DataProvider(name = "cost")
    public Object[][] createData2() {
        return new Object[][]{{true, 200}, {false, 100}};
    }

    @DataProvider(name = "fragile_distance")
    public static Object[][] provideData2() throws IOException {
        String csvFile = "src/test/resources/fragile_distance.csv";
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        String line;
        List<Object[]> data = new ArrayList<>();

        reader.readLine();

        while ((line = reader.readLine()) != null) {
            String[] values = line.split(", ");
            data.add(new Object[]{Boolean.parseBoolean(values[0]), Integer.parseInt(values[1]), Integer.parseInt(values[2])});
        }

        reader.close();
        return data.toArray(new Object[data.size()][]);
    }

    @DataProvider(name = "fragile")
    public Object[][] createData3() {
        return new Object[][]{{true, 31,}, {true, 45}};
    }
}
