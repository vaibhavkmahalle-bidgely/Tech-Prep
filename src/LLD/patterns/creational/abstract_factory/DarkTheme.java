package LLD.patterns.creational.abstract_factory;

public class DarkTheme implements Theme{
    @Override
    public Button createButton() {
        return new DarkThemeButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new DarkThemeCheckBox();
    }
}
