/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lo Dai Luc
 */
public class PhieuXuat extends Phieu implements Serializable{

    public PhieuXuat() {
    }

    public PhieuXuat(String maPhieu, String thoiGianTao, ArrayList<ChiTietPhieu> CTPhieu, double tongThanhToan) {
        super(maPhieu, thoiGianTao, CTPhieu, tongThanhToan);
    }
    public static boolean isMaPhieuDuyNhat(String maPhieu, List<PhieuXuat> danhSachPhieu) {
        for (Phieu phieu : danhSachPhieu) {
            if (phieu.getMaPhieu().equalsIgnoreCase(maPhieu)) {
                return false; 
            }
        }
        return true;
    }
}
