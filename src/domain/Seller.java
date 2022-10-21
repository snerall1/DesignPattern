package domain;

public class Seller extends Person{
    public Seller(String name) {
        super(name, 1);
    }

    @Override
    public ProductMenu createProductMenu(int productType) {

        if(productType == 0)
            productMenu = new MeatProductMenu() ;
        else
            productMenu = new ProduceProductMenu();
        System.out.println((productType==0?" Meat Product Menu":" Produce Product Menu") + " initialized product menu for Seller");

        return productMenu;
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