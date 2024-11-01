package com.ABSLI.qa.testcases.Newbusiness;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.Homepage;
import com.ABSLI.qa.pages.Loginpage;
import com.ABSLI.qa.pages.Newbusiness.MemberUpload;
import com.ABSLI.qa.pages.Newbusiness.VoluntaryMemberUpload;
import com.ABSLI.qa.utill.AbsliUtill;

public class VoluntaryMemberUploadtest extends AbsliParent {

	Loginpage loginpage;
	Homepage homepage;

	@BeforeMethod
	public void setup() throws Throwable {
		initial();
		loginpage = new Loginpage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new Homepage();
	}
	@DataProvider(name = "VoluntaryMemberupload")
	public Object[][] getTestuploaded() {
		Object arrbj[][] = AbsliUtill.getDataFromExcel(
				"C:\\Users\\Mallikandan E\\git\\Manikandan-AutomationScript\\ABSLITest\\src\\main\\java\\com\\ABSLI\\qa\\testdata\\Newbusiness\\MemberUploaded.xlsx",
				"Memupload");
		return arrbj;
	}

	@Test(priority = 0,dataProvider = "VoluntaryMemberupload",dataProviderClass = VoluntaryMemberUploadtest.class )
	public void Voluntryaddmember(String ClientName, String MasterPolicyNumber, String AgreementNumber,
			String AuthorisedSignatory, String FileLocation) throws Throwable {
		homepage.Volutarymemberuploading();
		VoluntaryMemberUpload VMU = new VoluntaryMemberUpload();
		VMU.volumemupload(ClientName, MasterPolicyNumber, AgreementNumber, AuthorisedSignatory, FileLocation);
	}

	@DataProvider(name = "VoluntaryDefectData")
	public Object[][] getTestdefuploaded() {
		Object arrbj[][] = AbsliUtill.getDataFromExcel(
				"C:\\Users\\Mallikandan E\\git\\Manikandan-AutomationScript\\ABSLITest\\src\\main\\java\\com\\ABSLI\\qa\\testdata\\Newbusiness\\MemberUploaded.xlsx",
				"Defectdata");
		return arrbj;
	}

	@Test(priority = 1,dataProvider = "VoluntaryDefectData",dataProviderClass = VoluntaryMemberUploadtest.class )
	public void defectdata(String ClientName, String MasterPolicyNumber, String AgreementNumber) throws Throwable {
		homepage.Voluntarydefectdata();
		VoluntaryMemberUpload VMU = new VoluntaryMemberUpload();
		VMU.voluntarydefectdata(ClientName, MasterPolicyNumber, AgreementNumber);
	}

}
