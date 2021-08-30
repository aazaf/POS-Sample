package lk.ijse.pos.dao.impl;

import lk.ijse.pos.dao.CustomerDAO;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

    Connection connection = DBConnection.getInstance().getConnection();

    public CustomerDAOImpl() throws Exception {}

    @Override
    public boolean saveCustomer(Customer customer) throws Exception {

//        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer VALUES (?,?,?,?)");

        pstm.setObject(1, customer.getcID());
        pstm.setObject(2, customer.getName());
        pstm.setObject(3, customer.getAddress());
        pstm.setObject(4, 0);
        return (pstm.executeUpdate()) > 0;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws Exception {

//        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE cid=?");
        pstm.setObject(1, customer.getName());
        pstm.setObject(2, customer.getAddress());
        pstm.setObject(3, customer.getcID());
        return (pstm.executeUpdate()) > 0;

    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {

//        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE cid=?");
        pstm.setObject(1, id);
        return (pstm.executeUpdate()) > 0;
    }

    @Override
    public Customer searchCustomer(String id) throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer where cid=?");
        pstm.setObject(1, id);
        ResultSet rst = pstm.executeQuery();
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

//        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");
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