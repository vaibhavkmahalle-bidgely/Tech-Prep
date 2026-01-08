package LLD.patterns.creational.abstract_factory;

public class DarkThemeButton implements Button{
    @Override
    public void render() {
        System.out.println("Rendering Dark Theme Button");
    }
}
