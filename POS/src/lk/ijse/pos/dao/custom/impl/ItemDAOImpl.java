package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtils;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.entity.Item;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {

    @Override
    public boolean add(Item item) throws Exception {
        return CrudUtils.executeUpdate("INSERT INTO Item VALUES (?,?,?,?)", item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand());
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtils.executeUpdate("DELETE FROM Item WHERE code=?", s);
    }

    @Override
    public boolean update(Item item) throws Exception {
        return CrudUtils.executeUpdate("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?", item.getDescription(), item.getUnitPrice(), item.getQtyOnHand(), item.getCode());
    }

    @Override
    public Item search(String s) throws Exception {
        ResultSet rst = CrudUtils.executeQuery("SELECT * FROM Item where code=?", s);
        if (rst.next()) {
            return new Item(rst.getString(1),
                    rst.getString(2),
                    rst.getBigDecimal(3),
                    rst.getInt(4));
        }
        return null;
    }

    @Override
    public ArrayList<Item> getAll() throws Exception {
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

    @Override
    public boolean updateItemQtyOnHand(String code, int qtyOnHand) throws Exception {
        return CrudUtils.executeUpdate("UPDATE Item SET qtyOnHand=? WHERE code=?", qtyOnHand, code);
    }
}

