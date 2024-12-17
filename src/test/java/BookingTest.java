import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Random;

import static com.codeborne.selenide.Selenide.sleep;

public class BookingTest extends BaseTest{
    private final static String url = "https://booking.com/";
    private final static String searchString = "Египет";

    public LocalDate generateRandomDate() {
        Random random = new Random();
        LocalDate today = LocalDate.now();
        LocalDate nextYear = today.plusYears(1);
        long daysBetween = nextYear.toEpochDay() - today.toEpochDay();
        long randomDays = random.nextInt((int) daysBetween + 1);

        return today.plusDays(randomDays);
    }

    @Test
    @Description("Проверка правильности информации на сайте")
    @Step
    public void checkHotel() {
        MainPage mainPage = new MainPage(url);
        mainPage.clickOnCookie();
        mainPage.searchCountry(searchString);

        LocalDate randomDate = generateRandomDate();
        LocalDate datePlusTenDays = randomDate.plusDays(10);

        String arrivalDate = randomDate.toString();
        String departureDate = datePlusTenDays.toString();

        mainPage.selectDates(arrivalDate, departureDate);

        mainPage.clickOnSearch();

        sleep(2000);
        SearchPage searchPage = new SearchPage();
        searchPage.clickOnKrestic();
        searchPage.clickOnButtonMap();

        MapPage mapPage = new MapPage();
        //mapPage.FirstHotel();
        mapPage.hoverOverCard();
        FirsHotelPage firsHotelPage = new FirsHotelPage();
       firsHotelPage.checkHotelDetails();

    }

}
