package LLD.patterns.creational.abstract_factory;

public class LightThemeCheckBox implements CheckBox{

    @Override
    public void render() {
        System.out.println("Rendering Light theme checkbox");
    }
}
