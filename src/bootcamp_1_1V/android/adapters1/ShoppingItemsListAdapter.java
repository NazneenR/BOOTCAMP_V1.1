package bootcamp_1_1V.android.adapters1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.bootcamp_1_1V.BOOTCAMP_1_1V.R;
import bootcamp_1_1V.android.models1.Product;
import bootcamp_1_1V.android.repositories1.ProductRepository;
import java.util.ArrayList;
import java.util.List;

public class ShoppingItemsListAdapter extends BaseAdapter {

    private final Context context;
    public List<Product> products = new ArrayList<Product>();

    public ShoppingItemsListAdapter(Context context){
        this.context = context;
        ProductRepository productRepository = new ProductRepository();
        products = productRepository.getProducts();
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LinearLayout layout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.cell_layout,null);
        ImageView imageView = (ImageView) layout.findViewById(R.id.imageView);
        TextView textView = (TextView) layout.findViewById(R.id.title);
        Product product = products.get(position);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), product.getDrawable());
        imageView.setImageBitmap(bitmap);
        textView.setText(product.getTitle());
        return layout;
    }
}

