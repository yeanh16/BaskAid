package droptable.baskaid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DecimalFormat;

import java.util.List;

/**
 * Created by Yean on 17/02/2018.
 * An adapter for viewing basket items with the recycler view
 */

public class BasketItemAdapter extends RecyclerView.Adapter<BasketItemAdapter.ViewHolder> {

    private Context mCtx;
    private List<BasketItem> itemList;

    public BasketItemAdapter(Context mCtx, List<BasketItem> itemList) {
        this.mCtx = mCtx;
        this.itemList = itemList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_basket_item, null);
        return new ViewHolder(view);

//        // create a new view
//        TextView v = (TextView) LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.fragment_tab_basket, parent, false);
//        // set the view's size, margins, paddings and layout parameters
//        ViewHolder vh = new ViewHolder(v);
//        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //get the product of the specified position
        BasketItem item = itemList.get(position);

        //bind the sata with the viewholder views
        holder.mTextView.setText(item.getTitle());
        holder.mImageView.setImageDrawable(mCtx.getResources().getDrawable((item.getImageid())));
        DecimalFormat decim = new DecimalFormat("0.00");
        holder.mPriceView.setText("£" + Double.toString(Double.parseDouble(decim.format(item.getPrice()))));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;
        private ImageView mImageView;
        private TextView mPriceView;

        public ViewHolder(View basketItemView) {
            super(basketItemView);
            mTextView = basketItemView.findViewById(R.id.textViewTitle);
            mImageView = basketItemView.findViewById(R.id.imageView1);
            mPriceView = basketItemView.findViewById(R.id.textViewPrice);
        }


    }
}
