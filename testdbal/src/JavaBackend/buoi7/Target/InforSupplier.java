package JavaBackend.buoi7.Target;

public class InforSupplier {
    String MaNCC;
    String nameSup;
    String address;
    String phonenum;
    String MaSoThue;
    public InforSupplier(){

    }

    public InforSupplier(String maNCC, String nameSup, String address, String phonenum, String maSoThue) {
        this.MaNCC = maNCC;
        this.nameSup = nameSup;
        this.address = address;
        this.phonenum = phonenum;
        this.MaSoThue = maSoThue;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String maNCC) {
        MaNCC = maNCC;
    }

    public String getNameSup() {
        return nameSup;
    }

    public void setNameSup(String nameSup) {
        this.nameSup = nameSup;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getMaSoThue() {
        return MaSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        MaSoThue = maSoThue;
    }

    @Override
    public String toString() {
        return MaNCC+"  "+nameSup+"  "+address+"  "+phonenum+"  "+MaSoThue;
    }
}
