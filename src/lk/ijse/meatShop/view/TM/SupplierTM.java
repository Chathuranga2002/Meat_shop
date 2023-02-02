package lk.ijse.meatShop.view.TM;

public class SupplierTM {
    private String sup_id;
    private String name;
    private String address;
    private String nic;
    private String tel_no;

    public SupplierTM() {
    }

    @Override
    public String toString() {
        return "SupplierTM{" +
                "sup_id='" + sup_id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", nic='" + nic + '\'' +
                ", tel_no='" + tel_no + '\'' +
                '}';
    }

    public SupplierTM(String sup_id, String name, String address, String nic, String tel_no) {
        this.sup_id = sup_id;
        this.name = name;
        this.address = address;
        this.nic = nic;
        this.tel_no = tel_no;
    }

    public String getSup_id() {
        return sup_id;
    }

    public void setSup_id(String sup_id) {
        this.sup_id = sup_id;
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

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getTel_no() {
        return tel_no;
    }

    public void setTel_no(String tel_no) {
        this.tel_no = tel_no;
    }
}
