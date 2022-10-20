package domain;

public class Buyer extends Person {
    public Buyer(String name) {
        super(name, 0);
    }

    @Override
    public ProductMenu createProductMenu(int productType) {
        System.out.println("Factory Pattern");
        
    }


    @Override
    public void showProductMenu() {
        System.out.println("-------Bridge Pattern---------");

        productMenu.showMenuButtons();
        productMenu.showViewButtons();
        productMenu.showRadioButtons();
        productMenu.showComboBoxes();
        productMenu.showLabel();
    }
}
