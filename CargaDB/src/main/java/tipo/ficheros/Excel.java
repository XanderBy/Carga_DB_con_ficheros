package tipo.ficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public static String[][] ObtenerDatosExcel(File excelFile) {
		InputStream excelStream = null;
		String[][] datosExcel = null;
		try {
			excelStream = new FileInputStream(excelFile);

			// Workbook hssfWorkbook = WorkbookFactory.create(excelStream);
			XSSFWorkbook excel;
			excel = (XSSFWorkbook) WorkbookFactory.create(excelStream);

			Sheet hoja = excel.getSheetAt(0);
			Row fila;
			Cell celda;

			int numeroFilas = hoja.getLastRowNum();
			int numeroColumnas = (numeroFilas > 0) ? hoja.getRow(0).getPhysicalNumberOfCells() : 0;
			System.out.println(numeroColumnas);
			datosExcel = new String[numeroColumnas][numeroFilas];

			String cellValue = new String();

			for (int x = 0; x < numeroColumnas; x++) {
				for (int y = 0; y < numeroFilas; y++) {
					fila = hoja.getRow(y);
					
					switch (fila.getCell(x).getCellType()) {
			        case BOOLEAN:
			        	cellValue=""+fila.getCell(x).getBooleanCellValue();
			            break;
			        case NUMERIC:
			        	cellValue=""+fila.getCell(x).getNumericCellValue();
			            break;
			        case STRING:
			        	cellValue=fila.getCell(x).getStringCellValue();
			            break;
			        case BLANK:
			            break;
			        case ERROR:
			            break;

			    }
					
					/*
					cellValue = fila.getCell(x) == null ? ""
							: (fila.getCell(x).getCellType() == CellType.STRING) ? fila.getCell(x).getStringCellValue()
									: (fila.getCell(x).getCellType() == CellType.NUMERIC)
											? "" + fila.getCell(x).getNumericCellValue()
											: (fila.getCell(y).getCellType() == CellType.BOOLEAN)
													? "" + fila.getCell(x).getBooleanCellValue()
													: (fila.getCell(x).getCellType() == CellType.BLANK) ? "BLANK"
															: (fila.getCell(x).getCellType() == CellType.FORMULA)
																	? "FORMULA"
																	: (fila.getCell(x).getCellType() == CellType.ERROR)
																			? "ERROR"
																			: "";
																			*/
					
					System.out.print("[Column " + y + ": " + cellValue + "] ");
					datosExcel[x][y]=cellValue;

				}

			}

		} catch (FileNotFoundException fileNotFoundException) {
			System.out.println("The file not exists (No se encontr� el fichero): " + fileNotFoundException);
		} catch (IOException ex) {
			System.out.println("Error in file procesing (Error al procesar el fichero): " + ex);
		} finally {
			try {
				excelStream.close();
			} catch (IOException ex) {
				System.out.println(
						"Error in file processing after close it (Error al procesar el fichero despu�s de cerrarlo): "
								+ ex);
			}
		}
		return datosExcel;
	}

}
