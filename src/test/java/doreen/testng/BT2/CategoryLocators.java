package doreen.testng.BT2;

public class CategoryLocators {

    public String copyBtn = "//button[normalize-space()='Copy']";
    public String loginBtn = "//button[normalize-space()='Login']";
    public String productsMenu = "//div[@class='aiz-side-nav-wrap']//li//span[normalize-space()='Products']";
    public String categoryMenu = "//span[normalize-space()='Products']/ancestor::li//ul//li//span[normalize-space()='Category']";
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

}
