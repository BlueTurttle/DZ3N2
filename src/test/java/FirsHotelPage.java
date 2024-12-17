import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirsHotelPage {

    private final SelenideElement hotelNameElement = $x("//h2");
    private final SelenideElement starRatingElement = $x("//span[@data-testid='rating-stars']");
    private final SelenideElement averageRatingElement = $x("//div[@id='js--hp-gallery-scorecard']");
    private final SelenideElement reviewCountElement = $x("//span[@class='a3b8729ab1 f45d8e4c32 d935416c47']");
    private final SelenideElement priceElement = $x("//span[@class='prco-valign-middle-helper']");




    public void checkHotelDetails() {

        String originalWindow = WebDriverRunner.getWebDriver().getWindowHandle();

        // Ожидаем, пока откроется новая вкладка
        waitUntilNewTabIsOpened(originalWindow);

        // Переключаемся на новую вкладку
        for (String windowHandle : WebDriverRunner.getWebDriver().getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                WebDriverRunner.getWebDriver().switchTo().window(windowHandle);
                break;
            }
        }

        // Извлечение информации

        String hotelName = hotelNameElement.getText();
        String starRating = getStarRating(); // Получаем количество звезд
        starRating = starRating.replaceAll("[^0-9]", "").substring(0, 1);
        String averageRating = averageRatingElement.getAttribute("data-review-score");
        averageRating = averageRating.replace(",", ".").trim();
        String reviewCount = reviewCountElement.getText();
        reviewCount = reviewCount.replaceAll("[^0-9]", "");
        String price = priceElement.getText();

        // Вывод информации
        System.out.println("Название отеля: " + hotelName);
        System.out.println("Количество звезд: " + starRating);
        System.out.println("Средняя оценка: " + averageRating);
        System.out.println("Количество отзывов: " + reviewCount);
        System.out.println("Стоимость: " + price);

        //assertEquals(expectedDetails.name, hotelName, "Название отеля не совпадает!");
        //assertEquals(expectedDetails.stars, starRating, "Количество звезд не совпадает!");
        //assertEquals(expectedDetails.averageRating, averageRating, "Средняя оценка не совпадает!");
       // assertEquals(expectedDetails.reviewCount, reviewCount, "Количество отзывов не совпадает!");
        //assertEquals(expectedDetails.price, price, "Стоимость не совпадает!");
    }

    private String getStarRating() {
        // Получаем количество заполненных звезд
        int filledStars = starRatingElement.$$("svg").size(); // Подсчитываем количество SVG-иконок
        return String.valueOf(filledStars); // Возвращаем количество заполненных звезд как строку
    }

    private void waitUntilNewTabIsOpened(String originalWindow) {
        // Ожидание, пока не откроется новая вкладка
        while (WebDriverRunner.getWebDriver().getWindowHandles().size() == 1) {
            try {
                Thread.sleep(100); // Пауза для предотвращения излишней загрузки процессора
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
