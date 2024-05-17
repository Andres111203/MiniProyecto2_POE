package Windows;

// Clase producto
public class Product {
    private String name;
    private String description;
    private String price;
    private String quantity;
    private String material;
    private String use;
    private String category;

    // Constructor
    public Product(String name, String description, String price, String quantity, String material, String use, String category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.material = material;
        this.use = use;
        this.category = category;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getMaterial() {
        return material;
    }

    public String getUse() {
        return use;
    }

    public String getCategory() {
        return category;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Override toString() method for easy printing
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", quantity='" + quantity + '\'' +
                ", material='" + material + '\'' +
                ", use='" + use + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
