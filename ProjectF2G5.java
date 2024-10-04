package project.projectf2g5;
import java.util.Scanner;
public class ProjectF2G5 {
    
    private static final ProjectF2G5Product[] products = new ProjectF2G5Product[100];
    private static int count=0;

    static {
        ProjectF2G5Product[] initialProducts = ProjectF2G5Product.getInitialProducts();
        for (ProjectF2G5Product product : initialProducts) {
            if (product != null) {
                products[count++] = product;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       
        //loop for user enter selection
        while(true){
            System.out.println("\nMenu selection:");
            System.out.println("1. Add Product");
            System.out.println("2. Search Product");
            System.out.println("3. List Product");
            System.out.print("Enter selection (1/2/3) or 0 to exit: ");
            int selection=input.nextInt();
            input.nextLine();

            switch(selection){
                case 0:
                    System.out.println("Thanks for using this system.\nHope you have a nice day!");
                    return;
                case 1:
                    addProduct(input);
                    break;
                case 2:
                    searchProduct(input);
                    break;
                case 3:
                    listProducts();
                    break;
                default:
                    System.out.println("Invalid selection, please enter valid selection.");
            }
        }
    }

    //function of adding product
    public static void addProduct(Scanner input) {
        
        System.out.print("Enter product Id to add (exp:P012): ");
        String productId = input.nextLine();
        System.out.print("Enter product name: ");
        String productName = input.nextLine();
        
        String productCategory = "";
        double productPrice = 0.00;
        
        while(true){
            System.out.println("\nProduct category:");
            System.out.println("1. Laptop");
            System.out.println("2. Phone");
            System.out.println("3. Headset");
            System.out.println("4. Mouse");
            System.out.println("5. Keyboard");
            System.out.print("Enter the product category number: ");
            int categoryNumber = input.nextInt();
            input.nextLine(); 

            switch (categoryNumber) {
                case 1:
                    productCategory = "Laptop";
                    break;
                case 2:
                    productCategory = "Phone";
                    break;
                case 3:
                    productCategory = "Headset";
                    break;
                case 4:
                    productCategory = "Mouse";
                    break;
                case 5:
                    productCategory = "Keyboard";
                    break;
                default:
                    System.out.println("Invalid category number. Please enter number 1-5.");
                    continue;
            }
            break;
        }
        
        while(true){
            System.out.print("Enter product price (exp:12.50) in RM : ");
            productPrice=input.nextDouble();
            if(productPrice>=0){                
                break; 
            } else{
                System.out.println("Invalid input. Please enter valid input.");
                input.nextLine(); 
                }
            }
        
        ProjectF2G5Product product = new ProjectF2G5Product(productId, productName, productPrice, productCategory);
        products[count++] = product;
        System.out.println("Product added successfully!");
    }
    

    //function for searching product
    public static void searchProduct(Scanner input) {
        while(true){
            System.out.println("\nSearch by:");
            System.out.println("1. Id");
            System.out.println("2. Name");
            System.out.println("3. Category");
            System.out.print("Enter selection you want to search (1/2/3): ");
            int searchSelection = input.nextInt();
            input.nextLine();
            
            boolean validSelect = true;
                switch(searchSelection){
                    case 1:
                        System.out.print("Enter product Id to search (exp:P002): ");
                        String productId = input.nextLine();
                        searchId(productId);
                        break;
                    case 2:
                        System.out.print("Enter product name to search (exp:Samsung Galaxy S23) : ");
                        String productName = input.nextLine();
                        searchName(productName);
                        break;
                    case 3:
                        System.out.print("Enter product category to search (exp:Phone/Laptop) : ");
                        String productCategory = input.nextLine();
                        searchCategory(productCategory);
                        break;
                    default:
                        System.out.println("Invalid selection, please enter valid selection.");
                        validSelect=false;
            }
                if (validSelect) {
                break; // Exit the while loop if a valid selection was made
        }
    }
}

    //search by ID
    public static void searchId(String productId) {
        boolean found = false;

        System.out.printf("\n%-5s %-8s %-25s %-15s %-10s\n", "No.", "Id", "Name", "Category", "Price");
        System.out.println("------------------------------------------------------------------");
        for (int i = 0; i < count; i++) {
            if (products[i].getProductId().equalsIgnoreCase(productId)) {
                System.out.printf("%-5d %s\n", i + 1, products[i]);
                found = true;
            }
        }
        System.out.println("==================================================================");
        if (!found) {
            System.out.println("No product found with the Id.");
        }
    }
    
    //function for search by name
    public static void searchName(String productName) {
        boolean found = false;

        System.out.printf("\n%-5s %-8s %-25s %-15s %-10s\n", "No.", "Id", "Name", "Category", "Price");
        System.out.println("------------------------------------------------------------------");
        for (int i = 0; i < count; i++) {
        if (products[i].getProductName().equalsIgnoreCase(productName)) {
                System.out.printf("%-5d %s\n", i + 1, products[i]);
                found = true;
            }
        }
        System.out.println("==================================================================");
        if (!found) {
            System.out.println("No product found with the name.");
        }
    }
    
    //function search by category
    public static void searchCategory(String productCategory) {
        boolean found = false;
        System.out.printf("\n%-5s %-8s %-25s %-15s %-10s\n", "No.", "Id", "Name", "Category", "Price");
        System.out.println("------------------------------------------------------------------");
        for (int i = 0; i < count; i++) {
            if (products[i].getProductCategory().equalsIgnoreCase(productCategory)) {
                System.out.printf("%-5d %s\n", i + 1, products[i]);
                found = true;
            }
        }
        System.out.println("==================================================================");
        if (!found) {
            System.out.println("No product found in the category.");
        }
    }
    
    //function that listing the products
    public static void listProducts() {
        System.out.printf("\n%-5s %-8s %-25s %-15s %-10s\n", "No.", "Id", "Name", "Category", "Price");
        System.out.println("------------------------------------------------------------------");
                for (int i = 0; i < count; i++) {
            System.out.printf("%-5d %s\n", i + 1, products[i]);
        }
    System.out.println("==================================================================");
    }
}
