package lk.ijse.pos.dao.impl;

import lk.ijse.pos.dao.CrudUtils;
import lk.ijse.pos.dao.OrderDAO;
import lk.ijse.pos.model.Orders;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {

    public boolean placeOrder(Orders orders) throws Exception {
        return CrudUtils.executeUpdate("INSERT INTO Orders VALUES (?,?,?)",orders.getId(),orders.getDate(),orders.getCustomerId());
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
