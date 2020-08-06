package JavaBackend.buoi7.Target;

public class CountingTImes_71_4 {
    String MaNCC;
    String nameSup;
    int dem ;
    public CountingTImes_71_4(){

    }

    public CountingTImes_71_4(String maNCC, String nameSup, int dem) {
        this.MaNCC = maNCC;
        this.nameSup = nameSup;
        this.dem = dem;
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

    public int getDem() {
        return dem;
    }

    public void setDem(int dem) {
        this.dem = dem;
    }
}
