package hw3;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.testng.Tag;
import io.qameta.allure.testng.Tags;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CalculationUnitTest {
    @Step("Проверяем метод подсчета расстояния")
    @Description("Проверяем оплату на разные расстояния")
    @Tag("distance")
    @Test(dataProvider = "different_distance", dataProviderClass = MyDataProvider.class)
    public void testGetCostDistance(int distance, int summa) {

        int result = Calculation.getCostDistance(distance);

        Assert.assertEquals(summa, result);
    }

    @Step("Проверяем метод подсчета расстояния")
    @Description("Проверяем оплату на разные расстояния")
    @Tags({@Tag("distance"), @Tag("negative")})
    @Test(dataProvider = "negativeDistance", dataProviderClass = MyDataProvider.class)
    public void testGetCostDistanceNegative(int distance) {

        Assert.assertThrows("Расстояние должно быть больше 0",
                RuntimeException.class, () -> Calculation.getCostDistance(distance)
        );
    }

    @Step("Проверяем метод подсчета размера")
    @Description("Проверяем оплату за размер")
    @Tag("isBig")
    @Test(dataProvider = "cost", dataProviderClass = MyDataProvider.class)
    public void testGetCostBig(boolean big, int summa) {

        int result = Calculation.getCostBig(big);

        Assert.assertEquals(summa, result);
    }

    @Step("Проверяем метод подсчета хрупкости")
    @Description("Проверяем оплату за хрупкий товар")
    @Tags({@Tag("fragile"), @Tag("distance")})
    @Test(dataProvider = "fragile_distance", dataProviderClass = MyDataProvider.class)
    public void testGetCostFragile(boolean fragile, int distance, int summa) {

        int result = Calculation.getCostFragile(fragile, distance);

        Assert.assertEquals(result, summa);
    }

    @Step("Проверяем метод подсчета хрупкости")
    @Description("Проверяем оплату за хрупкий товар")
    @Tags({@Tag("fragile"), @Tag("distance"), @Tag("negative")})
    @Test(dataProvider = "fragile", dataProviderClass = MyDataProvider.class, groups = {"distance"})
    public void testGetCostFragileNegative(boolean fragile, int distance) {

        Assert.assertThrows("Хрупкие грузы нельзя возить на расстояние более 30 км",
                RuntimeException.class, () ->
                        Calculation.getCostFragile(fragile, distance)
        );
    }

    @Step("Проверяем метод подсчета с учетом min цены")
    @Description("Проверяем оплату с учетом min цены")
    @Tags({@Tag("fragile"), @Tag("distance"), @Tag("isBig")})
    @Test(dataProvider = "CustomCargo", dataProviderClass = CustomCargo.class)
    public void testGetCostWithCriteria(Cargo cargo, int summa) {
        int result = Calculation.getCostWithCriteria(cargo);

        Assert.assertEquals(summa, result);
    }

    @Step("Проверяем калькулятор с учетом загруженности")
    @Description("Проверяем оплату за загруженность склада")
    @Tags({@Tag("workload"), @Tag("fragile"), @Tag("distance"), @Tag("isBig")})
    @Test(dataProvider = "CustomArgumentsProvider", dataProviderClass = CustomArgumentsProvider.class, groups = {"workload", "distance"})
    public void testCalculation(Cargo cargo, double workload, int summa) {
        double result = Calculation.calculation(cargo, workload);

        Assert.assertEquals(summa * 1.0, result);
    }
}
