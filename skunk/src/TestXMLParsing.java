import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.sun.xml.internal.ws.util.StringUtils;

import oracle.sysman.emai.model.odi.LoadPlanExecutionHierarchyInfo;
import oracle.sysman.emai.model.odi.SessionHierarchyInfo;

public class TestXMLParsing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileInputStream fin = new FileInputStream(new File("c:\\test.xml"));
			// InputStreamReader isr = new InputStreamReader(fin);
			Scanner scan = new Scanner(fin);
			VcftoCsv vcftocsv = new VcftoCsv();
			while (scan.hasNextLine()) {
				String y = scan.nextLine();
				lpe(y);
				System.out.println(y);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void lpe(String ixml) {
		LoadPlanExecutionHierarchyInfo aLPEHierarchyInfo = new LoadPlanExecutionHierarchyInfo();
		// if (StringUtils.isNotBlank(y))
		// {
		try {
			JAXBContext jc = JAXBContext
					.newInstance(LoadPlanExecutionHierarchyInfo.class);
			Unmarshaller um = jc.createUnmarshaller();
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
					ixml.getBytes("UTF-8"));
			aLPEHierarchyInfo = (LoadPlanExecutionHierarchyInfo) um
					.unmarshal(byteArrayInputStream);
		} catch (JAXBException jaxbExc) {
			// TODO - log
			jaxbExc.printStackTrace();
		} catch (UnsupportedEncodingException ueExc) {
			// TODO - log
			ueExc.printStackTrace();
		}
	}

	public static void session(String ixml) {
		SessionHierarchyInfo aLPEHierarchyInfo = new SessionHierarchyInfo();
		// if (StringUtils.isNotBlank(y))
		// {
		try {
			JAXBContext jc = JAXBContext
					.newInstance(LoadPlanExecutionHierarchyInfo.class);
			Unmarshaller um = jc.createUnmarshaller();
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
					ixml.getBytes("UTF-8"));
			aLPEHierarchyInfo = (SessionHierarchyInfo) um
					.unmarshal(byteArrayInputStream);
		} catch (JAXBException jaxbExc) {
			// TODO - log
			jaxbExc.printStackTrace();
		} catch (UnsupportedEncodingException ueExc) {
			// TODO - log
			ueExc.printStackTrace();
		}
	}

}
