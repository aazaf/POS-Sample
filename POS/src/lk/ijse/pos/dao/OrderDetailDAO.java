package lk.ijse.pos.dao;

import lk.ijse.pos.model.OrderDetails;

public interface OrderDetailDAO {

    boolean addOrderDetail(OrderDetails orderDetails) throws Exception;
}
