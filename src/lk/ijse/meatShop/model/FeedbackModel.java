package lk.ijse.meatShop.model;

import lk.ijse.meatShop.to.Customer;
import lk.ijse.meatShop.to.Feedback;
import lk.ijse.meatShop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FeedbackModel {
    public static boolean save(Feedback feedback) throws  SQLException, ClassNotFoundException {

        String sql = "INSERT INTO feedback VALUES (?, ?, ?)";
        return CrudUtil.execute(sql,feedback.getCus_id(),feedback.getComment(),feedback.getRate());
    }



    public static Feedback search(String id) throws SQLException, ClassNotFoundException {

        String sql = "SELECT  * FROM feedback WHERE cus_id = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()) {
            return new Feedback(
                    result.getString(1),
                    result.getString(2),
                    result.getInt(3)


            );
        }
        return null;
    }


    public static boolean Update(Feedback feedback) throws ClassNotFoundException, SQLException {

        String sql ="Update feedback set  comment=?, rete=? where cus_id=?";
        return CrudUtil.execute(sql,feedback.getComment(),feedback.getRate(),feedback.getCus_id());
    }
    public static ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM feedback");
    }

}
