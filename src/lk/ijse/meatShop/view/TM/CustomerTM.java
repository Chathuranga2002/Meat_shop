package lk.ijse.meatShop.view.TM;

public class CustomerTM {
    private String cus_id ;
    private String name ;
    private String address ;
    private String tel_no ;

    public CustomerTM(String cus_id, String name, String address, String tel_no) {
        this.cus_id = cus_id;
        this.name = name;
        this.address = address;
        this.tel_no = tel_no;
    }

    public String getCus_id() {
        return cus_id;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel_no() {
        return tel_no;
    }

    public void setTel_no(String tel_no) {
        this.tel_no = tel_no;
    }

    public CustomerTM() {
    }

    @Override
    public String toString() {
        return "CustomerTM{" +
                "cus_id='" + cus_id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tel_no='" + tel_no + '\'' +
                '}';
    }
}
