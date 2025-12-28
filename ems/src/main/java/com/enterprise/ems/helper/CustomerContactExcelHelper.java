package com.enterprise.ems.helper;

import com.enterprise.ems.entities.CustomerContact;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomerContactExcelHelper {

   // Check that file is of excel type  or not
    public  static  boolean checkExcelFormat(MultipartFile file){
        String contentType = file.getContentType();
        if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")){
            return  true ;
        }else {
            return  false;
        }
    }


   // Convert Excel to list
    public static List<CustomerContact> convertExcelToList(InputStream is){
        List<CustomerContact> list = new ArrayList<>();

        try{
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            //Get sheet name by using this XSSFSheet class
            XSSFSheet sheet = workbook.getSheet("data");
            //Find out sheet row
            int rowNumber = 0;
            //this is collection logic
            Iterator<Row>  iterator = sheet.iterator();

            while (iterator.hasNext()){
                Row row = iterator.next();
                if(rowNumber == 0){
                    rowNumber ++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();
                int cId = 0;

                CustomerContact CC = new CustomerContact();

                while (cells.hasNext()){
                    Cell cell = cells.next();

                    switch (cId){
                        case 0:
                            CC.setName(cell.getStringCellValue());
                            break;
                        case 1:
                            CC.setEmail(cell.getStringCellValue());
                            break;
                        case 2:
                            CC.setPhone(cell.getStringCellValue());
                            break;
                        case 3:
                            CC.setLanguage(cell.getStringCellValue());
                            break;

                            case 4:
                                CC.setAddress(cell.getStringCellValue());
                            break;

                        case 5:
                            CC.setPincode(cell.getStringCellValue());
                            break;

                        default:
                            break;
                    }
                    cId ++;
                }
                list.add(CC);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        return  list;
    }
}
