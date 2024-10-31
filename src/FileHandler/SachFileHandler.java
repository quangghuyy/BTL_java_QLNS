/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileHandler;

import Model.Sach;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Lo Dai Luc
 */
public class SachFileHandler implements FileHandlerInterface {

    private static final SachFileHandler instance = new SachFileHandler();

    private SachFileHandler() {
    }

    public static SachFileHandler getInstance() {
        return instance;
    }

    @Override
    public <T> void writeToFile(String fileName, List<T> data) {
        File file = new File(fileName);
        try {
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(data);
            oos.close();
            fos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public <T> List<T> readDaTaFromFile(String fileName) {
        List<T> list = new ArrayList<>();
        File file = new File(fileName);
        if (file.length() > 0) {
            try {
                file.createNewFile();
                FileInputStream fos = new FileInputStream(file);
                ObjectInputStream oos = new ObjectInputStream(fos);
                Object o = oos.readObject();
                list = (List<T>) o;
                oos.close();
                fos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public void exportPDF(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public <T> void exportExcel(List<T> data) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sach");

        String[] headers = {"STT", "Mã sách", "Tên sách", "Thể loại", "Tác giả", "Giá", "Số lượng"};
        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        int rowNum = 1;
        int stt = 1;

        for (T t : data) {
            Sach sach = (Sach) t;
            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(stt);
            stt++;
            row.createCell(1).setCellValue(sach.getMaSach());
            row.createCell(2).setCellValue(sach.getTenSach());
            row.createCell(3).setCellValue(sach.getTheLoai());
            row.createCell(4).setCellValue(sach.getTacGia());
            row.createCell(5).setCellValue(Utils.NumberUtils.formatCurrency(sach.getGia()));
            row.createCell(6).setCellValue(sach.getSoLuong());
        }

        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        JFileChooser fileChooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel files (*.xlsx)", "xlsx");
        fileChooser.setFileFilter(filter);

        String FileName = "DanhSachSach.xlsx";
        fileChooser.setSelectedFile(new java.io.File(FileName));

        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            String excelFilePath = fileChooser.getSelectedFile().getAbsolutePath();

            if (!excelFilePath.endsWith(".xlsx")) {
                excelFilePath += ".xlsx";
            }
            try (FileOutputStream fos = new FileOutputStream(excelFilePath)) {
                workbook.write(fos);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
