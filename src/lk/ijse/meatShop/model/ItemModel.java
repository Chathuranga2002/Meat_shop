package lk.ijse.meatShop.model;

import lk.ijse.meatShop.db.DBConnection;
import lk.ijse.meatShop.to.Employee;
import lk.ijse.meatShop.to.Item;
import lk.ijse.meatShop.to.Stocks;
import lk.ijse.meatShop.util.CrudUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemModel {

    public static boolean saveStoks (Stocks stocks) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO stocks VALUES (?, ?, ?, ?)";
        return CrudUtil.execute(sql,stocks.getItemcode(),stocks.getCategory(),stocks.getDescription(),
                stocks.getQtyonHand());

    }
    public static boolean saveItem (Item item) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO item VALUES (?, ?, ?, ?, ?)";
        return CrudUtil.execute(sql,item.getItemcode(),item.getCategory(),item.getDescription(),item.getUnitPrice(),
                item.getQtyonHand());
    }

    public static ResultSet getLastId() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT code FROM stocks ORDER BY code  DESC LIMIT 1");
    }

    public static ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM stocks");
    }
    public static ResultSet getAllItem() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM item");
    }

}
