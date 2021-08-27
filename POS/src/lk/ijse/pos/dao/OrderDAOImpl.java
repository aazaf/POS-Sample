package lk.ijse.pos.dao;

import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.Orders;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class OrderDAOImpl {

    public boolean placeOrder(Orders orders) throws Exception {

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Orders VALUES (?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, orders.getId());
        pstm.setObject(2, orders.getDate());
        pstm.setObject(3, orders.getCustomerId());
        return (pstm.executeUpdate()) > 0;
    }

    public boolean deleteOrder(String id) {
        throw new UnsupportedOperationException("not available this feature.");
    }

    public boolean updateOrder(Orders orders) {
        throw new UnsupportedOperationException("not available this feature.");
    }

    public Orders searchOrder(String id) {
        throw new UnsupportedOperationException("not available this feature.");
    }

    public ArrayList<Orders> getAllOrders() {
        throw new UnsupportedOperationException("not available this feature.");
    }
}