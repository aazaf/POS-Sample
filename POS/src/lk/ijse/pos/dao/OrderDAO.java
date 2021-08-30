package lk.ijse.pos.dao;

import lk.ijse.pos.model.Orders;

public interface OrderDAO {

    boolean placeOrder(Orders orders) throws Exception;

}
