package fpoly.ph53095.assignment.models;

import java.io.Serializable;

public class nhanvien implements Serializable {
    private String maNV;
    private String hoten;
    private String phongban;

    public nhanvien(String maNV, String hoten, String phongban) {
        this.maNV = maNV;
        this.hoten = hoten;
        this.phongban = phongban;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getPhongban() {
        return phongban;
    }

    public void setPhongban(String phongban) {
        this.phongban = phongban;
    }
}
