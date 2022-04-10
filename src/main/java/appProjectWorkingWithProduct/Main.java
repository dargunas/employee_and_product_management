package appProjectWorkingWithProduct;


import appProjectWorkingWithProduct.connectionUtils.HibernateUtil;
import appProjectWorkingWithProduct.makeJsonFile.JsonFromMySqlEmployee;
import appProjectWorkingWithProduct.makeJsonFile.JsonFromMySqlProduct;
import org.hibernate.Session;


public class Main {


    public static void main(String[] args) {
//TODO autentification
        UserMenu userMenu = new UserMenu();
        JsonFromMySqlEmployee jsonFromMySqlEmployee = new JsonFromMySqlEmployee();
        JsonFromMySqlProduct jsonFromMySqlProduct = new JsonFromMySqlProduct();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        userMenu.menuForUser();
        jsonFromMySqlEmployee.getDataFromDatabaseToJsonFileEmployee();
        jsonFromMySqlProduct.getDataFromDatabaseToJsonFileProduct();
        session.getTransaction().commit();
    }
}
