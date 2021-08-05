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
		String[][] datosExcel;
		try {
			excelStream = new FileInputStream(excelFile);

			// Workbook hssfWorkbook = WorkbookFactory.create(excelStream);
			XSSFWorkbook excel;
			excel = (XSSFWorkbook) WorkbookFactory.create(excelStream);

			Sheet hoja = excel.getSheetAt(0);
			Row fila;
			Cell celda;

			int numeroFilas = hoja.getLastRowNum();
			int numeroColumnas = (numeroFilas>0) ? hoja.getRow(0).getPhysicalNumberOfCells() : 0;
			
			datosExcel= new String[numeroColumnas][numeroFilas];
			
			String cellValue;
			
			for (int x = 0; x < numeroColumnas; x++) {
				for (int y = 0; y < numeroFilas; y++) {
					cellValue = fila.getCell(y) == null ? ""
							: (fila.getCell(y).getCellType() == CellType.STRING)
									? fila.getCell(y).getStringCellValue()
									: (fila.getCell(y).getCellType() == CellType.NUMERIC)
											? "" + fila.getCell(y).getNumericCellValue()
											: (fila.getCell(y).getCellType() == CellType.BOOLEAN)
													? "" + fila.getCell(y).getBooleanCellValue()
													: (fila.getCell(y).getCellType() == CellType.BLANK) ? "BLANK"
															: (fila.getCell(y).getCellType() == CellType.FORMULA)
																	? "FORMULA"
																	: (fila.getCell(y)
																			.getCellType() == CellType.ERROR)
																					? "ERROR"
																					: "";
					System.out.print("[Column " + c + ": " + cellValue + "] ");
					
				}
				
			}
			

			for (int r = 0; r < numeroFilas; r++) {
				fila = hoja.getRow(r);
				if (fila == null) {
					break;
				} else {
					System.out.print("Row: " + r + " -> ");
					for (int c = 0; c < (numeroColumnas = fila.getLastCellNum()); c++) {

						cellValue = fila.getCell(c) == null ? ""
								: (fila.getCell(c).getCellType() == CellType.STRING)
										? fila.getCell(c).getStringCellValue()
										: (fila.getCell(c).getCellType() == CellType.NUMERIC)
												? "" + fila.getCell(c).getNumericCellValue()
												: (fila.getCell(c).getCellType() == CellType.BOOLEAN)
														? "" + fila.getCell(c).getBooleanCellValue()
														: (fila.getCell(c).getCellType() == CellType.BLANK) ? "BLANK"
																: (fila.getCell(c).getCellType() == CellType.FORMULA)
																		? "FORMULA"
																		: (fila.getCell(c)
																				.getCellType() == CellType.ERROR)
																						? "ERROR"
																						: "";
						System.out.print("[Column " + c + ": " + cellValue + "] ");
					}
					System.out.println();
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
	}

}
