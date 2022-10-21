package domain;

public class Buyer extends Person {
    public Buyer(String name) {
        super(name, 0);
    }

    @Override
    public ProductMenu createProductMenu(int productType) {
        System.out.println("Factory Pattern Implementation");
        if(productType == 0)
            productMenu = new MeatProductMenu() ;
        else
            productMenu = new ProduceProductMenu();
        System.out.println((productType==0?" Meat Product Menu":" Produce Product Menu") + " initialized for Buyer");

        return productMenu;
    }


    @Override
    public void showProductMenu() {
        System.out.println("Implementing Bridge Pattern");

        productMenu.showMenuButtons();
        productMenu.showViewButtons();
        productMenu.showRadioButtons();
        productMenu.showComboBoxes();
        productMenu.showLabel();
    }
}
