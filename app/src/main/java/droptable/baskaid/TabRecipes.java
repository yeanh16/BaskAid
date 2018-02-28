package droptable.baskaid;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TabRecipes.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TabRecipes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabRecipes extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PAGE = "ARG_PAGE";
    private OnFragmentInteractionListener mListener;
    private List<ItemRecipe> recipesList;
    private RecyclerView recipesRecyclerView;

    public TabRecipes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    public static TabRecipes newInstance(int page) {
        TabRecipes fragment = new TabRecipes();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_recipes, container, false);

        //getting the recyclerview from xml
        recipesRecyclerView = (RecyclerView) view.findViewById(R.id.recipes_recycler_view);
        recipesRecyclerView.setHasFixedSize(true);
        recipesRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        //initializing the itemsList
        //TODO:in the finished app, this would be populated with recipes downloaded from the database
        recipesList = new ArrayList<>();
        ArrayList<ItemBasket> itemsList = new ArrayList<ItemBasket>(); //this is for the recipe
        itemsList.add(new ItemBasket(1,"Beef Mince", 2.00, R.drawable.beef_mince));
        itemsList.add(new ItemBasket(2,"fusilli", 0.60, R.drawable.fusilli));
        itemsList.add(new ItemBasket(3,"Bolognaise", 1.50, R.drawable.bolognaise));
        recipesList.add(new ItemRecipe(1, "Pasta Bolognaise", itemsList, R.drawable.pasta_bolog));

        //creating recyclerview adapter
        AdapterRecipeItem adapterRecipe = new AdapterRecipeItem(this.getContext(), recipesList);

        //setting adapter to recyclerview
        recipesRecyclerView.setAdapter(adapterRecipe);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
