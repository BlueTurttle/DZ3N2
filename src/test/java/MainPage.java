import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class MainPage {
    private final SelenideElement textBoxInput = $x("//input[@name='ss']");
    private final SelenideElement buttonSelectDate = $x("//button [@data-testid='date-display-field-start']");
    private final SelenideElement cookie = $x("//*[@id=\"onetrust-reject-all-handler\"]");
    private final SelenideElement buttonNextMonth = $x("//button [@aria-label='Следующий месяц']");
    private final SelenideElement searchButton = $x("//button[@type='submit']");
    private final SelenideElement krestik = $x("//button[@aria-label='Скрыть меню входа в аккаунт.']");

    public MainPage(String url) {
        Selenide.open(url);
    }

    public void searchCountry(String name) {
        textBoxInput.setValue(name);
    }

    public void selectDates(String firstDate, String secondDate) {
        String xpath1 = "//span [@data-date='" + firstDate + "']";
        String xpath2 = "//span [@data-date='" + secondDate + "']";
        SelenideElement arrivalDate = $x(xpath1);
        SelenideElement departureDate = $x(xpath2);


        buttonSelectDate.click();
        while (!departureDate.isDisplayed()) {
            clickOnKrestic();
            buttonNextMonth.click();
        }
        arrivalDate.click();
        departureDate.click();
    }
    public void clickOnSearch() {
        searchButton.click();
    }

    public void clickOnCookie() {
        while (!cookie.isDisplayed()) {
            sleep(100);
        }
        cookie.click();
        sleep(3000);
    }
    public void clickOnKrestic() {
        if(krestik.isDisplayed()) {
            krestik.click();
        }
    }
}
