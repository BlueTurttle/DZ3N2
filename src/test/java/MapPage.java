import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MapPage {

    private final ElementsCollection allHotelsCollection = $$x("//*[@aria-label='Карточка варианта жилья']");
    private final ElementsCollection markers = $$x("//div[@aria-label='property marker']");

    public void hoverOverCard() {
        sleep(5000);
        SelenideElement firstHotel = allHotelsCollection.first();
        firstHotel.hover();

        // Сохранение информации об отеле
        String hotelName = firstHotel.$x(".//h2[@data-testid='header-title']").getText();
        String starRating = firstHotel.$x(".//span[@data-testid='rating-stars']").getAttribute("aria-label"); // Звезды
        starRating = starRating.replaceAll("[^0-9]", "").substring(0, 1);
        String averageRating = firstHotel.$x(".//div[@class='ac4a7896c7']").getText(); // Средняя оценка
        String reviewCount = firstHotel.$x(".//div[@class='abf093bdfe f45d8e4c32 d935416c47']").getText(); // Количество отзывов
        reviewCount = reviewCount.replaceAll("[^0-9]", "");
        String price = firstHotel.$x(".//span[@data-testid='price-and-discounted-price']").getText(); // Стоимость

        System.out.println("Название отеля: " + hotelName);
        System.out.println("Количество звезд: " + starRating);
        System.out.println("Средняя оценка: " + averageRating);
        System.out.println("Количество отзывов: " + reviewCount);
        System.out.println("Стоимость: " + price);

        SelenideElement HotelMarker = markers.last();


        sleep(5000);
        HotelMarker.click();


    }

}
