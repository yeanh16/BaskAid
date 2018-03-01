package droptable.baskaid;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yean on 28/02/2018.
 */

public class AdapterRecipeItem extends RecyclerView.Adapter<AdapterRecipeItem.ViewHolder>{

    private Context mCtx;
    private static List<ItemRecipe> recipesList;
    private static RecyclerView haveRecyclerView;
    private static RecyclerView needRecyclerView;

    public AdapterRecipeItem(Context mCtx, List<ItemRecipe> recipesList) {
        this.mCtx = mCtx;
        this.recipesList = recipesList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_recipe_card, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //get the product of the specified position
        ItemRecipe recipe = recipesList.get(position);
        ArrayList<ItemBasket> neededItems = missingItems(recipe.getItemslist(), TabBasket.itemsList);
        double neededItemsPrice = 0.0;
        for (ItemBasket item : neededItems){
            neededItemsPrice += item.getPrice();
        }

        //bind the data with the viewholder views
        holder.mRecipeName.setText(recipe.getRecipeName());
        holder.mRecipeImage.setImageDrawable(mCtx.getResources().getDrawable((recipe.getImageid())));
        holder.mTextPrice.setText("£" + Double.toString(neededItemsPrice));

        //recyclerview for have
        holder.mHaveRecylcerView.setLayoutManager(new LinearLayoutManager(mCtx, LinearLayoutManager.HORIZONTAL, false));
        holder.mHaveRecylcerView.setHasFixedSize(true);
        holder.haveRecyclerAdapter = new AdapterRecommendedItem(mCtx, commonItems(recipe.getItemslist(), TabBasket.itemsList));
        holder.mHaveRecylcerView.setAdapter(holder.haveRecyclerAdapter);

        //recylclerview for need
        holder.mNeedRecylcerView.setLayoutManager(new LinearLayoutManager(mCtx, LinearLayoutManager.HORIZONTAL, false));
        holder.mNeedRecylcerView.setHasFixedSize(true);
        holder.needRecyclerAdapter = new AdapterRecommendedItem(mCtx, neededItems);
        holder.mNeedRecylcerView.setAdapter(holder.needRecyclerAdapter);

    }

    //method that returns common items from two arrays
    public static ArrayList<ItemBasket> commonItems(ArrayList<ItemBasket> itemlist1, ArrayList<ItemBasket> itemlist2){
        ArrayList<ItemBasket> common = new ArrayList<>();
        for (ItemBasket item : itemlist1){
            if (itemlist2.contains(item)){
                common.add(item);}
        }
        return common;
    }

    //method that returns items that are missing in itemlist1 from itemlist2
    public static ArrayList<ItemBasket> missingItems(ArrayList<ItemBasket> itemlist1, ArrayList<ItemBasket> itemlist2){
        ArrayList<ItemBasket> missing = new ArrayList<>();
        for (ItemBasket item : itemlist1){
            if (!itemlist2.contains(item)) {
                missing.add(item);}
        }
        return missing;
    }

    @Override
    public int getItemCount() {
        return recipesList.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mRecipeName;
        private ImageView mRecipeImage;
        private RecyclerView mHaveRecylcerView;
        private AdapterRecommendedItem haveRecyclerAdapter;
        private RecyclerView mNeedRecylcerView;
        private AdapterRecommendedItem needRecyclerAdapter;
        private TextView mTextPrice;


        public ViewHolder(View recipeItemView) {
            super(recipeItemView);
            Context context = recipeItemView.getContext();
            mRecipeName = recipeItemView.findViewById(R.id.textRecipeName);
            mRecipeImage = recipeItemView.findViewById(R.id.recipe_image);
            mHaveRecylcerView = recipeItemView.findViewById(R.id.have_items_recycler_view);
            mNeedRecylcerView = recipeItemView.findViewById(R.id.need_items_recycler_view);
            mTextPrice = recipeItemView.findViewById(R.id.textViewRecipePrice);
        }


    }

}
