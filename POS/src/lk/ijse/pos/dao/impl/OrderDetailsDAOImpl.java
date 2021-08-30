package lk.ijse.pos.dao.impl;

import lk.ijse.pos.dao.OrderDetailDAO;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.OrderDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailDAO {

    public boolean addOrderDetail(OrderDetails orderDetails) throws Exception {

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO OrderDetail VALUES (?,?,?,?)");
        pstm.setObject(1, orderDetails.getOrderId());
        pstm.setObject(2, orderDetails.getItemCode());
        pstm.setObject(3, orderDetails.getQty());
        pstm.setObject(4, orderDetails.getUnitPrice());
        return (pstm.executeUpdate()) > 0;

    }

    public boolean updateOrderDetail(OrderDetails orderDetails){
        throw new UnsupportedOperationException("not support");
    }

    public boolean deleteOrderDetail(String id){
        throw new UnsupportedOperationException("not support");
    }

    public OrderDetails searchOrderDetails(String id){
        throw new UnsupportedOperationException("not support");
    }

    public ArrayList<OrderDetails> getAllOrderDetails(){
        throw new UnsupportedOperationException("not support");
    }
}
