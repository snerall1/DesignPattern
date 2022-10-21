package domain;

public class MeatProductMenu implements ProductMenu {
    @Override
    public void showMenuButtons() {
        System.out.println("Show Menu buttons in MeatProductMenu");
    }

    @Override
    public void showAddButtons() {
        System.out.println("Show Add buttons in MeatProductMenu");
    }

    @Override
    public void showViewButtons() {
        System.out.println("Show View buttons in MeatProductMenu");
    }

    @Override
    public void showComboBoxes() {
        System.out.println("Show Comboboxes in MeatProductMenu");
    }

    @Override
    public void showLabel() {
        System.out.println("Show Labels in MeatProductMenu");
    }

    @Override
    public void showRadioButtons() {
        System.out.println("Show Radio buttons in MeatProductMenu");
    }
}
