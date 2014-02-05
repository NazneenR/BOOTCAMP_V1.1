package bootcamp_1_1V.android.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import bootcamp_1_1V.android.R;
import bootcamp_1_1V.android.fragments.ProductDetailFragment;
import bootcamp_1_1V.android.models.Product;
import bootcamp_1_1V.android.repositories.ProductRepository;

import java.util.ArrayList;


public class ProductDetailsActivity extends FragmentActivity {

  ArrayList<Product> products;
  private ViewPager viewPager;
  private PagerAdapter pagerAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product_details);

		Bundle extras = getIntent().getExtras();
		String title = extras.getString(getString(R.string.title));
		String description = extras.getString(getString(R.string.description));
		int image = extras.getInt(getString(R.string.imagePath));

    products = (ArrayList<Product>) new ProductRepository().getProducts();

    viewPager = (ViewPager) findViewById(R.id.pager);
    pagerAdapter = new ProductDetailsPagerAdapter(products, getSupportFragmentManager());
    viewPager.setAdapter(pagerAdapter);

    Product product = new Product(title, description, image);
    setCurrentProductInView(product);
	}


  private void setCurrentProductInView(Product product) {
    int index = products.indexOf(product);
    if (index != -1) viewPager.setCurrentItem(index);
  }


  private class ProductDetailsPagerAdapter extends FragmentStatePagerAdapter {
    ArrayList<Product> products;

    public ProductDetailsPagerAdapter(ArrayList<Product> products, FragmentManager supportFragmentManager) {
      super(supportFragmentManager);
      this.products = products;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
      Product product = products.get(position);
      return ProductDetailFragment.create(product);
    }

    @Override
    public int getCount() {
      return products.size();
    }
  }
}
