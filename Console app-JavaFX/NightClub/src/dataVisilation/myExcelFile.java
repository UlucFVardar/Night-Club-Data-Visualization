/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataVisilation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author uluc
 */
public class myExcelFile {
    private Workbook workbook;
    private int sheetSize;
    private ArrayList<String> sheetNames;
    
    public myExcelFile(String file_name) throws IOException, InvalidFormatException{
        workbook = WorkbookFactory.create(new File(file_name));
        sheetSize=workbook.getNumberOfSheets();
        
        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
        sheetNames=new ArrayList<>();
        while (sheetIterator.hasNext()) {
            Sheet sheet = sheetIterator.next();
            sheetNames.add( sheet.getSheetName().toString() );                     
        }   
    }

    public ArrayList<String> getSheetNames() {
        return sheetNames;
    }

    public int getSheetSize() {
        return sheetSize;
    }

  
    public Object get(String location,int index){
        if( index <=sheetSize-1 && index>=0 ){
            Sheet sheet = workbook.getSheetAt(index);
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
            CellReference cellReference = new CellReference( location ); //pass the cell which contains formula
            Row row = sheet.getRow(cellReference.getRow());
            Cell cell = row.getCell(cellReference.getCol());

            CellValue cellValue = evaluator.evaluate(cell);
            Object content;
            //System.out.println(cellValue.toString());
            switch (cell.getCellTypeEnum()) {

            case STRING:
                content=cell.getRichStringCellValue().getString();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    content=cell.getDateCellValue();
                } else {
                    content=cell.getNumericCellValue();
                }
                break;
             default:
                return (double)0.0;

            }
        return content;
        
    }
        else{
        return null;
        }
}
}
