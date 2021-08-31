package lk.ijse.pos.bo;

import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dao.impl.ItemDAOImpl;
import lk.ijse.pos.model.Item;
import java.util.ArrayList;

public class ItemBOImpl {

    ItemDAO itemDAO = new ItemDAOImpl();

    public boolean addItem(Item item) throws Exception {
        return itemDAO.add(item);
    }

    public boolean deleteItem(String code) throws Exception {
        return itemDAO.delete(code);
    }

    public boolean updateItem(Item item) throws Exception {
        return itemDAO.update(item);
    }

    public Item searchItem(String code) throws Exception {
        return itemDAO.search(code);
    }

    public ArrayList<Item> getAllItems() throws Exception {
        return itemDAO.getAll();
    }
}
