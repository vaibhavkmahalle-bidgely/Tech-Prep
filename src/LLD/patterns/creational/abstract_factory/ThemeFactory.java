package LLD.patterns.creational.abstract_factory;

public class ThemeFactory {
    public static Theme getTheme(String theme) {
        if (theme.equalsIgnoreCase("Light")){
            return new LightTheme();
        } else if (theme.equalsIgnoreCase("Dark")) {
            return new DarkTheme();
        } else {
            throw new IllegalArgumentException("Unknown Theme");
        }
    }
}
