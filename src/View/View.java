/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package View;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lo Dai Luc
 */
public interface View {
    public <T> void showData(List<T> list,DefaultTableModel model);
}
