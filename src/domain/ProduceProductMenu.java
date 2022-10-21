package domain;

public class ProduceProductMenu implements ProductMenu {
    @Override
    public void showMenuButtons() {
        System.out.println("Show Menu buttons in ProduceProductMenu");
    }

    @Override
    public void showAddButtons() {
        System.out.println("Show Add buttons in ProduceProductMenu");
    }

    @Override
    public void showViewButtons() {
        System.out.println("Show View button in ProduceProductMenu");
    }

    @Override
    public void showComboBoxes() {
        System.out.println("Show Comboboxes in ProduceProductMenu");
    }

    @Override
    public void showLabel() {
        System.out.println("Show Labels in ProduceProductMenu");
    }

    @Override
    public void showRadioButtons() {
        System.out.println("Show Radio buttons in ProduceProductMenu");
    }
}
