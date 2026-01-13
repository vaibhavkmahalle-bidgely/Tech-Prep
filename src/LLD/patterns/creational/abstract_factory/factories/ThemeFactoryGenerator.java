package LLD.patterns.creational.abstract_factory.factories;

public class UIFactory {
    public static ThemeFactory getThemeFactory(String theme) {
        if (theme.equalsIgnoreCase("Light")){
            return new LightThemeFactory();
        } else if (theme.equalsIgnoreCase("Dark")) {
            return new DarkThemeFactory();
        } else {
            throw new IllegalArgumentException("Unknown Theme");
        }
    }
}
