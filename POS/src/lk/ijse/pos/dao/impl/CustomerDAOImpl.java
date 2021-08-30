package lk.ijse.pos.dao.impl;

import lk.ijse.pos.dao.CrudUtils;
import lk.ijse.pos.dao.CustomerDAO;
import lk.ijse.pos.model.Customer;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean saveCustomer(Customer customer) throws Exception {
        return CrudUtils.executeUpdate("INSERT INTO Customer VALUES (?,?,?,?",customer.getcID(),customer.getName(),customer.getAddress(),0);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws Exception {
       return CrudUtils.executeUpdate("UPDATE Customer SET name=?, address=? WHERE cid=?", customer.getName(), customer.getAddress(), customer.getcID());
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return CrudUtils.executeUpdate("DELETE FROM Customer WHERE cid=?",id);
    }

    @Override
    public Customer searchCustomer(String id) throws Exception {
        ResultSet rst = CrudUtils.executeQuery("SELECT * FROM Customer where cid=?", id);
        if (rst.next()) {
            return new Customer(
                    rst.getString("cid"),
                    rst.getString("name"),
                    rst.getString("address"));
        }
        return null;
    }

    @Override
    public ArrayList<Customer> getAllCustomers() throws Exception {
        ResultSet rst = CrudUtils.executeQuery("SELECT * FROM Customer");
        ArrayList<Customer> allCustomers = new ArrayList<>();
        while (rst.next()) {
            Customer customer = new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3));
            allCustomers.add(customer);
        }
        return allCustomers;
    }
}
