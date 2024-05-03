package way11.project.Utils;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import way11.project.Entities.Profile;
import way11.project.Entities.ProfileAnswer;

import java.io.IOException;
import java.util.List;

public class ExcelExportUtils {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Profile> profile;

    public ExcelExportUtils(List<Profile> profile) {
        this.profile = profile;
        workbook = new XSSFWorkbook();
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style){ // Метод создания ячейки
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer){
            cell.setCellValue((Integer) value);
        }else if (value instanceof Double){
            cell.setCellValue((Double) value);
        }else if (value instanceof Boolean){
            cell.setCellValue((Boolean) value);
        }else if (value instanceof Long){
            cell.setCellValue((Long) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void createHeaderRow(){ // Метод создания главной строки

        sheet   = workbook.createSheet("Результат тестирования");
        Row row = sheet.createRow(0);

        // ----- Стиль для текста

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(20);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);

        // -----
        createCell(row, 0, "Профиль", style);
        // Говорим что "Результат тестирований" будет размещен на 3 ячейки
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 2));
        createCell(row, 3, "Результат тестирования", style);
        // Говорим что "Результат тестирований" будет размещен с 3 до 16 ячеек
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 3, 16));
        // устанавливаем высоту текста
        font.setFontHeightInPoints((short) 10);

        row = sheet.createRow(1);
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "Возраст", style);
        createCell(row, 1, "Вес", style);
        createCell(row, 2, "Рост", style);
        createCell(row, 3, "1", style);
        createCell(row, 4, "2", style);
        createCell(row, 5, "3", style);
        createCell(row, 6, "4", style);
        createCell(row, 7, "5", style);
        createCell(row, 8, "6", style);
        createCell(row, 9, "7", style);
        createCell(row, 10, "8", style);
        createCell(row, 11, "9", style);
        createCell(row, 12, "10", style);
        createCell(row, 13, "11", style);
        createCell(row, 14, "12", style);
        createCell(row, 15, "13", style);
        createCell(row, 16, "14", style);
    }

    private void writeCustomerData(){
        int rowCount = 2;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setFont(font);

        for (Profile element : profile){
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, element.getAge() ,style);
            createCell(row, columnCount++, element.getWeight(), style);
            createCell(row, columnCount++, element.getHeight(), style);
            for (ProfileAnswer answer : element.getAnswers()){
                createCell(row, columnCount++, answer.getAnswer().getAnswer(), style);
            }
        }

    }

    public void exportDataToExcel(HttpServletResponse response) throws IOException {
        createHeaderRow();
        writeCustomerData();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

}
