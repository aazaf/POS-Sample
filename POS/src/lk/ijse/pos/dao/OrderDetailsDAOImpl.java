package lk.ijse.pos.dao;

import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.OrderDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class OrderDetailsDAOImpl {

    public boolean addOrderDetail(OrderDetails orderDetails) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO OrderDetails VALUES (?,?,?,?)");
        pstm.setObject(1, orderDetails.getOrderId());
        pstm.setObject(2, orderDetails.getItemCode());
        pstm.setObject(3, orderDetails.getQty());
        pstm.setObject(4, orderDetails.getUnitPrice());
        return (pstm.executeUpdate()) > 0;

    }

    public boolean updateOrderDetail(OrderDetails orderDetails){

    }

    public boolean deleteOrderDetail(String id){

    }

    public OrderDetails searchOrderDetails(String id){

    }

    public ArrayList<OrderDetails> getAllOrderDetails(){

    }
}
