package LLD.patterns.creational.abstract_factory;

public class LightThemeButton implements Button{
    @Override
    public void render() {
        System.out.println("Rendering Light Theme Button!");
    }
}
