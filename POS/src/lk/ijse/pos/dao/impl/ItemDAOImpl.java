package lk.ijse.pos.dao.impl;

import lk.ijse.pos.dao.CrudUtils;
import lk.ijse.pos.dao.ItemDAO;
import lk.ijse.pos.model.Item;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {

    @Override
    public boolean saveItem(Item item) throws Exception {
        return CrudUtils.executeUpdate("INSERT INTO Item VALUES (?,?,?,?)", item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand());
    }

    @Override
    public boolean updateItem(Item item) throws Exception {
        return CrudUtils.executeUpdate("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?", item.getDescription(), item.getUnitPrice(), item.getQtyOnHand(), item.getCode());
    }

    public boolean updateItemQtyOnHand(String code, int qtyOnHand) throws Exception {
        return CrudUtils.executeUpdate("UPDATE Item SET qtyOnHand=? WHERE code=?", code, qtyOnHand);
    }

    @Override
    public boolean deleteItem(String code) throws Exception {
        return CrudUtils.executeUpdate("DELETE FROM Item WHERE code=?",code);
    }

    @Override
    public Item searchItem(String code) throws Exception {
        ResultSet rst = CrudUtils.executeQuery("SELECT * FROM Item where code=?", code);
        if (rst.next()) {
            return new Item(rst.getString(1),
                    rst.getString(2),
                    rst.getBigDecimal(3),
                    rst.getInt(4));
        }
        return null;
    }

    @Override
    public ArrayList<Item> getAllItems() throws Exception {
        ResultSet rst = CrudUtils.executeQuery("SELECT * FROM Item");
        ArrayList<Item> alItems = new ArrayList<>();

        while (rst.next()) {
            Item item = new Item(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getBigDecimal(3),
                    rst.getInt(4));

            alItems.add(item);
        }
        return alItems;
    }
}
