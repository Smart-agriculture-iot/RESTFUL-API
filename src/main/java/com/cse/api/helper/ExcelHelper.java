package com.cse.api.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.ProviderException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import com.cse.api.model.Rain;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class ExcelHelper {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    static String SHEET = "rain";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<Rain> excelToProviderRegistry(InputStream is) {
        
        try {
            Workbook workbook = new XSSFWorkbook(is);
            
            Sheet sheet = workbook.getSheet(SHEET);
            
            Iterator<Row> rows = sheet.iterator();
            

            List<Rain> providerRegistries = new ArrayList<Rain>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                
                
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                
                Iterator<Cell> cellsInRow = currentRow.iterator();
                
                Rain rain = new Rain();
                
                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    
                    switch (cellIdx) {
                        case 0:
                            
                          
                            break;
                        case 1:
                        try {
                            rain.setYear(currentCell.getStringCellValue());
                            // System.out.println("year1="+currentCell.getStringCellValue());
                        } catch (Exception e) {
                            System.out.println("year2="+currentCell.getStringCellValue());
                            rain.setYear(String.valueOf(currentCell.getNumericCellValue()));
                        }
                        
                            break;
                        case 2:
                        try {
                            rain.setMonth(currentCell.getStringCellValue()); 
                            System.out.println("month1="+currentCell.getStringCellValue());
                        } catch (Exception e) {
                            // TODO: handle exception
                            System.out.println("month2="+currentCell.getStringCellValue());
                            rain.setMonth(String.valueOf(currentCell.getNumericCellValue()));
                        }
                        
                            break;
                            case 3:
                            try {
                                rain.setRain(currentCell.getStringCellValue());
                                System.out.println("rain1= "+currentCell.getStringCellValue());
                            } catch (Exception e) {
                                // TODO: handle exception
                                System.out.println("rain2="+currentCell.getStringCellValue());
                                rain.setRain(String.valueOf(currentCell.getNumericCellValue()));
                            }
                            
                            break;
                                               
                        default:
                            
                            break;
                    }
                   
                    cellIdx++;
                 }
             
                

                    providerRegistries.add(rain);
                }
            
            
              workbook.close();

            return providerRegistries;
        } catch (IOException e) {
            
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }

}
