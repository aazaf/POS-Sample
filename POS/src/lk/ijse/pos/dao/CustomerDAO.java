package lk.ijse.pos.dao;

import lk.ijse.pos.model.Customer;
import java.util.ArrayList;

public interface CustomerDAO {

    boolean saveCustomer(Customer customer) throws Exception;

    boolean updateCustomer(Customer customer) throws Exception;

    boolean deleteCustomer(String id) throws Exception;

    Customer searchCustomer(String id) throws Exception;

    ArrayList<Customer> getAllCustomers() throws Exception;
}
