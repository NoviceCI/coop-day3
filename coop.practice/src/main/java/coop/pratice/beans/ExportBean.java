package coop.pratice.beans;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import coop.pratice.domain.User;
import coop.pratice.service.UserService;

@Component
@Scope
public class ExportBean {

	@Autowired
	private UserService userservice;

	public void exportarPDF() throws JRException, IOException {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("txtUserio", "MidCode");

		File jasper = new File(FacesContext.getCurrentInstance()
				.getExternalContext().getRealPath("/report.jasper"));

		JasperPrint jasperPrint = JasperFillManager.fillReport(
				jasper.getPath(), parametros, new JRBeanCollectionDataSource(
						this.userservice.getUsers()));

		HttpServletResponse response = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		response.addHeader("Content-disposition",
				"attachment; filename=jsfReporte.pdf");
		ServletOutputStream stream = response.getOutputStream();

		JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

		FacesContext.getCurrentInstance().responseComplete();

		stream.flush();
		stream.close();
		FacesContext.getCurrentInstance().renderResponse();
	}

	public void verPDF() throws Exception {

		File jasper = new File(FacesContext.getCurrentInstance()
				.getExternalContext().getRealPath("/report.jasper"));

		byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), null,
				new JRBeanCollectionDataSource(this.userservice.getUsers()));
		
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream  outputStream = response.getOutputStream();
		outputStream.write(bytes,0,bytes.length);
		
		outputStream.flush();
		outputStream.close();
	
		FacesContext.getCurrentInstance().renderResponse();
	}
}
