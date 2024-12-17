import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SearchPage {
    private final SelenideElement krestik = $x("//button[@aria-label='Скрыть меню входа в аккаунт.']");
    private final SelenideElement buttonMap = $x("//button [@data-map-trigger-button='1']");

    public void clickOnKrestic() {
        if(krestik.isDisplayed()) {
            krestik.click();
        }
    }
    public void clickOnButtonMap() {
        buttonMap.click();
    }
}
