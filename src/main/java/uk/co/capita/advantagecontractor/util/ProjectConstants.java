package uk.co.capita.advantagecontractor.util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class ProjectConstants {
	//Grid Run FLag
	
		public static final boolean GRID_RUN_MODE = false;
		
		
		
	//TestData XLS column names
		public static final Object TESTDATA_RUNMODECOL_NAME = "Runmode";
		//public static final String TESTDATA_SHEET_NAME = "Test Data";
		public static final String TESTCASES_SHEET_NAME = "Test Cases";
		public static final String MODULES_SHEET_NAME = "Modules";

	//Test Environment details	
		public static final String TEST_URL = "http://manhscewwebdi03.css.ad.capita.co.uk:1981/";
		

	//Wait time for webdriver
		public static final long PAGE_LOAD_TIMEOUT = 100;//in seconds
		public static final long WEBDRIVER_WAIT_TIME = 60;//in seconds
		public static final long IMPLICIT_WAIT = 30;
		
		
	//paths
		public static final String REPORTS_PATH = "C:\\Ragha\\Advantage Housing\\Workspace\\AdvantageContractor\\Extent Reports\\";


	// xpaths
		//Common across all pages
		public static final String PAGELOADSTATUS_IMAGE = "//*[@id='load']";
		public static final String SEARCHDISPLAY_DROPDOWN = "//button[@ng-model = 'displaydropdown']";
		public static final String SEARCH_TXTBOX = "//input[@id='usearchString']";
		//public static final String SEARCH_JOBS_OPTION = "//a[text() = 'Jobs']";

		
		
		
		
		//Login Page
		public static final String LOGIN_BUTTON = "//button[@id='login']";
		public static final String LOGOUT_LINK = "//input[@name = 'logout']";
		public static final String USERNAME_TXTBOX = "//input[@id='j_username']";
		public static final String PWD_TXTBOX = "//input[@id='j_password']";
		//Landing Page
		public static final String MENU_LINK = "//div[text() = 'Menu']";
		public static final String LOG_JOB_LINK = "//a[text() = 'Log job']";
		public static final String MANAGE_JOB_LINK = "//a[text() = 'Manage Job']";

		//Location Search Page
		public static final String LOCATION_SEARCH_TXTBOX = "//input[@name = 'searchString']";
		public static final String SEARCH_BUTTON = "//button[text() = 'Search']";
		//LOcation Search Results Page
		public static final String SEARCH_RESULTS_TXT = "//h2[text() = 'Search results']";
		public static final String SRP_CONTINUE_BTN = "//button[@ng-click = 'vm.continueToAssessment()']";
		public static final String JOBASSES_LABEL = "//span[text() = 'Job assessment']";
		//Job Assessment Page
		public static final String STDJOB_DROPDOWN = "//form/div[2]/span/span/span[1]";
		public static final String SUBLOC_DROPDOWN = "//form/div[3]/span/span/span[1]";
		public static final String SELECTFILE_BTN = "//input[@id='attachment']";
		public static final String JAP_CONTINUE_BTN = "//button[text() = 'Continue']";
		public static final String JOBDETAIL_LABEL = "//span[text() = 'Job detail']";
		//Job Detail Page
		public static final String CONTRACT_DROPDOWN = "//form/div[1]/div/span/span/span[1]";
		//public static final String PRIORITY_DROPDOWN = "//div[3]/div[1]/div/div/span/span/span[1]";
		public static final String MAINTRADE_DROPDOWN = "//div[2]/div/div/span/span/span[1]";
		public static final String COSTCODE_TXTBOX = "//input[@name = 'costcode']";
		public static final String VAT_DROPDOWN = "//div[5]/div[1]/div/div/span/span/span[1]";
		public static final String DIAGSECTION_CONTINUE_BTN = "//form/div[6]/button";
		public static final String FINSECTION_CONTINUE_BTN = "//form/div[7]/button";
		public static final String REPAIRSOFFICER_DROPDOWN = "//div[6]/div/div/div/span/span/span[1]";
		public static final String LOGJOB_BTN = "//button[text() = 'Log job']";
		public static final String JOBLOGGED_MSG = "//li[text() = 'Job logged successfuly.']";
		//search results page
		public static final String SEARCHRESULTS_HEADER = "//span[@id='frheader']";
		public static final String SEARCHRESULT_ELEMENT = "//div[@id='further-results']/div[2]/div[1]/div/div[";
		
		//Manage Job page
		public static final String MANAGEJOB_LABEL = "//span[text() = 'Manage job']";
		public static final String TARGET_LINK = "//*[name() = 'g'][15]/*[name() = 'g']/*[name() = 'text'][1]";

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		
		//Generic - applicable to all pages
		public static final String CREATE_SUCCESS_MSG = "//div[contains(text(), 'reated')]";
		public static final String UPDATE_SUCCESS_MSG = "//div[contains(text(), 'pdated')]";
		public static final String DELETE_SUCCESS_MSG = "//div[contains(text(), 'eleted')]";
		
		public static final String CREATE_BTN = "//button[contains(text(), 'Create')]";
		public static final String CREATE_PAGETITLE = "//h1[contains(@id, '_header')]";
		public static final String YES_BTN = "//button[text() = 'Yes']";
		public static final String ADD_BTN = "//button[text() = 'Add']";
        public static final String DELETE_POPUP = "//div[@class='k-content k-window-content k-dialog-content']";

		
		
		//Contract List Page
		public static final String CONTRACT_SEARCH_TXTBOX = "//table/thead/tr[2]/th[1]/kendo-grid-string-filter-cell/kendo-grid-filter-wrapper-cell/input";
		public static final String CONTRACT_SEARCH_RESULT = "//table/tbody/tr/td[1]";
		public static final String EDITCONTRACT_ICON = "//span[@title = 'edit Contractor']";
		public static final String DELETECONTRACT_ICON = "//span[@title = 'Delete Contractor']";
		

		//Contract Details Main Page
		public static final String PRIORITIES_BAR = "//div[text() = ' Priorities ']";
		public static final String LOADING_ICON = "//span[@class = 'k-i-loading k-icon']";
		public static final String SYSTEMOPTIONS_BAR = "//div[text() = ' Contract system options ']";
	    public static final String MAINTAINCERTIFICATES_BAR = "//div[text() = ' Maintain certificates ']";
		public static final String AUTOPIVAL_BAR = "//div[text() = ' Auto post inspection value bands ']";
		public static final String JOBTYPES_BAR = "//div[text() = ' Job types ']";
		public static final String CONTRACTORS_BAR = "//div[text() = ' Contractors ']";
		public static final String CONTRACTOROPERATIVES_BAR = ".ng-tns-c17-1.k-item.k-state-default>span";
		public static final String DIARY_BAR = "//div[text() = ' Diary ']";
		public static final String SOR_BAR = "//div[text() = ' Schedule of rates ']";
		public static final String CONTRACTRECHARGE_BAR = "//div[text() = ' Contract recharge ']";
        public static final String CONTACTDETAILS_BAR = "//div[text() = ' Contact details ']";
        public static final String JOBNUMBER_BAR = "html/body/app-root/div/div/div[2]/accordion-repairs-contract/div/div[12]";
        public static final String CONTRACTORS_ACCORDIAN = "//div[text()=' Contractors ']";
        public static final String JOBCOSTING_BAR = "//div[text()=' Job Costing ']";
		
			
		//Priorities List Page
		public static final String PRIORITY_SEARCH_TXTBOX = "//table/thead/tr[2]/th[1]/kendo-grid-string-filter-cell/kendo-grid-filter-wrapper-cell/input";
		public static final String EDITPRIORITY_ICON = "//span[@class = 'k-icon k-i-pencil k-button-actions k-button k-grid-edit-command']";
		public static final String DELETEPRIORITY_ICON = "//span[@class = 'k-icon k-i-delete k-button-actions k-button k-grid-remove-command']";

		
		//Create Priority Page
		public static final String PRIORITY_TXTBOX = "//input[@id='priorityCodeinput']";
		public static final String DESCR_TXTBOX = "//input[contains(@id, 'escription')]";
		public static final String TARGET_DAYS_TXTBOX = "//input[@id='target_days']";
		public static final String TARGET_HOURS_TXTBOX = "//input[@id='priority_hours']";
		public static final String ACTIVE_CHKBX = "//label[@name = 'Inactive']";
		public static final String JOBATTEND_CHKBX = "//label[@name = 'attendance_flag']";
		
		
		
		//Create Contract Page
		public static final String CONTRACT_TXTBOX = "//input[@id = 'contract']";
		public static final String DESCRIPTION_TXTBOX = "//input[@formcontrolname = 'Description']";
		public static final String INVOICETYPE_DROPDOWN = "//div[7]/label/kendo-dropdownlist/span/span[1]";
		public static final String INVOICETYPE_OPTION = "//kendo-list/div/ul/li[1]";
		

		//Edit Contract Page
		public static final String DESCRIPTION_EDIT_TXTBOX = "//input[@id='description' and @formcontrolname = 'Description']";
		public static final String UPDATE_BTN = "//button[text() = 'Update']";


		//Edit Priority page
		public static final String UPDATEPRIORITY_BTN = "//button[2]";

		
		//Create System Options Page
		
		public static final String CREATESYSOPTIONS_PAGETITLE = "//h1[text() ='Create contract system options']";
		public static final String OPTION_DROPDOWN = "//label/kendo-dropdownlist/span/span[2]/span";
		public static final String VALUE_DROPDOWN = "//label/div/div/kendo-dropdownlist/span/span[2]/span";
		public static final String OPTION_ACTUALCOSTS = "//li[contains(@id, 'ACTUALCOSTS')]";
		public static final String VALUE_Y = "//li[contains(@id, 'Y')]";

		//System Options List page
		public static final String OPTION_SEARCH_TXTBOX = "//table/thead/tr[2]/th[1]/kendo-grid-string-filter-cell/kendo-grid-filter-wrapper-cell/input";
		public static final String DELETESYSOPTION_ICON = "//kendo-grid-list/div/div[1]/table/tbody/tr/td[4]/span[3]";
		public static final String EDITSYSOPTION_ICON = "//kendo-grid-list/div/div[1]/table/tbody/tr/td[4]/span[1]";
		
		//Edit System Options page
		public static final String DESCRI_TXTBOX = "//input[@id='Description']";

	//Create Certificates Page- RM
	public static final String CREATECERTIFICATES_PAGETITLE = "//h1[@id='autopi_header']";
	//public static final String CERTIFICATEREFERENCE_TEXTFIELDTITLE = "html/body/app-root/div/div/div[2]/app-create-certificate/div/div[2]/form/div/div/div/div[1]/div[1]/label/span";
	public static final String CERTIFICATEREFERENCE_TXTBOX = "//*[@id='cert_certificate']";
	//public static final String CERTIFICATECONTRACTOR_TEXTFIELDTITLE = "html/body/app-root/div/div/div[2]/app-create-certificate/div/div[2]/form/div/div/div/div[2]/div[1]/label/span";
	public static final String CERTIFICATECONTRACTOR_DROPDOWN = "//*[@formcontrolname='Contractor']//span[@class='k-input']";
	public static final String CERTIFICATECONTRACTOR_SELECTLIST = "//li[@class='k-item k-state-focused']";
	//public static final String CERTIFICATEDISCRIPTION_TITLE = "//label[@for='cert_description']";
	public static final String CERTIFICATEDISCRIPTION_TXTBOX = "//input[@formcontrolname='Description']";
	public static final String CREATEDCERTIFICATEDISCRIPTION_TXT = "//tr[@class='k-alt']/td[6]";

	//Edit Certificates Page
	public static final String UPDATE_ICON= "//span[@class='k-icon k-i-edit k-button k-grid-edit-command']";

	//Delete Certificates Page
	public static final String DELETE_ICON= "//span[@class='k-icon k-i-delete k-button k-grid-remove-command']";
	public static final String NO_RECORD_TEXT = "//tr[@class='k-grid-norecords']/td";


		//Create Auto PI Value Bands page
		public static final String VALUEGREATERTHAN_ICON = "//span[@class = 'k-icon k-i-arrow-n']";
		public static final String PERCENTAGE_TXTBOX = "//input[@id='percentage']";
		public static final String CREATEAUTOPIVALBAND_PAGETITLE = "/h[@id='priority_header']";


		//Auto PI Value Bands List page
		public static final String EDITAUTOPI_ICON = "//div/div/kendo-grid/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[3]/span[1]";
		public static final String DELETEAUTOPI_ICON = "//div/div/kendo-grid/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[3]/span[2]";

		//Edit Auto PI Value Bands page
		public static final String PERCENTAGE_ED_TXTBOX = "//input[@placeholder = 'Percentage']";
		
		//Create Job Type page
		public static final String JOBTYPE_DROPDOWN = "//span[@class = 'k-input']";
		public static final String JOBTYPESEARCH_TXTBOX = "//kendo-popup/div/span/input";
		public static final String OPTION_JPBTYPE = "//li[contains(@id, 'DHWO')]";
		public static final String EFFDATE_TXTBOX = "//span/input";
		public static final String CREATEJOBTYPE_PAGETITLE = "//div[text() = 'Create job type ']";


		//Edit Job Type page
		public static final String ONCONTRACT_CHKBOX = "//label[text() = ' On contract']";
		public static final String UPDATEJOBTYPE_BTN = "//button[text() = 'Update job type']";


		//Job Type List Page
		public static final String JOBTYPE_SEARCH_TXTBOX = "//tr[2]/th[1]/kendo-grid-string-filter-cell/kendo-grid-filter-wrapper-cell/input";
		public static final String EDITJOBTYPE_ICON = "//span[@title = 'Edit job type']";
		public static final String DELETEJOBTYPE_ICON = "//span[@title = 'Delete job type']";


		//Create Operative Page
		public static final String OPERCODE_TXTBOX = "//input[@id='operativeCode']";
		public static final String OPERNAME_TXTBOX = "//input[@id = 'operativeName']";
		public static final String CREATEOPERATIVE_PAGETITLE = "//h1[@id='operative_header']";


		//Edit Operative page
		public static final String UPDATEOPERATIVE_BTN = "//button[text() = 'Update operative']";
		public static final String OPERNAME_EDIT_TXTBOX = "//input[@formcontrolname = 'OperativeName']";


		//Operative List Page
		public static final String CREATEOPERATIVE_BTN = "//button[text() = 'Create operative']";
		public static final String OPERCODE_SEARCH_TXTBOX = ".//*[starts-with(@id, 'k-panelbar-item-default-')]/div/div/kendo-grid/div/div/table/thead/tr[2]/th[1]/kendo-grid-string-filter-cell/kendo-grid-filter-wrapper-cell/input";
		public static final String EDITOPERATIVE_ICON = "//tr/td[3]/span[1]";
		public static final String DELETEOPERATIVE_ICON = "//tr/td[3]/span[2]";


		//Add Contractor to a Contract page
		public static final String CONTRACTOR_DROPDOWN = "//label/kendo-dropdownlist/span/span[1]";
		public static final String CONTRACTOR_OPTION = "//kendo-popup/div/kendo-list/div/ul/li[1]";
		public static final String ADDTOCONTR_BTN = "//button[2]";


		//Contractor List Page
		public static final String ADDCONTRACTOR_BTN = "//button[@class = 'k-button' and @dir = 'ltr']";
		public static final String ADDCONTRACTOR_PAGETITLE = "//div[@class = 'k-window-title k-dialog-title']";
		public static final String DELETECONTRACTOR_ICON = "//table/tbody/tr/td[4]/span[2]";
		public static final String EDITCONTRACTOR_ICON = "//table/tbody/tr/td[4]/span[1]";


		//Edit Contractor Page
		public static final String ACTIVEONCONTRACT_CHKBOX = "//label[@class = 'k-checkbox-label']";
		public static final String UPDATECONTRACTOR_BTN = "//div[2]/div/button[2]";


		//Create Diary Page
		public static final String DIARYSTATUS_DROPDOWN = "//span[@class = 'k-i-arrow-s k-icon']";
		public static final String DIARYSTATUS_NML_OPTION = "//li[contains(@id, '-N')]";
		public static final String DIARYSTATUS_SVR_OPTION = "//li[contains(@id, '-S')]";
		public static final String DIARYSTATUS_CNF_OPTION = "//li[contains(@id, '-C')]";


		//Diary List Page
		public static final String DIARY_SEARCH_TXTBOX = "//tr[2]/th[3]/kendo-grid-string-filter-cell/kendo-grid-filter-wrapper-cell/input";
		public static final String EDITDIARY_ICON = "//table/tbody/tr[1]/td[4]/span[1]";
		public static final String DELETEDIARY_ICON = "//table/tbody/tr[1]/td[4]/span[2]";


		//Edit Diary Page
		public static final String DAIRYTXT_TXTBOX = "//textarea[@formcontrolname = 'FullEntryText']";


		//Create SOR Page
		public static final String CREATESOR_PAGETITLE = "//h1[text() = 'Create schedule of rates']";
		public static final String SOR_TXTBOX = "//input[@id = 'SOR']";
		public static final String PRIORITY_DROPDOWN = "//kendo-dropdownlist[@formcontrolname = 'PriorityCode']/span/span[@class = 'k-input']";
		public static final String PRIORITY_OPTION = "//li[contains(@id, 'High')]";
		public static final String DATE_TXTBOX = "//span[@class = 'k-dateinput-wrap']/input[@class= 'k-input']";
		public static final String MTHDOFCHARGE_DROPDOWN = "//kendo-dropdownlist[@formcontrolname = 'MethodOfCharge']/span/span[@class = 'k-input']";
		public static final String MTHDOFCHARGE_OPTION = "//li[contains(@id, 'VAR')]";
		public static final String NEXT_BTN = "//button[2]";
		public static final String ADDTRADE_TITLE = "//h1[text() = 'Add trade']";


		//Enter Trade And Cost Details And Save Page
		public static final String ADDTRADE_BTN = "//button[text() = 'Add trade']";
		public static final String TRADE_DROPDOWN = "//div/label/kendo-dropdownlist/span/span[1]";
		public static final String TRADE_OPTION = "//div[@class = 'k-list-scroller']/ul[@class = 'k-list k-reset']/li[1]";
		public static final String ADDCOST_BTN = "//button[text() = 'Add cost']";
		public static final String CREATECOST_BTN = "//kendo-dialog/div[2]/div/form/div/div[2]/div/button[1]";
		public static final String COSTCODE_DROPDOWN = "//kendo-dropdownlist/span/span[1]";
		public static final String COSTCODE_OPTION = "//div[@class = 'k-list-scroller']/ul[@class = 'k-list k-reset']/li[1]";


		//SOR List Page
		public static final String SORCODE_SEARCH_TXTBOX = "//schedule-of-rates/div/div/kendo-grid/div/div/table/thead/tr[2]/th[2]/kendo-grid-string-filter-cell/kendo-grid-filter-wrapper-cell/input";
		public static final String EDITSOR_ICON = "//schedule-of-rates/div/div/kendo-grid/kendo-grid-list/div/div[1]/table/tbody/tr/td[4]/i[1]";
		public static final String DELETESOR_ICON = "//schedule-of-rates/div/div/kendo-grid/kendo-grid-list/div/div[1]/table/tbody/tr/td[4]/i[2]";
		public static final String DESCR_SEARCH_TXTBOX = "//schedule-of-rates/div/div/kendo-grid/div/div/table/thead/tr[2]/th[3]/kendo-grid-string-filter-cell/kendo-grid-filter-wrapper-cell/input";


		//Edit SOR page
		public static final String SHORTDESCR_TXTBOX = "//input[@id='Description']";
		public static final String SORUPDATE_SUCCESS_MSG = "//div[starts-with(text(), 'SOR updated Successfully')]";


		//CreateRechargePage
		public static final String RESOURCECODE_TXTBOX = "//input[@name = 'ResourceCode']";
		public static final String LINENO_TXTBOX = "//table/tbody/tr[1]/td[2]/kendo-numerictextbox/span/input";
		public static final String SOR_DROPDOWN = "//table/tbody/tr[1]/td[3]/kendo-dropdownlist/span/span[1]";
		public static final String SOR_OPTION = "//li[contains(@id, 'SORTEST')]";
		public static final String UPLIFT_TXTBOX = "//kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[4]/kendo-numerictextbox/span/input";
		public static final String RECHARGEFLAG_CHECKBOX = "//table/tbody/tr[1]/td[5]/div/label";
		public static final String CREATERECHARGE_ICON = "//span[@class = 'k-icon k-i-check k-i-checkmark k-button k-grid-save-command']";


		//Recharge List Page
		public static final String ADDCONTRACTRECHARGE_BTN = "//button[text() = 'Add contract recharge']";
		public static final String RESOURCECODE_SEARCH_TXTBOX = "//table/thead/tr[2]/th[1]/kendo-grid-string-filter-cell/kendo-grid-filter-wrapper-cell/input";
		public static final String EDITRECHARGE_ICON = "//span[@class = 'k-icon k-i-edit k-button k-grid-edit-command']";
		public static final String DELETERECHARGE_ICON = "//span[@class = 'k-icon k-i-delete k-button k-grid-remove-command']";

        //Create Contact Page- RM
	    public static final String CREATECONTACT_PAGETITLE = "//h1[@id='create_contact_header']";
	    public static final String CONTACTDETAILS_HEADER = "//div[@class='row accordion-selected-header']/div/span";
	    public static final String CONTACTTYPE_DROPDOWN = "//span[@class='k-input']";
	    public static final String CONTACTLIST = "//div[@class='k-list-scroller']";
	    public static final String CONTACT_TYPESEARCH = "//span[@class='k-list-filter']/input";
	    public static final String SELECTCONTACT_OPTION = "//li[contains(@id, '-MGR')]";
	    public static final String CONTACTNAME_TXT = "//kendo-searchbar/input";
	    public static final String CREATE_CONTACT_BUTTON = "//button[@class='k-button k-primary']";
	    public static final String CONTACTNAME = "//tr[@class='k-alt']/td[2]";

	    //Edit Contact Page
	    public static final String CONTACTUPDATE_ICON= "//span[@class='k-icon k-i-pencil k-button k-grid-edit-command']";
	    public static final String EDITPOPUP_TITLE= "//div[@class='k-window-title k-dialog-title']";

	    //Create Contractor Operative Trade--RM
		public static final String CREATED_OPERATIVENAME = "//h5[@class='pl-2 mt-4']";
		public static final String OPERATIVETRADE_TITLE = "//h1[@class='contract-heading pl-2 mt-3']";
		public static final String ADDOPERATIVE_BUTTON = "//button[@class='k-button k-primary']";
		public static final String ADD_OPERATIVETRADE_POPUP_TITLE = "//div[@class='k-window-title k-dialog-title']";
		public static final String OPERATIVE_TRADE_DROPDOWN = "//form[@class='k-form ng-untouched ng-pristine ng-invalid']//span[@class='k-i-arrow-s k-icon']";
		public static final String LIST = "//div[@class='k-list-scroller']";
		public static final String ADD_TRADE_OPTION = "//li[contains(@id, '-AT')]";
		public static final String ADD_TRADE_BUTTON = "//button[@title='add']";
		public static final String ADDED_TRADE = "//tr[@class='k-alt']/td[2]";

		//Delete Operative Trade
		public static final String TRADE_DESCRIPTION_SEARCH = "#k-panelbar-item-default-0 .ng-tns-c17-1.ng-trigger.ng-trigger-toggle .mt-3 .k-widget.k-grid .k-grid-header .k-grid-header-wrap tr.k-filter-row th:nth-child(2) input";
		public static final String TRADE_DELETE_ICON = "//div[@class='mt-3']//span[@class='k-icon k-i-delete k-button k-grid-remove-command']";


	   //Create SOR Skill Set--RM
	   public static final String CREATE_SKILLSET_BUTTON = "//button[text() = 'Create Skill Set']";
	   public static final String CREATESORSKILLSET_PAGETITLE = "//h1[text() = 'Create SOR skill set']";
	   public static final String SKILL_SELECT = "//li[contains(@id, '-EL1')]";
	   public static final String CREATEDSKILL_TXT = "";
	   public static final String CREATEDSOR_TXT = "div.adv-accordion-container.container-fluid div.row.accordion-display-content div.row schedule-of-rate-skillset-list h5";

	   //Edit SOR Skill Set
	   public static final String EDITSKILLSET_HEADER = "";
	   public static final String SKILLSET_EFFECTIVEDATE = "";
	   public static final String SKILL_SEARCH = "schedule-of-rate-skillset-list .k-widget.k-grid .k-grid-header .k-filtercell-wrapper input";

      //Create Operative
	   public static final String OPERATIVE_TABLE = ".k-grid-container .k-grid-content.k-virtual-content";
	   public static final String OPERATIVE_TABLE_CHILD = "tbody tr";


	   //Operative details main page
	   public static final String OPERATIVE_ICON = "//img[@title='Operative']";
	   public static final String OPERATIVE_TITLE = "//app-operative-list-search/h1";
	   public static final String OPERATIVE_DETAILS_TITLE = "//span[@class='ng-tns-c14-1 k-link k-header']";
	   public static final String OPERATIVE_CLOCKNUMBER_TXT = "//input[@formcontrolname='ClockNumber']";
	   public static final String OPERATIVE_CONTRACTOR_DROPDOWN = "//*[@formcontrolname=\"Contractor\"]//span[@role='listbox']";
	   public static final String SELECT_CONTRACTOR_OPTION = "//li[contains(@id, '-AERIALEK')]";

	 //ContractJobNumber List Page
	 		public static final String EDITCONTRACTJOBNUMBER_ICON = "//span[@id='edit_job_num']";

	 		
	 		//Contract job number page
	 		public static final String CONTRACTJOBNUMBER_PAGETITLE = "//span[text()='Contract job number']";
	 		public static final String AUTOMATICPREFIX_TXTBOX = "//*[@id='AutoNoPrefix']";
	 		public static final String MANUALPREFIX_TXTBOX = "//*[@id='ManNoPrefix']";
	 		public static final String AUTOMATICSTART_TXTBOX = "//*[@id='AutoStart']";
	 		public static final String AUTOMATICEND_TXTBOX = "//*[@id='AutoEnd']";
	 		public static final String AUTOMATICNEXT_TXTBOX = "//*[@id='AutoNext']";
	 		public static final String MANUALSTART_TXTBOX = "//*[@id='ManStart']";
	 		public static final String MANUALEND_TXTBOX = "//*[@id='ManEnd']";
	 		public static final String UPDATE_BUTTON = "//button[text()='Update']";

	 		//Contractor variance list page
			public static final String CONTACTORVARIANCE_ACCORDION = "//span[contains (., 'variance')]";
			public static final String CREATETRADEVARIANCE_BTN = "//button[contains (., 'Create')]";
			public static final String CREATETRADEVARIANCE_PAGETITLE = "//h1[text() = 'Create trade variance']";
			public static final String VARIANCETRADESEARCH_TXTBOX = "(//input[@class = 'k-textbox ng-untouched ng-pristine ng-valid'])[3]";
			public static final String EDITTRADEVARIANCE_ICON = "(//span[@class = 'k-icon k-i-pencil k-button k-grid-edit-command'])[2]";
			
			//Trade variance page (Contractor variance)
			public static final String TRADE_DROPDOWN1 = "//span[@class = 'k-i-arrow-s k-icon']";
			public static final String TRADE_SELECTLIST = "//li[contains(., 'CA - Carpenter')]";
			public static final String EFFECTIVEDATE_FIELD = "//*[@id='EffDate']/span/span";
			public static final String EFFECTIVEDATE_SELECT = "//*[contains(@title, 'Friday, January 5, 2018')]";
			
			//Edit Trade variance page (Contractor variance)
			public static final String VARIANCEPERCENTAGE_TXTBOX = "//input[@id='Variance']";
			public static final String ACTIVE_CHKBOX = "//*[@id='k-panelbar-item-default-25']/div/div/div/contractor-variance-trade-variance-list/contractor-variance-trade-variance-edit/div/kendo-dialog/div[2]/div/form/div/div[3]/div/label";
			public static final String UPDATETRADEVARIANCE_BTN = "//button[text() = ' Update ']";

			//Delete Trade variance
			public static final String DELETETRADEVARIANCE_ICON = "//td[5]/span[@class = 'k-icon k-i-delete k-button k-grid-remove-command']";
		
			//DisplayAllContracts List Page
			public static final String CONTRACT_GRID = "//a[text()='Contract']";
			public static final String DESCRIPTION_GRID = "//a[text()='Description']";
			
			//ContractJobCosting List Page
			public static final String EDITCONTRACTJOBCOSTING_ICON = "//span[@class='k-icon k-i-pencil k-button-actions']";

			//Contract job costing page
			public static final String CONTRACTCOSTING_PAGETITLE = "//span[contains(.,'Job')]";
			public static final String COSTINGLEVELJOB_RADIOBTN = "html/body/app-root/div/div/div[2]/accordion-repairs-contract/div/div[3]/div/job-costing/div[2]/form/div[1]/div[3]/div[2]/label";
			public static final String SMV_RADIOBTN = "html/body/app-root/div/div/div[2]/accordion-repairs-contract/div/div[3]/div/job-costing/div[2]/form/div[1]/div[4]/div[2]/label";

		




		






		






	
		




		








				
		
		




		



		
		
		
		
		
		
		
		
		
		
		
}
