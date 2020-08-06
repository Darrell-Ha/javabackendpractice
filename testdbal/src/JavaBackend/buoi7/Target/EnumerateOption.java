package JavaBackend.buoi7.Target;

import java.util.Date;

public class EnumerateOption {
    String MaDKCC;
    String MaNhaCC;
    String TenNhaCC;
    String Diachi;
    String MaSoThue;
    String TenLoaiDV;
    String DơnGia;
    Date NgayBatDau;
    Date NgayKetThuc;
    public EnumerateOption(){

    }

    public EnumerateOption(String maDKCC, String maNhaCC, String tenNhaCC
            , String diachi, String maSoThue, String tenLoaiDV, String dơnGia, Date ngayBatDau, Date ngayKetThuc) {
       this.MaDKCC = maDKCC;
       this.MaNhaCC = maNhaCC;
       this.TenNhaCC = tenNhaCC;
       this.Diachi = diachi;
       this.MaSoThue = maSoThue;
       this.TenLoaiDV = tenLoaiDV;
       this.DơnGia = dơnGia;
       this.NgayBatDau = ngayBatDau;
       this.NgayKetThuc = ngayKetThuc;
    }

    public String getMaDKCC() {
        return MaDKCC;
    }

    public void setMaDKCC(String maDKCC) {
        MaDKCC = maDKCC;
    }

    public String getMaNhaCC() {
        return MaNhaCC;
    }

    public void setMaNhaCC(String maNhaCC) {
        MaNhaCC = maNhaCC;
    }

    public String getTenNhaCC() {
        return TenNhaCC;
    }

    public void setTenNhaCC(String tenNhaCC) {
        TenNhaCC = tenNhaCC;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String diachi) {
        Diachi = diachi;
    }

    public String getMaSoThue() {
        return MaSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        MaSoThue = maSoThue;
    }

    public String getTenLoaiDV() {
        return TenLoaiDV;
    }

    public void setTenLoaiDV(String tenLoaiDV) {
        TenLoaiDV = tenLoaiDV;
    }

    public String getDơnGia() {
        return DơnGia;
    }

    public void setDơnGia(String dơnGia) {
        DơnGia = dơnGia;
    }

    public Date getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        NgayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        NgayKetThuc = ngayKetThuc;
    }

    @Override
    public String toString() {
        return "MaDKCC='" + MaDKCC + '\'' +
                ",   MaNhaCC='" + MaNhaCC + '\'' +
                ",   TenNhaCC='" + TenNhaCC + '\'' +
                ",   Diachi='" + Diachi + '\'' +
                ",   MaSoThue='" + MaSoThue + '\'' +
                ",   TenLoaiDV='" + TenLoaiDV + '\'' +
                ",   DơnGia='" + DơnGia + '\'' +
                ",   NgayBatDau=" + NgayBatDau +
                ",   NgayKetThuc=" + NgayKetThuc;
    }
}
