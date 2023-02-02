package lk.ijse.meatShop.model;

import lk.ijse.meatShop.to.*;
import lk.ijse.meatShop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaceOrderModel {
    public static ResultSet getLastId() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT ord_id FROM orders ORDER BY ord_id  DESC LIMIT 1");
    }

    public static ResultSet getcusId() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT cus_id FROM customer ");
    }
    //itemcode
    public static ResultSet getItemcode() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT item_code FROM item ");
    }


    public static Customer getCusDesc(String id) throws SQLException, ClassNotFoundException {
        String sql=("SELECT * FROM customer where cus_id=? || tel_no=? ");
        ResultSet result = CrudUtil.execute(sql, id,id);

        if (result.next()) {
            return new Customer(

                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)

            );
        }
        return null;


    }
    //name
    public static Item getItemDesc(String code) throws SQLException, ClassNotFoundException {
        String sql =("SELECT * FROM item where item_code=? ");
        ResultSet result = CrudUtil.execute(sql,code);

        if (result.next()) {
            return new Item(

                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getDouble(4),
                    result.getInt(5)
            );
        }
        return null;

    }
    //------------------------------------for place buy trns.......
//1
    public static boolean Saveorderadd(Order order) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO orders VALUES(?, ?, ? ,?)";
        return CrudUtil.execute(sql, order.getOrd_id(), order.getDate(), order.getCus_id(),order.getEmp_id());
    }
//2
    public static boolean saveOderDetails(ArrayList<CartDetail> cartDetails) throws SQLException, ClassNotFoundException {

        for (CartDetail cartDetail : cartDetails) {
            if (!Save(cartDetail)) {
                return false;
            }
        }
        return true;
    }
    private static boolean Save(CartDetail cartDetail) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO order_detail VALUES(?, ?, ?, ?)";
        return CrudUtil.execute(sql, cartDetail.getOrderId(), cartDetail.getItemcode(), cartDetail.getQty(),
                cartDetail.getUnitPrice());
    }

//3
    public static boolean UpdateQty(ArrayList<CartDetail> stocks) throws SQLException, ClassNotFoundException {

        for (CartDetail cartDetail : stocks) {
            if (!update(cartDetail)) {
                return false;
            }

        }
        return true;

    }

    private static boolean update(CartDetail cartDetail) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE item SET qty_onHand = qty_onHand - ? WHERE item_code = ?";
        return CrudUtil.execute(sql, cartDetail.getQty(), cartDetail.getItemcode());

    }






}
