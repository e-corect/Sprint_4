package practicum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static practicum.Constants.*;

public class MainPage {

    private static final String URL = SITE_URL;
    private WebDriver driver;
    // конструктор
    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    // "Вопрос о важном"
    private By accordionButton = By.className(ACCORDION_BUTTON_CLASSNAME);
    // Верхняя кнопка заказа
    private By topOrderButton = By.className(TOP_ORDER_BUTTON_CLASSNAME);
    // Кнопка заказа в центре страницы
    private By bottomOrderButton =By.xpath(BOTTOM_ORDER_BUTTON_XPATH);
    // Кнопка подтверждения куки
    private By confirmCookieButton = By.id(CONFIRM_COOCKIE_BUTTON_ID);

    // Открыть главную страницу сайта
    public MainPage open() {
        driver.get(URL);
        return this;
    }
    // Клик на вопросе
    public MainPage clickOnQuestion(int i){
        driver.findElements(accordionButton).get(i).click();
        return this;
    }

    // Переход к n-ой accordionButton
    public MainPage goToAccordionButton(int i){
        String ariaControls = driver.findElements(accordionButton).get(i).getAttribute(ACCORDION_BUTTON_ATTRIBUTE1_NAME);
        ((JavascriptExecutor) driver).executeScript(SCROLL_VIEW_ATTRIBUTE,
                driver.findElement(By.xpath(".//div[@aria-controls='" + ariaControls + "']")));
        return this;
    }

    // Получение атрибута aria-expanded, который понадобится для проверки, что произошло развертывание
    public String checkTextExpandsOnclick(int i){
        return driver.findElements(accordionButton).get(i).getAttribute(ACCORDION_BUTTON_ATTRIBUTE2_NAME);
    }

    // Получение атрибута hidden, который понадобится для проверки, что текст ответа больше не скрыт
    public String textIsNotHidden(int i){
        return driver.findElements(accordionButton).get(i).getAttribute(TEXT_HIDDEN_ATTRIBUTE_NAME);
    }

    // Получение текста открывшегося текста ответа
    public String getExpandedTextFromAnswer(int i){
        String ariaControls = driver.findElements(accordionButton).get(i).getAttribute(ACCORDION_BUTTON_ATTRIBUTE1_NAME);
        return new WebDriverWait(driver, Duration.ZERO.getSeconds())
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.id(ariaControls)))).getText();
    }

    // Получение текста вопроса
    public String getTextFromQuestion(int i){
        return driver.findElements(accordionButton).get(i).getText();
    }

    // Текст больше не скрыт
    public boolean questionTextIsDisplayed(int i){
        return driver.findElements(accordionButton).get(i).isDisplayed();
    }

    // Ожидание элемента
    public MainPage waitForElement(By element){
        new WebDriverWait(driver, Duration.ZERO.getSeconds())
                .until(ExpectedConditions.visibilityOf(driver.findElement(element)));
        return this;
    }

    // Нажать на кнопку "Заказать"
    public MainPage clickOnOrderButton(String orderButtonPosition) {
        if (orderButtonPosition.equals(TOP_BUTTON)){
            waitForElement(topOrderButton);
            confirmCoockie(confirmCookieButton);
            driver.findElement(topOrderButton).click();
        }

        else if (orderButtonPosition.equals(BOTTOM_BUTTON)){
            waitForElement(bottomOrderButton);
            confirmCoockie(confirmCookieButton);
            driver.findElement(bottomOrderButton).click();
        }
        return this;
    }
    // Подтверждение куки
    public MainPage confirmCoockie(By element){
        ((JavascriptExecutor) driver).executeScript(SCROLL_VIEW_ATTRIBUTE,
                driver.findElement(element));
        driver.findElement(element).click();
        return this;
    }
}


