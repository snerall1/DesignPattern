package ptbs;

import domain.Trading;
import domain.Product;
import domain.NodeVisitor;
import domain.Person;
import domain.Buyer;
import domain.VisitableItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Date;


public class Facade implements VisitableItem {

    private Integer userType = null;
    private Product selectedProduct = null;
    private Integer theSelectedProduct = null;
    private ProductList productList = new ProductList();
    private Person currentUser = null;
    private DataManager dataManager = null;

    Scanner sc= new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Facade() {
        dataManager = new DataManager();
        createProductList();
    }


    ProductList getProducts() {
        return productList;
    }

    public  void login(String name, String password) throws Exception {
        System.out.println("Facade Pattern Implementation");
        System.out.println("Login implementation using the Facade pattern");

        try{
            if(dataManager.fetchPassword(name).equals(password))    //validating user
            {
                currentUser = createUser(name);
                attachProductToUser(currentUser);
                this.selectedProduct = selectProduct();
                this.theSelectedProduct = selectProductLevel();
                this.displayMenu();
            } else {
                System.out.println("Incorrect userName or password");
                System.exit(1);
            }
        } catch(Exception ex) {
            System.out.println("Incorrect User Name or Password");
            System.exit(1);
        }

    }

    void addTrading(Product product, Trading trading) {

    }

    void gradeOffering(Offering offering) {

    }

    void submitOffering(Offering offering) {

    }

    void reportOffering(Offering offering) {

    }

    void displayMenu() {
        System.out.println("Select your choice");
        System.out.println("1. Create product menu");
        System.out.println("2. Show product menu");
        System.out.println("3. Remind");
        System.out.println("4. Done");

        try {
            int selectionIndex = Integer.parseInt(br.readLine());
            switch(selectionIndex) {
                case 1: {
                    productOperation();
                    displayMenu();
                    break;
                }
                case 2: {
                    showProductMenuCreated(); break;
                }
                case 3: {
                    remind(); break;
                }
                default : {
                    System.out.println("Exiting...");
                    System.exit(1);
                    break;
                }
            }
            if(selectionIndex!=4) {
                displayMenu();
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    int selectProductLevel() {

        System.out.println("Enter Product type:");
        System.out.println("0 : MeatProductMenu");
        System.out.println("1 : ProduceProductMenu");

        try {
            int selectionIndex = Integer.parseInt(br.readLine());
            return selectionIndex;
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        return 0;
    }

    private Person createUser(String name) throws Exception {
        return dataManager.initializePerson(name);
    }

    private void createProductList() {
    
        try {
            productList = new ProductList(dataManager.initializeAllProducts());
            for (Object product : productList) {
                ((Product) product).addTrading(new Trading(new Date()));
            }
        } catch(Exception ex) {
            ArrayList<Product> productList = new ArrayList<Product>();
            this.productList.addAll(productList);
        }

    }

    void attachProductToUser(Person person) throws Exception {
        person.addProduct(dataManager.fetchProductMappingForUser(person.name));
    }

    Product selectProduct() {

        System.out.println("Iterator pattern implementation");
        System.out.println("Iterating the products using Iterator pattern");

        ProductIterator iterator = (ProductIterator) currentUser.getAddedProducts().iterator();
        int selectionIndex = 0;
        while(iterator.hasNext()) {
            System.out.println(selectionIndex + ": " + iterator.next().id);
            selectionIndex++;
        }
        //Iterating the product menu
        System.out.println("Select the Product");

        try {
            selectionIndex = Integer.parseInt(br.readLine());
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        Product selectedProduct = (Product) currentUser.getAddedProducts().get(selectionIndex);
        return selectedProduct;
    }

    void productOperation() {
        if(currentUser!=null) {
            currentUser.createProductMenu(theSelectedProduct);
    
        }
    }

    void showProductMenuCreated() {
        currentUser.showProductMenu();
    }

    void remind() {
        accept(new RemainderVisitor());
    }

    @Override
    public void accept(NodeVisitor visitor) {
        System.out.println("Visitor pattern implementation");
        visitor.visit(this);
    }
}


class Offering{ }