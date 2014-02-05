package bootcamp_1_1V.android.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import bootcamp_1_1V.android.R;
import bootcamp_1_1V.android.models.Product;

public class ProductDetailFragment extends Fragment {

  private String title;
  private String description;
  private int image;

  private ProductDetailFragment(Product product) {
    this.title = product.getTitle();
    this.description = product.getDescription();
    this.image = product.getDrawable();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View inflate = inflater.inflate(R.layout.product_details, container, false);

    TextView imageTitle = (TextView) inflate.findViewById(R.id.product_title);
    imageTitle.setText(title);

    ImageView imageView = (ImageView) inflate.findViewById(R.id.product_image);
    Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), image);
    imageView.setImageBitmap(bitmap);

    TextView issueDescription = (TextView) inflate.findViewById(R.id.product_description);
    issueDescription.setText(description);
    return inflate;
  }

  public static Fragment create(Product product) {
    return new ProductDetailFragment(product);
  }
}
