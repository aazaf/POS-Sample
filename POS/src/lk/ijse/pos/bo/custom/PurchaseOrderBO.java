package lk.ijse.pos.bo.custom;

import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.dto.OrdersDTO;

public interface PurchaseOrderBO extends SuperBO {

    boolean purchaseOrder(OrdersDTO order) throws Exception;

}
