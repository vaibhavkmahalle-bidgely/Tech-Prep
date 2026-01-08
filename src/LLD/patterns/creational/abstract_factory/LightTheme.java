package LLD.patterns.creational.abstract_factory;

public class LightTheme implements Theme{

    @Override
    public Button createButton() {
        return new LightThemeButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new LightThemeCheckBox();
    }
}
