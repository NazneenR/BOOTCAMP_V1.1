package bootcamp_1_1V.android.models;

public class Product {

    private int drawable;
    private String title;
    private String description;

    public Product(String title, String description, int drawable) {
        this.title = title;
        this.description = description;
        this.drawable = drawable;
    }


    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public int getDrawable() {
        return drawable;
    }


    @Override
    public String toString() {
        return title;
    }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Product product = (Product) o;

    if (drawable != product.drawable) return false;
    if (!description.equals(product.description)) return false;
    if (!title.equals(product.title)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = drawable;
    result = 31 * result + title.hashCode();
    result = 31 * result + description.hashCode();
    return result;
  }
}
