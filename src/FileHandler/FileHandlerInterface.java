package FileHandler;
import java.io.IOException;
import java.util.List;

public interface FileHandlerInterface {
    <T>void writeToFile(String fileName, List<T> data) ;
    
    <T>List<T> readDaTaFromFile(String fileName) ;
    
    void exportPDF(Object obj) ;
    
    <T>void exportExcel(List<T> data) ;
}
