package lk.ijse.meatShop.model;

import lk.ijse.meatShop.to.*;
import lk.ijse.meatShop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BuyToStoreModel {
    //last id
    public static ResultSet getLastId() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT buy_id FROM buy ORDER BY buy_id  DESC LIMIT 1");
    }
    //nic
    public static ResultSet getSupId() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT sup_id FROM supplier ");
    }
    //itemcode
    public static ResultSet getItemcode() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT code FROM stocks ");
    }
    public static Supplier getSupDesc(String id) throws SQLException, ClassNotFoundException {
        String sql=("SELECT * FROM supplier where sup_id=? || tel_no=?  ");
        ResultSet result = CrudUtil.execute(sql, id,id);

        if (result.next()) {
            return new Supplier(

                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5)
            );
        }
        return null;


    }
    //name
    public static Stocks getItemDesc(String code) throws SQLException, ClassNotFoundException {
        String sql =("SELECT * FROM stocks where code=? ");
        ResultSet result = CrudUtil.execute(sql,code);

        if (result.next()) {
            return new Stocks(

                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4)
            );
        }
        return null;

    }
    //------------------------------------for place buy trns.......

    public static boolean SaveBuyadd(BuyStoks order) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO buy VALUES(?, ?, ?)";
        return CrudUtil.execute(sql, order.getBuy_id(), order.getDate(), order.getSup_id());
    }

    public static boolean saveBuyDetails(ArrayList<CartDetail> cartDetails) throws SQLException, ClassNotFoundException {

        for (CartDetail cartDetail : cartDetails) {
            if (!Save(cartDetail)) {
                return false;
            }
        }
        return true;
    }
    private static boolean Save(CartDetail cartDetail) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO buy_detail VALUES(?, ?, ?, ?)";
        return CrudUtil.execute(sql, cartDetail.getOrderId(), cartDetail.getItemcode(), cartDetail.getQty(),
                cartDetail.getUnitPrice());
    }

    public static boolean SavePaymentadd(BuyStoks order) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO buyer_payment VALUES(?, ?, ?, ?, ?)";
        return CrudUtil.execute(sql, order.getBuy_id(), order.getDate(), order.getTot(),order.getAdvance(),
                order.getTopayvalue());
    }


    public static boolean UpdateQty(ArrayList<CartDetail> stocks) throws SQLException, ClassNotFoundException {

        for (CartDetail cartDetail : stocks) {
            if (!update(cartDetail)) {
                return false;
            }

        }
        return true;

    }

    private static boolean update(CartDetail cartDetail) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE stocks SET qty_onHand = qty_onHand + ? WHERE code = ?";
        return CrudUtil.execute(sql, cartDetail.getQty(), cartDetail.getItemcode());

    }



}
