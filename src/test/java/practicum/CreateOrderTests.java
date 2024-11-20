package practicum;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static practicum.Constants.*;
import static practicum.Properties.*;


@RunWith(Parameterized.class)
public class CreateOrderTests {
    private WebDriver driver;
    // Имя
    private String name;
    // Фамилия
    private String surname;
    // Адрес
    private String address;
    // Метро
    private String metroStation;
    // Номер телефона
    private String phone;
    // Период аренды
    private String rentalPeriod;
    // Цвет самоката
    private String color;
    // Комментарий
    private String comment;
    // Позиция кнопки "Заказать"
    private String orderButtonPosition;

    public CreateOrderTests(String name, String surname, String address, String metroStation, String phone, String rentalPeriod, String color, String comment, String orderButtonPosition) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
        this.orderButtonPosition = orderButtonPosition;
    }

    @BeforeClass
    public static void preset(){
        System.setProperty(CHROME_DRIVER_PROPERTY_NAME, CHROME_DRIVER_PATH);
        System.setProperty(GECKO_DRIVER_PROPERTY_NAME, GECKO_DRIVER_PATH);
    }

    @Before
    public void setup() {

        //// Настройки для Chrome
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
//        driver = new ChromeDriver(options);
        //// Настройки для FireFox
        FirefoxOptions oprtions = new FirefoxOptions();
        oprtions.setHeadless(true);
        driver = new FirefoxDriver(oprtions);
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        // Имя, Фамилия, адрес, метро, номер телефона, цвет самоката, комментарий, позиция кнопки "Заказать"
        return new Object[][] {
                {"Саша", "Кипяткова", "ул. Пушкина, д.37", "Комсомольская", "79876543237", "двое суток", "чёрный жемчуг", "09:50", "top"}, //Заказ через верхнюю кнопку, черный цвет самоката
                {"Маша", "Клопова", "ул. Лермонтова, д.13", "Сокольники", "79876543213", "трое суток", "серая безысходность", "Привет", "top"},  //Заказ через нижнюю кнопку, серый цвет самоката
                {"Даша", "Торопова", "ул. Грибоедова, д.7", "Красносельская", "79876543217", "двое суток", "чёрный жемчуг", "09:50", "bottom"}, //Заказ через нижнюю кнопку, черный цвет самоката
                {"Глаша", "Попова", "ул. Тургенева, д.3", "Кропоткинская", "79876543213", "трое суток", "серая безысходность", "Привет", "bottom"}, //Заказ через нижнюю кнопку, серый цвет самоката
                {"Наташа", "Хлопова", "ул. Толстова, д.17", "Фрунзенская", "79876543117", "двое суток", null, "09:50", "top"}, //Заказ через верхнюю кнопку, цвет самоката не выбран
                {"Любаша", "Мохова", "ул. Некрасова, д.31", "Университет", "79876543231", "двое суток", null, "09:50", "bottom"}, //Заказ через нижнюю кнопку, цвет самоката не выбран
        };
    }

    // Проверка создания заказа
    @Test
    public void checkOrderExpectCreated()  {
        MainPage mainPage = new MainPage(driver);
        mainPage.open().clickOnOrderButton(orderButtonPosition);

        OrderPage orderPage = new OrderPage(driver);
        String successOrder = orderPage.fillFieldName(name)
                .fillFieldSurname(surname)
                .fillFieldAddress(address)
                .fillMetroStation(metroStation)
                .fillFieldPhone(phone)
                .nextButtonClick()
                .fillRentDate()
                .fillRentalPeriod(rentalPeriod)
                .setCollor(color)
                .fillComment(comment)
                .orderButtonClick()
                .yesButtonClick()
                .orderProcessed();
        Assert.assertEquals(ORDER_NOT_PROCESSED, ORDER_PROCESSED, successOrder);
    }

    @After
    public void teardown() {driver.quit();} // Закрываем браузер

}
