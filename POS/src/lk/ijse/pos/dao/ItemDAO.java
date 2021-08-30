package lk.ijse.pos.dao;

import lk.ijse.pos.model.Item;
import java.util.ArrayList;

public interface ItemDAO {

    boolean saveItem(Item item) throws Exception;

    boolean updateItem(Item item) throws Exception;

    boolean deleteItem(String code) throws Exception;

    Item searchItem(String code) throws Exception;

    ArrayList<Item> getAllItems() throws Exception;

    boolean updateItemQtyOnHand(String code,int qtyOnHand) throws Exception;
}