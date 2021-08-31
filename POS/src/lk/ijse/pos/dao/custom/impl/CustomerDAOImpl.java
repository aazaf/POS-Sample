package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtils;
import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.entity.Customer;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean add(Customer customer) throws Exception {
        return CrudUtils.executeUpdate("INSERT INTO Customer VALUES (?,?,?,?", customer.getcID(), customer.getName(), customer.getAddress(), 0);
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtils.executeUpdate("DELETE FROM Customer WHERE cid=?", s);
    }

    @Override
    public boolean update(Customer customer) throws Exception {
        return CrudUtils.executeUpdate("UPDATE Customer SET name=?, address=? WHERE cid=?", customer.getName(), customer.getAddress(), customer.getcID());
    }

    @Override
    public Customer search(String s) throws Exception {
        ResultSet rst = CrudUtils.executeQuery("SELECT * FROM Customer where cid=?", s);
        if (rst.next()) {
            return new Customer(
                    rst.getString("cid"),
                    rst.getString("name"),
                    rst.getString("address"));
        }
        return null;
    }

    @Override
    public ArrayList<Customer> getAll() throws Exception {
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
