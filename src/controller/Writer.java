package controller;

import java.util.List;

import model.Item;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class Writer {
	private static String path;
	private static String pathToReportPackage;

	public static void imprimir(List<Item> clientes) throws Exception {
		JasperReport report = JasperCompileManager.compileReport("./Blank.jrxml");
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(clientes));
		JasperExportManager.exportReportToPdfFile(print, "./Itens.pdf");
	}

	public static String getPathToReportPackage() { return pathToReportPackage; }
	public static String getPath() { return path;	}
}
