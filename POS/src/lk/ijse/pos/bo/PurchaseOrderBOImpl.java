package lk.ijse.pos.bo;

import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dao.custom.OrderDAO;
import lk.ijse.pos.dao.custom.OrderDetailDAO;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.Item;
import lk.ijse.pos.model.OrderDetails;
import lk.ijse.pos.model.Orders;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class PurchaseOrderBOImpl implements PurchaseOrderBO {

    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.ITEM);
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.ORDER);
    OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.ORDERDETAILS);

    @Override
    public boolean purchaseOrder(Orders orders, ArrayList<OrderDetails> orderDetails) throws Exception {

        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            boolean isPlaced = orderDAO.add(orders);

            if (!isPlaced) {
                connection.rollback();
                return false;
            }

            for (OrderDetails orderDetail : orderDetails) {
                boolean isAdded = orderDetailDAO.add(orderDetail);
                if (!isAdded) {
                    connection.rollback();
                    return false;
                }

                int qtyOnHand = 0;

                Item item = itemDAO.search(orderDetail.getItemCode());

                if (item != null) {
                    qtyOnHand = item.getQtyOnHand();
                }

                boolean isUpdated = itemDAO.updateItemQtyOnHand(orderDetail.getItemCode(), qtyOnHand - orderDetail.getQty());

                if (!isUpdated){
                    connection.rollback();
                    return false;
                }
            }

            connection.commit();
            return true;

        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                throw new Exception(ex1);
            }
            throw new Exception(ex);
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                throw new Exception(ex);
            }
        }
    }
}
