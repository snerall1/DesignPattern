package domain;

public class Seller extends Person{
    public Seller(String name) {
        super(name, 1);
    }

    @Override
    public ProductMenu createProductMenu(int productType) {

    }

    @Override
    public void showProductMenu() {
        productMenu.showMenuButtons();
        productMenu.showAddButtons();
        productMenu.showRadioButtons();
        productMenu.showComboBoxes();
        productMenu.showLabel();
    }
}