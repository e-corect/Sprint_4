package practicum;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static practicum.Constants.*;

public class OrderPage {

    // конструктор
    public OrderPage(WebDriver driver) {
       this.driver = driver;
    }

    private WebDriver driver;

    // Поле для ввода Имени
    private By nameInput = By.xpath(NAME_INPUT_XPATH);
    // Поле для ввода Фамилии
    private By surnameInput = By.xpath(SURNAME_INPUT_XPATH);
    // Поле для ввода Адреса доставки
    private By addressInput = By.xpath(ADDRESS_INPUT_XPATH);
    // Поле для выбора станции метро
    private By metroStationInput = By.xpath(METRO_STATION_INPUT_XPATH);
    // Поле для ввода номера телефона
    private By phoneNumberInput = By.xpath(PHONE_NUMBER_INPUT_XPATH);
    // Поле для выбора даты доставки
    private By deliveryDateInput = By.xpath(DELIVERY_DATE_INPUT_XPATH);
    // Поле для выбора срока аренды
    private By rentalPeriodDropdown = By.className(RENTAL_PERIOD_DROPDOWN_CLASSNAME);
    // Чек-бокс для выбора цвета
    private By colorBlackCheckbox = By.id(BLACK_COLOR_CHECKBOX_ID);
    // Чек-бокс для выбора цвета
    private By colorGreyCheckbox = By.id(GREY_COLOR_CHECKBOX_ID);
    // Поле для ввода комментария
    private By commentInput = By.xpath(COMMENT_INPUT_XPATH);
    // Кнопка назад
    private By backButton = By.xpath(BACK_BUTTON_XPATH);
    // Кнопка для оформления заказа
    private By orderButton = By.xpath(ORDER_BUTTON_XPATH);
    // Кнопка "Да"
    private By yesButton = By.xpath(YES_BUTTON_XPATH);
    // Кнопка "Далее"
    private By nextButton = By.xpath(NEXT_BUTTON_XPATH);
    // Окно с текстом успешного заказа
    private By orderProcessed = By.xpath(ORDER_PROCESSED_XPATH);


    // Заполнение поля "Имя"
    public OrderPage fillFieldName(String text){
        driver.findElement(nameInput).sendKeys(text);
        return this;
    }

    // Заполнение поля "Фамилия"
    public OrderPage fillFieldSurname(String text){
        driver.findElement(surnameInput).sendKeys(text);
        return this;
    }

    // Заполнение поля "Адрес"
    public OrderPage fillFieldAddress(String text){
        driver.findElement(addressInput).sendKeys(text);
        return this;
    }

    // Заполнение поля "Телефон"
    public OrderPage fillFieldPhone(String text){
        driver.findElement(phoneNumberInput).sendKeys(text);
        return this;
    }

    // Выбор даты аренды, всегда на день вперед
    public OrderPage fillRentDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PUTTERN);
        String rentDate = LocalDate.now().plusDays(1).format(formatter);
        driver.findElement(deliveryDateInput).click();
        driver.findElement(deliveryDateInput).sendKeys(rentDate);
        driver.findElement(deliveryDateInput).sendKeys(Keys.ENTER);
        return this;
    }

    // Выбор срока аренды
    public OrderPage fillRentalPeriod(String period){
        waitForElement(rentalPeriodDropdown);
        driver.findElement(rentalPeriodDropdown).click();
        driver.findElement(By.xpath(XPATH_TEMPLATE + period + "']")).click();
        return this;
    }

    // Выбор станции метро
    public OrderPage fillMetroStation(String metroName){
        driver.findElement(metroStationInput).click();
        driver.findElement(metroStationInput).sendKeys(metroName);
        waitForElement(By.xpath(XPATH_TEMPLATE + metroName + "']"));
        driver.findElement(By.xpath(XPATH_TEMPLATE + metroName + "']")).click();
        return this;
    }

    // Нажатие на кнопку далее
    public OrderPage nextButtonClick(){
        driver.findElement(nextButton).click();
        return this;
    }

    // Ожидание для появления элемента
    public OrderPage waitForElement(By element){
        new WebDriverWait(driver, Duration.ZERO.getSeconds())
                .until(ExpectedConditions.visibilityOf(driver.findElement(element)));
        return this;
    }

    // Скролл до элемента
    public OrderPage scrollToElement(By element){
        new WebDriverWait(driver, Duration.ZERO.getSeconds())
                .until(ExpectedConditions.visibilityOf(driver.findElement(element)));
        return this;
    }

    // Нажатие на кнопку оформления заказа
    public OrderPage orderButtonClick(){
        waitForElement(orderButton).scrollToElement(orderButton);
        driver.findElement(orderButton).click();
        return this;
    }

    // Выбор цвета через чек-бокс
    public OrderPage setCollor(String color){

        if (color!=null) {

            if (color.equals(BLACK_COLOR_NAME)) {
                driver.findElement(colorBlackCheckbox).click();
            }

            if (color.equals(GREY_COOLOR_NAME)) {
                driver.findElement(colorGreyCheckbox).click();
            }

        }
        return this;
    }

    // Заполнение поля "Комментарий"
    public OrderPage fillComment(String text){
        driver.findElement(commentInput).sendKeys(text);
        return this;
    }

    // Нажатие на кнопку "Да"
    public OrderPage yesButtonClick(){
        driver.findElement(yesButton).click();
        return this;
    }

    // Получение текста статуса заказа
    public String orderProcessed(){
        String orderText = driver.findElement(orderProcessed).getText();
        String[] lines = orderText.split("\n");
        return lines[0];
    }
}
