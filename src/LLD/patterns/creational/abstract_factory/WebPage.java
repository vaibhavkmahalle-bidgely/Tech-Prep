package LLD.patterns.creational.abstract_factory;

public class WebPage {
    public static void main(String[] args) {
        Theme lightTheme = ThemeFactory.getTheme("Dark");
        Button button = lightTheme.createButton();
        CheckBox checkBox = lightTheme.createCheckBox();

        button.render();
        checkBox.render();
    }
}
