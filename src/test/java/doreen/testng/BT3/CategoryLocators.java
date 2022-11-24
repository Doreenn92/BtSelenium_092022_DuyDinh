package doreen.testng.BT3;

public class CategoryLocators {

    public String loginDialog ="//div[@class='container']//h1[starts-with(@class,'h3')]";
    public String copyBtn = "//button[normalize-space()='Copy']";
    public String loginBtn = "//button[normalize-space()='Login']";

    public String activeMenu = "//ul[@id='main-menu']/li[@class='aiz-side-nav-item mm-active']//a[@class='aiz-side-nav-link active']/span[@class='aiz-side-nav-text']";
    public String productsMenu = "//div[@class='aiz-side-nav-wrap']//li//span[normalize-space()='Products']";
    public String categoryMenu = "//span[normalize-space()='Products']/ancestor::li//ul//li//span[normalize-space()='Category']";
    public String pageHeader = "//div[@class='aiz-main-content']//h1";
    public String cardHeader = "//div[@class='aiz-main-content']//h5";
    public String addCategoryBtn = "//span[normalize-space()='Add New category']";

    public String nameCategory = "//input[@id='name']";
    public String parentCategory = "//select[@name='parent_id']/parent::div";
    public String parentCategorySearch = "//label[normalize-space()='Parent Category']/following-sibling::div//div[@class='bs-searchbox']/input";
    public String orderingCategory = "//input[@id='order_level']";
    public String typeCategory = "//label[normalize-space()='Type']/following-sibling::div//select";
    public String bannerBrowserBtn = "//label[contains(text(),'Banner')]/parent::div//div[@class='input-group-prepend']";
    public String selectModelSearch = "//div[@id='aizUploaderModal']//input[@name='aiz-uploader-search']";
    public String uploadSelectedImage = "(//div[@id='aizUploaderModal']//div[starts-with(@class,'aiz-uploader-all')]//div[@class='aiz-file-box'])[1]";
    public String addFileModelBtn = "//div[@id='aizUploaderModal']//button[normalize-space()='Add Files']";
    public String iconBrowserBtn = "//label[contains(text(),'Icon')]/parent::div//div[@class='input-group-prepend']";
    public String metaTitle = "//input[@name='meta_title']";
    public String metaDescription = "//textarea[@name='meta_description']";
    public String filtering = "//label[normalize-space()='Filtering Attributes']/following-sibling::div/div[starts-with(@class,'dropdown')]";
    public String filteringSearch = "//label[normalize-space()='Filtering Attributes']/following-sibling::div//div[@class='bs-searchbox']/input";
    public String saveBtn = "//button[normalize-space()='Save']";
    public String categoriesSearchField = "//input[@id='search']";
    public String categoryResultList = "//tbody/tr/td[2]";
    public String editCategoryBtn = "//tbody/tr[1]//i[@class='las la-edit']";
    public String category1stResult = "//tbody/tr[1]/td[2]";
    public String deleteCategoryBtn = "//tbody/tr[1]//i[@class='las la-trash']";
    public String deleteModalHeader = "//div[@id='delete-modal']//h4";
    public String deleteBtn = "//a[@id='delete-link']";
    public String nothingFound = "//tbody/tr[@class='footable-empty']";
}
