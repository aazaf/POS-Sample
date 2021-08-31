package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtils;
import lk.ijse.pos.dao.custom.OrderDetailDAO;
import lk.ijse.pos.entity.OrderDetails;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailDAO {
    @Override
    public boolean add(OrderDetails orderDetails) throws Exception {
        return CrudUtils.executeUpdate("INSERT INTO OrderDetail VALUES (?,?,?,?)", orderDetails.getOrderId(), orderDetails.getItemCode(), orderDetails.getQty(), orderDetails.getUnitPrice());
    }

    @Override
    public boolean delete(String s) throws Exception {
        throw new UnsupportedOperationException("not support");
    }

    @Override
    public boolean update(OrderDetails orderDetails) throws Exception {
        throw new UnsupportedOperationException("not support");
    }

    @Override
    public OrderDetails search(String s) throws Exception {
        throw new UnsupportedOperationException("not support");
    }

    @Override
    public ArrayList<OrderDetails> getAll() throws Exception {
        throw new UnsupportedOperationException("not support");
    }
}
