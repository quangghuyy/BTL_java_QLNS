/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Tran Nhat Sinh
 */
public class PhieuNhap extends Phieu implements Serializable{

    private String nhaCungCap;

    public PhieuNhap() {
    }

    public PhieuNhap(String nhaCungCap, String maPhieu, String thoiGianTao, ArrayList<ChiTietPhieu> CTPhieu, double tongThanhToan) {
        super(maPhieu, thoiGianTao, CTPhieu, tongThanhToan);
        this.nhaCungCap = nhaCungCap;
    }  
    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }
    public static boolean isMaPhieuDuyNhat(String maPhieu, List<PhieuNhap> danhSachPhieu) {
        for (Phieu phieu : danhSachPhieu) {
            if (phieu.getMaPhieu().equalsIgnoreCase(maPhieu)) {
                return false; 
            }
        }
        return true;
    }
}
