package ru.onvenientSoftware.services;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class DocServicesImpl implements DocServices {

    @Override
    public Integer getMaxNumberByDoc(String path, Integer count) {
        File file = getFileIfExist(path);
        if (file != null) return getMaxNumberByNum(file, count);
        return null;
    }

    private File getFileIfExist(String path) {
        File file = new File(path);
        if (file.exists() && !file.isDirectory()) {
            return file;
        }
        return null;
    }

    private Integer getMaxNumberByNum(File file, Integer counter) {
        int max = 0;
        try (FileInputStream fileInputStream = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {
            Sheet sheet = workbook.getSheetAt(0);

            int i = 0;

            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            break;
                        case NUMERIC:
                            max = Integer.max(max, (int)cell.getNumericCellValue());
                            break;
                        case BOOLEAN:
                            break;
                        case FORMULA:
                            break;
                        default:
                            break;
                    }
                }
                i++;
                if (counter == i){
                    return max;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return max;
    }
}
