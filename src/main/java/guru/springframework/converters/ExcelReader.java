//package guru.springframework.converters;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.tomcat.util.http.fileupload.FileUtils;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.io.*;
//import java.nio.ByteBuffer;
//import java.nio.MappedByteBuffer;
//import java.nio.channels.FileChannel;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
///**
// * Created by ganta on 05-Jun-18.
// */
//public class ExcelReader {
//
//    public static void main(String[] args) {
//        try {
//            FileInputStream file = new FileInputStream(new File("D:\\workspace\\TMRnD\\csv_files\\csv_files\\team.csv"));
//
//            //Create Workbook instance holding reference to .xlsx file
//            XSSFWorkbook workbook = new XSSFWorkbook(file);
//
//            //Get first/desired sheet from the workbook
//            XSSFSheet sheet = workbook.getSheetAt(0);
//
//            //Iterate through each rows one by one
//            Iterator<Row> rowIterator = sheet.iterator();
//            while (rowIterator.hasNext()) {
//                Row row = rowIterator.next();
//                //For each row, iterate through all the columns
//                Iterator<Cell> cellIterator = row.cellIterator();
//
//                while (cellIterator.hasNext()) {
//                    Cell cell = cellIterator.next();
//                    //Check the cell type and format accordingly
//                    switch (cell.getCellType()) {
//                        case Cell.CELL_TYPE_NUMERIC:
//                            System.out.print(cell.getNumericCellValue() + "t");
//                            break;
//                        case Cell.CELL_TYPE_STRING:
//                            System.out.print(cell.getStringCellValue() + "t");
//                            break;
//                    }
//                }
//                System.out.println("");
//            }
//            file.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//
//    @Transactional
//    public void extractExcelData() {
//        int successCount = 0;
//        int errorCount = 0;
//        FileChannel ch = null;
//
//        try {
//            FileInputStream file = new FileInputStream(new File("D:\\workspace\\TMRnD\\csv_files\\csv_files\\team.csv"));
//            ch = file.getChannel();
//            int size = (int) ch.size();
//            MappedByteBuffer buf = ch.map(FileChannel.MapMode.READ_ONLY, 0, size);
//            byte[] bytes = new byte[size];
//           ByteBuffer bb= buf.get(bytes);
//
//            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream();
//            Workbook workbook = new XSSFWorkbook(byteArrayInputStream);
//            Sheet datatypeSheet = workbook.getSheetAt(1);
//            Iterator<Row> iterator = datatypeSheet.iterator();
//
//            while (iterator.hasNext()) {
//                Row currentRow = iterator.next();
//                if (currentRow.getRowNum() > 2) {
//                    successCount++;
//                }
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//    }
