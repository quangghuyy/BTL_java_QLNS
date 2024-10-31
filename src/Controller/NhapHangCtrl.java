/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import FileHandler.PhieuNhapFileHandler;
import Model.ChiTietPhieu;
import Model.PhieuNhap;
import Model.PhieuXuat;
import Model.Sach;
import Utils.NumberUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Lo Dai Luc
 */
public class NhapHangCtrl {

    private static final NhapHangCtrl instance = new NhapHangCtrl();

    private NhapHangCtrl() {
    }

    public static NhapHangCtrl getInstance() {
        return instance;
    }

    private static final List<PhieuNhap> listPhieuNhap = new ArrayList<>();

    public static List<PhieuNhap> getList() {
        return listPhieuNhap;
    }

    public static void luuPhieuNhap(PhieuNhap pN) {
        if (!pN.isMaPhieuDuyNhat(pN.getMaPhieu(), listPhieuNhap)) {
            return;
        }

        listPhieuNhap.add(pN);

        for (ChiTietPhieu chiTietPhieu : pN.getCTPhieu()) {
            for (Sach sach : NhapSachCtrl.getList()) {
                if (chiTietPhieu.getMaSach().equalsIgnoreCase(sach.getMaSach())) {
                    int soLuong = sach.getSoLuong() + chiTietPhieu.getSoLuong();
                    sach.setSoLuong(soLuong);
                }
            }
        }
        updateFile();
    }

    public static List<PhieuNhap> timKiemPhieuNhap(String keyword) {
        List<PhieuNhap> searchResult = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();

        for (PhieuNhap pN : listPhieuNhap) {
            if (pN.getMaPhieu().toLowerCase().contains(lowerKeyword)
                    || pN.getNhaCungCap().toLowerCase().contains(lowerKeyword)
                    || pN.getThoiGianTao().toLowerCase().contains(lowerKeyword)) {
                searchResult.add(pN);
            }
        }
        return searchResult;
    }

    public static List<PhieuNhap> locTheoNgay(String fromDateStr, String toDateStr) throws ParseException {
        List<PhieuNhap> searchResult = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date minDate = sdf.parse("1970-01-01");
        Date maxDate = sdf.parse("9999-12-31");

        Date fromDate;
        Date toDate;

        if (!fromDateStr.isEmpty()) {
            fromDate = sdf.parse(fromDateStr);
        } else {
            fromDate = minDate;
        }

        if (!toDateStr.isEmpty()) {
            toDate = sdf.parse(toDateStr);
        } else {
            toDate = maxDate;
        }
        
        LocalDate fromLocalDate = new java.sql.Date(fromDate.getTime()).toLocalDate();
        LocalDate toLocalDate = new java.sql.Date(toDate.getTime()).toLocalDate();

        for (PhieuNhap phieuNhap : listPhieuNhap) {
            Date thoiGianTao = sdf.parse(phieuNhap.getThoiGianTao());
            LocalDate thoiGianTaoLocalDate = new java.sql.Date(thoiGianTao.getTime()).toLocalDate();

            if (!thoiGianTaoLocalDate.isBefore(fromLocalDate) && !thoiGianTaoLocalDate.isAfter(toLocalDate)) {
                searchResult.add(phieuNhap);
            }
        }
        return searchResult;
    }

    public static List<PhieuNhap> locTheoGia(Double fromPrice, Double toPrice) {
        List<PhieuNhap> searchResult = new ArrayList<>();

        if (fromPrice == null) {
            fromPrice = Double.MIN_VALUE;
        }

        if (toPrice == null) {
            toPrice = Double.MAX_VALUE;
        }
        for (PhieuNhap phieuNhap : listPhieuNhap) {
            double tongThanhToan = phieuNhap.getTongThanhToan();
            if (tongThanhToan >= fromPrice && tongThanhToan <= toPrice) {
                searchResult.add(phieuNhap);
            }
        }
        return searchResult;
    }

    public static void updateFile() {
        PhieuNhapFileHandler.getInstance().writeToFile("phieunhap.txt", listPhieuNhap);
    }
}
