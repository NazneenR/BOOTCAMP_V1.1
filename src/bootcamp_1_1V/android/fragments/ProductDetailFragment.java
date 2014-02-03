package bootcamp_1_1V.android.fragments;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import bootcamp_1_1V.android.R;

public class ProductDetailFragment extends Fragment {

  private String title;
  private String description;
  private int image;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View inflate = inflater.inflate(R.layout.product_details, container);
    return inflate;
  }

  public void setData(String title, String description, int image) {

    this.title = title;
    this.description = description;
    this.image = image;

    TextView imageTitle = (TextView) getActivity().findViewById(R.id.product_title);
    imageTitle.setText(title);

    ImageView imageView = (ImageView) getActivity().findViewById(R.id.product_image);
    Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), image);
    imageView.setImageBitmap(bitmap);

    TextView issueDescription = (TextView) getActivity().findViewById(R.id.product_description);
    issueDescription.setText(description);
    
  }
}
