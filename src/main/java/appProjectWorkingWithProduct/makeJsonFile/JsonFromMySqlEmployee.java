package appProjectWorkingWithProduct.makeJsonFile;

import appProjectWorkingWithProduct.repository.EmployeeRepository;
import appProjectWorkingWithProduct.sqlClasses.Employee;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class JsonFromMySqlEmployee {

    public void getDataFromDatabaseToJsonFileEmployee() {

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        EmployeeRepository employeeRepository = new EmployeeRepository();
        List<Employee> allEmployees = employeeRepository.findAllEmployees();
        for (Employee employee : allEmployees) {
            JSONObject employeeRecord = new JSONObject();
            employeeRecord.put("employeeId", employee.getEmployeeId());
            employeeRecord.put("firstName", employee.getFirstName());
            employeeRecord.put("lastName", employee.getLastName());
            employeeRecord.put("startingDate", employee.getStartingDate());
            employeeRecord.put("workShopName", employee.getWorkShopName());
            employeeRecord.put("assignedProducts", employee.getProducts());
            jsonArray.add(employeeRecord);
        }
        jsonObject.put("Employees", jsonArray);
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/employee.json");
            fileWriter.write(jsonObject.toJSONString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}