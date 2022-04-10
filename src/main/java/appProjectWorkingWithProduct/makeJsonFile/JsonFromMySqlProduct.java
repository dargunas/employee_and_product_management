package appProjectWorkingWithProduct.makeJsonFile;

import appProjectWorkingWithProduct.repository.ProductRepository;
import appProjectWorkingWithProduct.sqlClasses.Product;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class JsonFromMySqlProduct {

    public void getDataFromDatabaseToJsonFileProduct() {

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        ProductRepository productRepository = new ProductRepository();
        List<Product> allProducts = productRepository.findAllProducts();
        for (Product product : allProducts) {
            JSONObject productRecord = new JSONObject();
            productRecord.put("productId", product.getProductId());
            productRecord.put("givenHoursForProduction", product.getGivenHoursForProduction());
            productRecord.put("hoursLeftForProduction", product.getHoursLeftForProduction());
            productRecord.put("hoursUsedForProduction", product.getHoursUsedForProduction());
            productRecord.put("priceOfProduct", product.getPriceOfProduct());
            productRecord.put("productionEndDate", product.getProductionEndDate());
            productRecord.put("productionStartDate", product.getProductionStartDate());
            productRecord.put("isReady", product.getIsReady());
            productRecord.put("assignedEmployees", product.getEmployees());
            jsonArray.add(productRecord);
        }
        jsonObject.put("Products", jsonArray);
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/product.json");
            fileWriter.write(jsonObject.toJSONString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

