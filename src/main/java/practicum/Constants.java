package practicum;

public class Constants {

    public static final String CHROME_DRIVER_PROPERTY_NAME = "webdriver.chrome.driver";
    public static final String GECKO_DRIVER_PROPERTY_NAME = "webdriver.gecko.driver";

    public static final String SITE_URL = "https://qa-scooter.praktikum-services.ru/";
    public static final String TOP_ORDER_BUTTON_CLASSNAME = "Button_Button__ra12g";
    public static final String ACCORDION_BUTTON_CLASSNAME = "accordion__button";
    public static final String BOTTOM_ORDER_BUTTON_XPATH = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']";
    public static final String CONFIRM_COOCKIE_BUTTON_ID = "rcc-confirm-button";
    public static final String ACCORDION_BUTTON_ATTRIBUTE1_NAME = "aria-controls";
    public static final String ACCORDION_BUTTON_ATTRIBUTE2_NAME = "aria-expanded";
    public static final String TEXT_HIDDEN_ATTRIBUTE_NAME = "hidden";
    public static final String TOP_BUTTON = "top";
    public static final String BOTTOM_BUTTON = "bottom";
    public static final String SCROLL_VIEW_ATTRIBUTE = "arguments[0].scrollIntoView();";

    public static final String NAME_INPUT_XPATH = ".//input[@placeholder='* Имя']";
    public static final String SURNAME_INPUT_XPATH = ".//input[@placeholder='* Фамилия']";
    public static final String ADDRESS_INPUT_XPATH = ".//input[@placeholder='* Адрес: куда привезти заказ']";
    public static final String METRO_STATION_INPUT_XPATH = ".//input[@placeholder='* Станция метро']";
    public static final String PHONE_NUMBER_INPUT_XPATH = ".//input[@placeholder='* Телефон: на него позвонит курьер']";
    public static final String DELIVERY_DATE_INPUT_XPATH = ".//input[@placeholder='* Когда привезти самокат']";
    public static final String RENTAL_PERIOD_DROPDOWN_CLASSNAME = "Dropdown-placeholder";
    public static final String BLACK_COLOR_CHECKBOX_ID = "black";
    public static final String GREY_COLOR_CHECKBOX_ID = "grey";
    public static final String COMMENT_INPUT_XPATH = ".//input[@placeholder='Комментарий для курьера']";
    public static final String BACK_BUTTON_XPATH = ".//button[contains(text(), 'Назад')]";
    public static final String ORDER_BUTTON_XPATH = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']";
    public static final String YES_BUTTON_XPATH = ".//button[contains(text(), 'Да')]";
    public static final String NEXT_BUTTON_XPATH = ".//button[contains(text(), 'Далее')]";
    public static final String ORDER_PROCESSED_XPATH = ".//div[contains(text(), 'Заказ оформлен')]";
    public static final String DATE_PUTTERN = "dd.MM.yyyy";
    public static final String BLACK_COLOR_NAME = "чёрный жемчуг";
    public static final String GREY_COOLOR_NAME = "серая безысходность";
    public static final String XPATH_TEMPLATE = ".//div[text()= '";

    public static final String ORDER_PROCESSED = "Заказ оформлен";
    public static final String ORDER_NOT_PROCESSED = "Заказ не был оформлен";

}
