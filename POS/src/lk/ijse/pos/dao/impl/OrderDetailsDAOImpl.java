package lk.ijse.pos.dao.impl;

import lk.ijse.pos.dao.CrudUtils;
import lk.ijse.pos.dao.OrderDetailDAO;
import lk.ijse.pos.model.OrderDetails;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailDAO {

    public boolean addOrderDetail(OrderDetails orderDetails) throws Exception {
        return CrudUtils.executeUpdate("NSERT INTO OrderDetail VALUES (?,?,?,?)",orderDetails.getOrderId(),orderDetails.getItemCode(),orderDetails.getQty(),orderDetails.getUnitPrice());
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
