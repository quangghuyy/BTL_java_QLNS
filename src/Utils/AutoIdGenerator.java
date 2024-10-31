/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Model.PhieuNhap;
import Model.PhieuXuat;
import Model.Sach;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Lo Dai Luc
 */
public class AutoIdGenerator {

    private static int counterMaSach = 0;
    private static int counterMaPhieuNhap = 0;
     private static int counterMaPhieuXuat = 0;

    // Phương thức để tạo mã sách tự động
    public static String generateMaSach() {
        counterMaSach++;
        return "MS" + String.format("%03d", counterMaSach); // Tạo mã sách dạng S001, S002, ...
    }

    public static void initializeCounterMaSach(List<Sach> listSach) {
        int maxMaSach = 0;
        for (Sach sach : listSach) {
            String maSach = sach.getMaSach();
            if (maSach.matches("MS\\d{3}")) {
                int currentMaSach = Integer.parseInt(maSach.substring(2));
                if (currentMaSach > maxMaSach) {
                    maxMaSach = currentMaSach;
                }
            }
        }
        counterMaSach = maxMaSach;
    }
    
    // Tạo mã phiếu nhập tự động
    public static String generateMaPhieuNhap() {
        counterMaPhieuNhap++;
        return "PN" + String.format("%03d", counterMaPhieuNhap); 
    }
     public static void initializeCounterMaPhieuNhap(List<PhieuNhap> listPhieuNhap) {
        int maxPhieuNhap = 0;
        for (PhieuNhap pN : listPhieuNhap) {
            String Phieu = pN.getMaPhieu();
            if (Phieu.matches("PN\\d{3}")) {
                int currentMaPhieuNhap = Integer.parseInt(Phieu.substring(2));
                if (currentMaPhieuNhap > maxPhieuNhap) {
                    maxPhieuNhap = currentMaPhieuNhap;
                }
            }
        }
        counterMaPhieuNhap = maxPhieuNhap;
    }
     // Tạo mã phiếu xuất tự động
    public static String generateMaPhieuXuat() {
        counterMaPhieuXuat++;
        return "PX" + String.format("%03d", counterMaPhieuXuat); 
    }
     public static void initializeCounterMaPhieuXuat(List<PhieuXuat> listPhieuXuat) {
        int maxPhieuXuat = 0;
        for (PhieuXuat pN : listPhieuXuat) {
            String Phieu = pN.getMaPhieu();
            if (Phieu.matches("PX\\d{3}")) {
                int currentMaPhieuXuat = Integer.parseInt(Phieu.substring(2));
                if (currentMaPhieuXuat > maxPhieuXuat) {
                    maxPhieuXuat = currentMaPhieuXuat;
                }
            }
        }
        counterMaPhieuXuat = maxPhieuXuat;
    }
}
