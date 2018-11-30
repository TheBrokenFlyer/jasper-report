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
//	Exception in thread "main" net.sf.jasperreports.engine.JRException: Error compiling report java source files : C:\Users\Admin\eclipse-workspace\jasper-report\Blank_1543617686793_608407.java 
//		at net.sf.jasperreports.engine.design.JRJavacCompiler.compileClasses(JRJavacCompiler.java:106)
//		at net.sf.jasperreports.engine.design.JRAbstractClassCompiler.compileUnits(JRAbstractClassCompiler.java:77)
//		at net.sf.jasperreports.engine.design.JRAbstractCompiler.compileReport(JRAbstractCompiler.java:201)
//		at net.sf.jasperreports.engine.JasperCompileManager.compile(JasperCompileManager.java:241)
//		at net.sf.jasperreports.engine.JasperCompileManager.compile(JasperCompileManager.java:174)
//		at net.sf.jasperreports.engine.JasperCompileManager.compileReport(JasperCompileManager.java:459)
//		at controller.Writer.imprimir(Writer.java:19)
//		at view.Main.main(Main.java:12)
//	Caused by: java.io.IOException: Cannot run program "javac": CreateProcess error=2, O sistema não pode encontrar o arquivo especificado
//		at java.lang.ProcessBuilder.start(Unknown Source)
//		at java.lang.Runtime.exec(Unknown Source)
//		at java.lang.Runtime.exec(Unknown Source)
//		at net.sf.jasperreports.engine.design.JRJavacCompiler.compileClasses(JRJavacCompiler.java:75)
//		... 7 more
//	Caused by: java.io.IOException: CreateProcess error=2, O sistema não pode encontrar o arquivo especificado
//		at java.lang.ProcessImpl.create(Native Method)
//		at java.lang.ProcessImpl.<init>(Unknown Source)
//		at java.lang.ProcessImpl.start(Unknown Source)
//		... 11 more
		JasperReport report = JasperCompileManager.compileReport("./Blank.jrxml");
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(clientes));
		JasperExportManager.exportReportToPdfFile(print, "c:/Itens.pdf");
	}

	public static String getPathToReportPackage() { return pathToReportPackage; }
	public static String getPath() { return path;	}
}
