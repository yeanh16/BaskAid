package droptable.baskaid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yean on 28/02/2018.
 */

public class ItemRecipe {
    private int id;
    private String recipeName;
    private ArrayList<ItemBasket> itemslist; //the items needed for this recipe
    private int imageid;

    public ItemRecipe(int id, String recipeName, ArrayList<ItemBasket> itemslist, int imageid) {
        this.id = id;
        this.recipeName = recipeName;
        this.itemslist = itemslist;
        this.imageid = imageid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public ArrayList<ItemBasket> getItemslist() {
        return itemslist;
    }

    public void setItemslist(ArrayList<ItemBasket> itemslist) {
        this.itemslist = itemslist;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemRecipe recipe = (ItemRecipe) o;

        if (id != recipe.id) return false;
        if (imageid != recipe.imageid) return false;
        if (!recipeName.equals(recipe.recipeName)) return false;
        return itemslist.equals(recipe.itemslist);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + recipeName.hashCode();
        result = 31 * result + itemslist.hashCode();
        result = 31 * result + imageid;
        return result;
    }
}
