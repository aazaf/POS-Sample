package lk.ijse.pos.bo;

import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dao.custom.OrderDAO;
import lk.ijse.pos.dao.custom.OrderDetailDAO;
import lk.ijse.pos.dao.impl.CustomerDAOImpl;
import lk.ijse.pos.dao.impl.ItemDAOImpl;
import lk.ijse.pos.dao.impl.OrderDAOImpl;
import lk.ijse.pos.dao.impl.OrderDetailsDAOImpl;
import lk.ijse.pos.model.Orders;
import java.util.ArrayList;

public class PurchaseOrderBOImpl {

    ItemDAO itemDAO = new ItemDAOImpl();
    CustomerDAO customerDAO = new CustomerDAOImpl();
    OrderDAO orderDAO = new OrderDAOImpl();
    OrderDetailDAO orderDetailDAO = new OrderDetailsDAOImpl();

    public boolean purchaseOrder(Orders orders, ArrayList<OrderDetailDAO> orderDetails) throws Exception {
        return orderDAO.add(orders);
    }
}
