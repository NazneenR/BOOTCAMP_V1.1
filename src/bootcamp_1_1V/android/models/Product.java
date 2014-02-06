package bootcamp_1_1V.android.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable{

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

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(title);
    dest.writeString(description);
    dest.writeInt(drawable);
  }

  public Product(Parcel in){
    this.title = in.readString();
    this.description = in.readString();
    this.drawable = in.readInt();
  }

  public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
    public Product createFromParcel(Parcel in) {
      return new Product(in);
    }

    public Product[] newArray(int size) {
      return new Product[size];
    }
  };
}
