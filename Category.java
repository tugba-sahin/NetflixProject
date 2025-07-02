public class Category {
    private int id;
    private String categoryCode;
    private String categoryName;

    public Category(int id, String categoryCode, String categoryName) {
        this.id = id;
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    // Setters
    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category ID: " + id + ", Code: " + categoryCode + ", Name: " + categoryName;
    }
}