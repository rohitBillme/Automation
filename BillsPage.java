package partner_portal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;




public class BillsPage {
	
	
	public static void main(String[] args) {
		
			LogintoDashboard();
			//OfflineCampaigns_banner();
	}
	public static void waitperiod() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
			
	public static  void LogintoDashboard() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();;
		
		driver.manage().window().maximize();
	
		
	// Test case to check login page
		driver.get("https://test.billmepartner.com/");															// Website URL
		String url = driver.getCurrentUrl();
		System.out.println(url);  
		
		String title = driver.getTitle();
		if("BillMe Partner".equals(title)) {
			System.out.println("Right page");
		}else { 
			System.out.println("incorrect page");
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\'username\']")).sendKeys("rohit@billme.co.in"); 
		System.out.println("email entered");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div/form[1]/button")).click(); 
		System.out.println("OTP sent");
		driver.findElement(By.xpath("//*[@id=\"otp\"]")).sendKeys("123456");
		System.out.println("OTP entered");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div/form[2]/button")).click();
		
		
	/*	//System.out.println(java.time.LocalDateTime.now());
		try {
			TimeUnit.SECONDS.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//System.out.println(java.time.LocalDateTime.now());
		
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		*/	
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/div/div[2]/div/div/div[5]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/div/div[3]/div/button[1]")).click();
		
		String add_contact = "https://test.billmepartner.com/addContact";
		if(add_contact.equals(driver.getCurrentUrl())) {
			driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/form/center/div/button[1]")).click();
		}
		
		
		String title_dashboard = driver.getCurrentUrl();
		System.out.println(title_dashboard);
		
		if("https://test.billmepartner.com/dashboard".equals(title_dashboard)) {
			System.out.println("login success");
		} else {
			System.out.println("login fail");
		}
				
		//Bill;s Page
		driver.get("https://test.billmepartner.com/bills");
		System.out.println("You are on Bill's page");
		waitperiod();
		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div[1]/div[3]/div/div[2]/button[1]")).click();   //Open filters to select Dates and set time
		
		//Date - TO be Done
	/*	driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div[1]/div[3]/div[2]/div/div/div/div/div[2]/div[1]/div/div/div[1]/div")).click();
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("DateRangePicker__MonthDates")));    //Putting wait on the calendar to select values
		String currentDate = driver.findElement(By.className("DateRangePicker__Date DateRangePicker__Date--today")).getText();
		int previousDate = Integer.parseInt(currentDate);
		previousDate = previousDate-1;
		driver.findElement(By.className("DateRangePicker__Date DateRangePicker__Date--today")).click() */
		
		WebElement TimeFrom = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div[1]/div[3]/div[2]/div/div/div/div/div[2]/div[1]/div/div/div[2]/select[1]"));
		WebElement TimeTo = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div[1]/div[3]/div[2]/div/div/div/div/div[2]/div[1]/div/div/div[2]/select[3]"));
		WebElement FromAmPm = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div[1]/div[3]/div[2]/div/div/div/div/div[2]/div[1]/div/div/div[2]/select[2]"));
		WebElement ToAmPm = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div[1]/div[3]/div[2]/div/div/div/div/div[2]/div[1]/div/div/div[2]/select[4]"));
		
		Select TimeFromDD = new Select(TimeFrom);
		Select TimeToDD = new Select(TimeTo);
		Select FromAmPmDD = new Select(FromAmPm);
		Select ToAmPmDD = new Select(ToAmPm);
		
		// setting dropdown values
		TimeFromDD.selectByValue("06");      //---------------------------------------------> setting dropdown value
		waitperiod();
		FromAmPmDD.selectByValue("AM");     //---------------------------------------------> setting dropdown value
		waitperiod();
		TimeToDD.selectByValue("06");    //---------------------------------------------> setting dropdown value
		waitperiod();
		ToAmPmDD.selectByValue("PM");		   //---------------------------------------------> setting dropdown value
		waitperiod();
		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div[1]/div[3]/div[2]/div/div/div/div/div[3]/div/button[3]")).click();
		waitperiod();
		
		//customer phone number  to be stored in array
		List<String> CustPhone = new ArrayList<String>();  
		
		
		//Capture Total Sales value
		String STValue = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div[1]/div[4]/div[1]/div[1]")).getText();
		
		STValue = STValue.replaceAll("[^a-zA-Z0-9.]", "");
		
		float  TotalSales = Float.parseFloat(STValue);
		System.out.println("TotalSales:" + TotalSales);
		
		//Capture Average Billing value
		String SAValue = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div[1]/div[4]/div[2]/div[1]")).getText();
		SAValue = SAValue.replaceAll("[^a-zA-Z0-9.]", "");
		
		float   AverageSales= Float.parseFloat(SAValue);
		System.out.println("Average Billing:" + AverageSales);
		
		// Capturing Transactional values
		String TotalTrans = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div[1]/div[4]/div[3]/div[1]/span")).getText();
		
		double TTrans = Double.parseDouble(TotalTrans)/10; 
		System.out.println(TTrans);
		int abc = (int )Math.round(TTrans);
		
		System.out.println("new value" + abc);//------------------------------------------------------------------------------------------------------------------> Getting total transactions value
		
		String CountBillMe = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div[1]/div[4]/div[4]/div[1]/span[1]")).getText();
		int BillMeC = Integer.parseInt(CountBillMe);		//------------------------------------------------------------------------------------------------------------------> Getting total Billme Transaction count
		//System.out.println(BillMeC);
		String PerBillMe = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div[1]/div[4]/div[4]/div[1]/span[2]")).getText();
		PerBillMe = PerBillMe.replaceAll("[^a-zA-Z0-9.]", "");
		//int BillMeP = Integer.parseInt(PerBillMe);		//------------------------------------------------------------------------------------------------------------------> Getting total Billme Transaction percentage
		
		String CountPrint = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div[1]/div[4]/div[5]/div[1]/span[1]")).getText();
		int PrintC = Integer.parseInt(CountPrint);		//------------------------------------------------------------------------------------------------------------------> Getting total Print transaction count
		//System.out.println(PrintC);
		String PerPrint = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div[1]/div[4]/div[5]/div[1]/span[2]")).getText();
		PerPrint = PerPrint.replaceAll("[^a-zA-Z0-9.]", "");		
		//int PrintP = Integer.parseInt(PerPrint);		//------------------------------------------------------------------------------------------------------------------> Getting total Print transaction percentage
		
		String CountBillmeP = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div[1]/div[4]/div[6]/div[1]/span[1]")).getText();
		int BMPC = Integer.parseInt(CountBillmeP);		//------------------------------------------------------------------------------------------------------------------> Getting total BMPrint transaction count
		//System.out.println(BMPC);
		String PerBMP = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div[1]/div[4]/div[6]/div[1]/span[2]")).getText();
		PerBMP = PerBMP.replaceAll("[^a-zA-Z0-9.]", "");
		//int BMPP = Integer.parseInt(PerBMP);		//------------------------------------------------------------------------------------------------------------------> Getting total  total BMPrint transaction Percentage
		
		//inititalizing the variables for table values in transactional data
		int totalBillValue =0;
		int CountBM = 0;
		int CountBMP = 0;
		int CountP = 0;
		int BM = 0;
		int BMP = 0;
		int P = 0;
		int rsize = 0;
		int csize = 0;
		int NextBCounter = 0;
		
		String TransactionType = null;
		String CustomerPhone = null;
		//Bill's page Table 
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		*/
		/*Boolean  NextButton =driver.findElement(By.xpath("//li[@class=' next']//ancestor::div[1]//li//a")).isDisplayed();
		WebElement NextB1 = driver.findElement(By.xpath("//li[@class=' next']//ancestor::div[1]//li//a"));*/
		
		for(int a =0; a<abc; a++) {
		//while (!driver.findElements(By.xpath("//li[@class=' next']//ancestor::div[1]//li//a")).isEmpty()) {
				
				//NextBCounter = NextBCounter +1;
				//NextB1.click();*/
				//working with pagination
				
				List<WebElement>  Rows = driver.findElements(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div[2]/table/tbody/tr")); 
				rsize = Rows.size();
				
				List<WebElement>  columns = driver.findElements(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div[2]/table/tbody/tr[1]/td"));		
				csize = columns.size();
							
					for( int i = 1; i<=rsize; i++) {
					for (int j = 1; j<=csize; j++) {
						
						//Bill Value
						if ( j == 6 ) {
						String SBvalue = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div[2]/table/tbody/tr[" + i +"]/td[" + j + "]")).getText();
						SBvalue = SBvalue.replaceAll("[^a-zA-Z0-9]", "");
						int Bvalue = Integer.parseInt(SBvalue);
						
						
						totalBillValue = Bvalue + totalBillValue;
						}
						//Transaction type count
						else if ( j == 9 ) {
							
							 TransactionType = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div[2]/table/tbody/tr[" + i +"]/td[" + j + "]")).getText();
							
								if (TransactionType.equals("BillMe")) {
									BM = CountBM+1;
									CountBM++;
								}		else if (TransactionType.equals("Print")){
									P = CountP+1;
											CountP++;
								}		else if (TransactionType.equals("BillMe + Print")){
									BMP = CountBMP+1;
									CountBMP++;
								}
							}
						//Customer Phone number
						else if (j ==4) {
							CustomerPhone = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div[2]/table/tbody/tr[" + i +"]/td[" + j + "]")).getText();
							CustomerPhone = CustomerPhone.replace("+91-", "");
							CustPhone.add(CustomerPhone);
						}
						
				//nextbutton.click();
			}/* if(driver.findElement(By.xpath("//li[@class=' next']//ancestor::div[1]//li//a")).isDisplayed()) {
				driver.findElement(By.xpath("//li[@class=' next']//ancestor::div[1]//li//a")).click();*/
			}if(!driver.findElements(By.xpath("//li[@class=' next']//ancestor::div[1]//li//a")).isEmpty()) {
				driver.findElement(By.xpath("//li[@class=' next']//ancestor::div[1]//li//a")).click();
				waitperiod(); System.out.println("Next button clicked");
			}
			
					}
			
				
				/*for(int i=0; i<=2;i++){
					  try{
						  WebElement NextB1 = driver.findElement(By.xpath("//li[@class=' next']//ancestor::div[1]//li//a"));
						  if(NextButton == true) {  NextB1.click();   }
							  break;}
					  
					  catch(Exception e){
						  
						  System.out.println(e.getMessage());
					  }
					}*/
						
				
			
		
		
		//System.out.println("Next button not found");
		
			
	System.out.println(BM + " " + P + " " + BMP);
		
		//Checking to see if Total Sales are matching
		if (TotalSales == totalBillValue) {
			System.out.println("Total billvalue matched : " + totalBillValue);
		}
			//Checking to see if Total Transactions  are matching
			int total_transaction = BM + P + BMP;
			if (TTrans==total_transaction) {
				System.out.println("Total transaction matched : " + total_transaction);
		}
			//Checking if transactional data are correct
			if (BM == BillMeC && P == PrintC && BMP == BMPC) {
				System.out.println("BillMe transactions matched : "  + BillMeC);
				System.out.println("Print  transactions matched : "  + PrintC);
				System.out.println("BillMe+Print  transactions matched : "  + BMPC);
		}
			
			//Customer Profiling page
			driver.get("https://test.billmepartner.com/consumer-profiling");
			System.out.println("you are now on Consumer Profilling page");
			
			//*[@id="page-content-wrapper"]/div/div/div[5]/table
			List<WebElement>  CustRows = driver.findElements(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div[5]/table/tbody/tr"));
			int CustRsize = CustRows.size();
			System.out.println(CustRsize);
			List<WebElement>  custcolumns = driver.findElements(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div[5]/table/tbody/tr[1]/td"));
			int CustCsize = custcolumns.size();
			System.out.println(CustCsize);

			
			WebElement SearchCustomer = driver.findElement(By.xpath("//*[@id=\"searchTxt\"]"));
			
			//Searching in the table using the search functionality
			for (int i = 0; i< CustPhone.size();i++) {
				SearchCustomer.click();
				SearchCustomer.clear();
				SearchCustomer.sendKeys(CustPhone.get(i));
				
				waitperiod();
				String  tablevaluePhone = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div[5]/table/tbody/tr[1]/td[1]")).getText();
				System.out.println(tablevaluePhone);
				if (tablevaluePhone.equals(CustPhone.get(i))) {
					System.out.println("customer found!!");
					SearchCustomer.clear();
				}else {
					System.out.println("customer not found");
					SearchCustomer.clear();
				}
				}
			//add new customer
			WebElement AddCust = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div[2]/div/button"));
			AddCust.click();
			WebElement AddManually = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div[2]/div/div/p[1]"));
			AddManually.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				String CurrentURL = driver.getCurrentUrl();
				if(CurrentURL == "https://test.billmepartner.com/consumer-profiling/add") {
					System.out.println("Add Customer Page successfully launched");
				} else {
					return;
				}
				}
			//Adding cutomer details
			driver.findElement(By.id("firstName")).sendKeys("FirstName01");
			driver.findElement(By.id("lastName")).sendKeys("LastName01");
			driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div[3]/div[1]/div/form/div[3]/div/div/input")).sendKeys("10/03/2021");
			driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div[3]/div[1]/div/form/div[4]/span[2]/button")).click();
			driver.findElement(By.id("email")).sendKeys("rohit00@gmail.com");
			String custNewPh ="1234867102";
			driver.findElement(By.id("phone")).sendKeys(custNewPh);
			driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div[2]/div/div[2]/div/button[2]")).click();
			System.out.println("New customer created");
			waitperiod();
			
			//finding newly created customer
			
			for(int i=0; i<=2;i++){
				  try{
					  driver.findElement(By.xpath("//*[@id=\"searchTxt\"]"));
				     break;
				  }
				  catch(Exception e){
					  
					  System.out.println(e.getMessage());
				  }
				}
			waitperiod();
			//for (j=0;j<)
			driver.findElement(By.xpath("//*[@id=\"searchTxt\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"searchTxt\"]")).click();
			driver.findElement(By.xpath("//*[@id=\"searchTxt\"]")).sendKeys(custNewPh);
			waitperiod();
			String  tablevaluePhone = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div[5]/table/tbody/tr[1]/td[1]")).getText();
			 
			if (tablevaluePhone.equals(custNewPh)) {
				System.out.println("newly created customer found!!");
			}else {
				System.out.println("newly created customer not found");
			}
			
			//Store Management Page
			driver.get("https://test.billmepartner.com/storeManagement?tab=Company");
			System.out.println("You are on Store Management Page");
			//Create a new Company
			String Cname = "Rohit's Comapny1";
			String CInchargeName = "BillMe";
			String CGSTV = "7531594862";
			String CPhone = "9004075930";
			String CPAN = "ABCPP1234M";
			String CPIN = "560036";
			String CEmail = "rohit1@gmail.com";
			String CBillingName = "NewCompany Billing";
			String CAddress = "6-1-38/1, PRASADS ENTERTAINMENT CENTRER, OFF NTR, GARDENS, LIC DIVISION PO, Hyderabad, Telangana,";
					
			driver.findElement(By.id("Icon_material-add")).click();
			waitperiod();
			driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div[2]/div[2]/div/div/p[1]")).click();
			waitperiod();
			//Entering Company details
			driver.findElement(By.id("companyName")).sendKeys(Cname);
			driver.findElement(By.id("inchargeName")).sendKeys(CInchargeName);
			driver.findElement(By.id("gst")).sendKeys(CGSTV);
			driver.findElement(By.id("mobileNumber")).sendKeys(CPhone);
			driver.findElement(By.id("pan")).sendKeys(CPAN);
			driver.findElement(By.id("pincode")).sendKeys(CPIN);
			driver.findElement(By.id("emailId")).sendKeys(CEmail);
			driver.findElement(By.id("billingName")).sendKeys(CBillingName);
			driver.findElement(By.id("officeAddres")).sendKeys(CAddress);
			//Entering Dropdown details
			driver.findElement(By.xpath("//*[@id=\"companyType\"]/div[1]")).click();   //------------------------------------Company Type
			//driver.findElement(By.xpath("//*[@id=\"react-select-7-option-1\"]")).click();
			
			driver.findElement(By.xpath("//*[@id=\"country\"]/div[1]")).click();   //----------------------Country
			//driver.findElement(By.xpath("//*[@id=\"react-select-8-option-100\"]")).click(); 
			
			driver.findElement(By.xpath("//*[@id=\"state\"]/div[1]")).click();
			//driver.findElement(By.xpath("//*[@id=\"react-select-9-option-20\"]")).click();
			
			driver.findElement(By.xpath("//*[@id=\"city\"]/div[1]")).click();
			//driver.findElement(By.xpath("//*[@id=\"react-select-6-option-341\"]")).click();

			
			driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div[1]/div[2]/div/button")).click();
			waitperiod();
			System.out.println("New company created");
			
			//Sesrch for the newly created company
			driver.findElement(By.xpath("//*[@id=\"searchTxt\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"searchTxt\"]")).click();
			driver.findElement(By.xpath("//*[@id=\"searchTxt\"]")).sendKeys(Cname);
			waitperiod();
			String  SearchedCompany = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div[4]/table/tbody/tr[1]/td[1]")).getText();
			String SearchedIncharge = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div[4]/table/tbody/tr[1]/td[2]")).getText();
			String SearchedPhone = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div[4]/table/tbody/tr[1]/td[3]")).getText();
			String SearchedEmail = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div[4]/table/tbody/tr[1]/td[4]")).getText();
			String SearchedGST = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div[4]/table/tbody/tr[1]/td[5]")).getText();
			//verify if created company is correctly displayed
			if (Cname == SearchedCompany && CInchargeName == SearchedIncharge && CPhone == SearchedPhone && CEmail == SearchedEmail && CGSTV == SearchedGST) {
				System.out.println("Newly Created Company found. Search is working fine !!");
			}else { System.out.println("Newly created Comany not found");}
			
			//Create a new Brand
			
			
			
			
			
	driver.close();
}	
}



