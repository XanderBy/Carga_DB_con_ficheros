package tipo.ficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Excel {

	public void ObtenerDatosExcel() {

		File f = new File("PATH/FICHERO.xlsx");
		InputStream inp = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(inp);
		sheet = wb.getSheetAt(0);
		Row row = sh.getRow(iRow); // En qué fila empezar ya dependerá también de si tenemos, por ejemplo, el
									// título de cada columna en la primera fila
		while (row != null) {
			Cell cell = row.getCell(1);
			String value = cell.getStringCellValue();
			System.out.println("Valor de la celda es " + value);
			iRow++;
			row = sh.getRow(iRow);
		}
	}

}
