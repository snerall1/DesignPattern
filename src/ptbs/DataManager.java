package ptbs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import domain.Product;
import domain.Seller;
import domain.Person;
import domain.Buyer;

public class DataManager {

    private static final String FILE_PATH = "C:\\Users\\snerall1\\Documents\\SER_515\\DPRef\\Design-Patterns\\src\\test_files\\";
    public List<Product> initializeAllProducts() throws Exception
    {
        /*Initialize base on Person TYPE */
        return getDataMap("ProductInfo.txt").keySet().stream().map(Product::new).collect(Collectors.toList());
    }

    public String fetchPassword(String userName) throws Exception
    {
        List<String> str =  getDataMap("SellerInfo.txt").get(userName) ;
        if(str == null)
        {
            str = getDataMap("BuyerInfo.txt").get(userName);
        }
        return str.get(0);
    }

    public Person initializePerson(String userName) throws Exception
    {
        /*Initialize base on Person TYPE */
        if(!getDataMap("SellerInfo.txt").containsKey(userName))
        {
            return new Buyer(userName);
        }
        return new Seller(userName);
    }
    public List<Product> fetchProductMappingForUser(String name) throws Exception
    {
        /*Fetch product file base on username*/
        Map<String, List<String>> productMapping =  getDataMap("UserProduct.txt");
        List<String> productList = productMapping.get(name);
        return productList.stream().map(strProduct -> new Product(strProduct)).collect(Collectors.toList());
    }
    private Map<String, List<String>> getDataMap(String fileName) throws Exception
    {
        File file = new File(FILE_PATH+fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        HashMap<String, List<String>> dataMapping = new HashMap<>();
        while((str = br.readLine()) != null)
        {
            String[] token = str.split(":");
            List<String> valueList = new ArrayList<>() ;
            if(token.length==2) {
                if(dataMapping.containsKey(token[0])) {
                    valueList = dataMapping.get(token[0]);
                    valueList.add(token[1]);
                }
                else  valueList.add(token[1]);
            }


            dataMapping.put(token[0], valueList);
        }
        return dataMapping;
    }

}
