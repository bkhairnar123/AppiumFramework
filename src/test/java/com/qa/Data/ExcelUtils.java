package com.qa.Data;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    private String filePath;
    private Workbook workbook;
    private static final int DEFAULT_SHEET_INDEX = 0; // Default sheet index

    public ExcelUtils(String filePath) throws IOException {
        this.filePath = filePath;
        FileInputStream file = new FileInputStream(new File(filePath));
        this.workbook = new XSSFWorkbook(file);
    }

    public String getCellValue(int rowIndex, int cellIndex) {
        Sheet sheet = workbook.getSheetAt(DEFAULT_SHEET_INDEX);
        Row row = sheet.getRow(rowIndex);
        Cell cell = row.getCell(cellIndex);
        return cell.getStringCellValue();
    }


    }
