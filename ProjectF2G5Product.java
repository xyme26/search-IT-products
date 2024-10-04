package project.projectf2g5;
public class ProjectF2G5Product {
    
    private String productId;
    private String productName;
    private double productPrice;
    private String productCategory;
    
    private static final ProjectF2G5Product[] initialProducts = 
            new ProjectF2G5Product[20];
    private static int productCount = 0;

    //initialize products
    static {
        addInitialProduct("P001", "Samsung Galaxy S23", 3499.00, "Phone");
        addInitialProduct("P002", "Acer Spin 399", 2799.00, "Laptop");
        addInitialProduct("P003", "Apple iPhone 15", 4299.00, "Phone");
        addInitialProduct("P004", "Logitech MX Master", 569.00, "Mouse");
        addInitialProduct("P005", "Sony WH-1000XM4", 1599.00, "Headset");
        addInitialProduct("P006", "Samsung Galaxy A55", 1999.00, "Phone");
        addInitialProduct("P007", "Logitech POP Key", 489.00, "Keyboard");
    }
    
    //contructor
    public ProjectF2G5Product(String productId, String productName, 
             double productPrice, String productCategory) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
    }
     
    //function that add initial product to the list product
    private static void addInitialProduct(String productId, String productName, 
            double productPrice, String productCategory) {
        initialProducts[productCount++] = new ProjectF2G5Product
        (productId, productName, productPrice, productCategory);
    }

    //getter for initial products array
    public static ProjectF2G5Product[] getInitialProducts() {
        return initialProducts;
    }

    //getter for product id
    public String getProductId() {
        return productId;
    }
    
    //getter for product name
    public String getProductName() {
        return productName;
    }

    //getter for product price
    public double getProductPrice() {
        return productPrice;
    }

    //getter for product category
    public String getProductCategory() {
        return productCategory;
    }

    //setter for product id
    public void setProductId(String productId) {
        this.productId = productId;
    }

    //setter for product name
    public void setProductName(String productName) {
        this.productName = productName;
    }

    //setter for product price
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    //setter for product category
    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public String toString() {
        return String.format("%-8s %-25s %-15s %-10.2f", 
                productId, productName, productCategory, productPrice);
    }
}

