package hw3;

import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.internal.invokers.AbstractParallelWorker;

import java.util.stream.Stream;

import static org.testng.Assert.assertThrows;

public class DeliveryCalculatorTest {
    @Test
    @Tag("Позитивный тест")
    void cheapestOrderTest() {
        Delivery delivery = new Delivery(1, CargoDimension.SMALL, false, ServiceWorkload.NORMAL);
        Assert.assertEquals(400, delivery.calculateDeliveryCost());
    }

    @Test(description = "Большой размер груза")
    @Tag("Позитивный тест")
    void largeTest() {
        Delivery delivery = new Delivery(5, CargoDimension.LARGE, false, ServiceWorkload.NORMAL);

        Assert.assertNotEquals(250, delivery.calculateDeliveryCost());
    }

    @Test(description = "Минимальная стоимость доставки")
    @Tag("Позитивный тест")
    void minPriceTest() {
        Delivery delivery = new Delivery(1, CargoDimension.SMALL, false, ServiceWorkload.NORMAL);
        Assert.assertEquals(400, delivery.calculateDeliveryCost());
    }

    @Test(description = "Минимальная стоимость доставки")
    @Tag("Позитивный тест")
    void maxPriceTest() {
        Delivery delivery = new Delivery(30, CargoDimension.LARGE, true, ServiceWorkload.VERY_HIGH);
        double actualPrice = delivery.calculateDeliveryCost();
        Assert.assertEquals(1120, actualPrice);
    }
}
