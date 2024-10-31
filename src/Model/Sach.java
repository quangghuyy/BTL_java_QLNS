/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Lo Dai Luc
 */
public class Sach implements Serializable{

    private String maSach;
    private String tenSach;
    private String theLoai;
    private String tacGia;
    private double gia;
    private int soLuong;

    public Sach() {
    }

    public Sach(String maSach, String tenSach, String theLoai, String tacGia, double gia) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.tacGia = tacGia;
        this.gia = gia;
    }

    public Sach(String maSach, String tenSach, String theLoai, String tacGia, double gia, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.tacGia = tacGia;
        this.gia = gia;
        this.soLuong = soLuong;
    }
    
    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public double getGia() {
        return gia;
    }

    public String getFormattedGia() {
         return formatgia(gia);
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
     public boolean isTenSachDuyNhat(List<Sach> danhSachSach) {
        for (Sach sach : danhSachSach) {
            if (sach != this && sach.getTenSach().equalsIgnoreCase(this.tenSach)) {
                return false; 
            }
        }
        return true; 
    }
    public static String formatgia(double number) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');

        DecimalFormat df;
        df = new DecimalFormat("###0.##", symbols);
        
        return df.format(number);
    }
}
