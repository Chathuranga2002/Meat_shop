package lk.ijse.meatShop.view.TM;

public class EmployeTM {
    private String empId;
    private String username;
    private String nic;
    private String name;
    private String address;
    private String rool;
    private String telno;

    @Override
    public String toString() {
        return "EmployeTM{" +
                "empId='" + empId + '\'' +
                ", username='" + username + '\'' +
                ", nic='" + nic + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", rool='" + rool + '\'' +
                ", telno='" + telno + '\'' +
                '}';
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
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

    public String getRool() {
        return rool;
    }

    public void setRool(String rool) {
        this.rool = rool;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public EmployeTM() {
    }

    public EmployeTM(String empId, String username, String nic, String name, String address, String rool, String telno) {
        this.empId = empId;
        this.username = username;
        this.nic = nic;
        this.name = name;
        this.address = address;
        this.rool = rool;
        this.telno = telno;
    }
}
