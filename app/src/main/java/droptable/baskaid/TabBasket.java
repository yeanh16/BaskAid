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
 * {@link TabBasket.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TabBasket#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabBasket extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PAGE = "ARG_PAGE";
    private OnFragmentInteractionListener mListener;

    List<BasketItem> itemsList;
    List<BasketItem> recommendedItemsList;
    RecyclerView recyclerViewBasket;
    RecyclerView recyclerViewRecommended;

    public TabBasket() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    public static TabBasket newInstance(int page) {
        TabBasket fragment = new TabBasket();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
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
        View view = inflater.inflate(R.layout.fragment_tab_basket, container, false);

        //getting the recyclerview from xml
        recyclerViewBasket = (RecyclerView) view.findViewById(R.id.items_recycler_view);
        recyclerViewBasket.setHasFixedSize(true);
        recyclerViewBasket.setLayoutManager(new LinearLayoutManager(this.getContext()));
        //second recylclerview for recommended
        recyclerViewRecommended = (RecyclerView) view.findViewById(R.id.recomendations_recycler_view);
        recyclerViewRecommended.setHasFixedSize(true);
        recyclerViewRecommended.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));

        //initializing the itemsList
        //TODO:in the finished app, this would be populated with items downloaded from the database
        itemsList = new ArrayList<>();
        itemsList.add(new BasketItem(1,"Chicken",4.00, R.drawable.chicken));
        itemsList.add(new BasketItem(2,"Grapes",1.50, R.drawable.grapes));
        itemsList.add(new BasketItem(3,"Noodles",0.70, R.drawable.noodles));
        itemsList.add(new BasketItem(4,"Chicken",4.00, R.drawable.chicken));
        itemsList.add(new BasketItem(5,"Chicken",4.00, R.drawable.chicken));
        itemsList.add(new BasketItem(6,"Chicken",4.00, R.drawable.chicken));
        itemsList.add(new BasketItem(7,"Chicken",4.00, R.drawable.chicken));
        itemsList.add(new BasketItem(8,"Chicken",4.00, R.drawable.chicken));
        itemsList.add(new BasketItem(9,"Chicken",4.00, R.drawable.chicken));
        itemsList.add(new BasketItem(10,"Chicken",4.00, R.drawable.chicken));
        itemsList.add(new BasketItem(11,"Chicken",4.00, R.drawable.chicken));
        itemsList.add(new BasketItem(12,"Chicken",4.00, R.drawable.chicken));
        itemsList.add(new BasketItem(13,"Chicken",4.00, R.drawable.chicken));

        recommendedItemsList = new ArrayList<>();
        recommendedItemsList.add(new BasketItem(13,"Chicken",4.00, R.drawable.chicken));
        recommendedItemsList.add(new BasketItem(13,"Chicken",4.00, R.drawable.chicken));
        recommendedItemsList.add(new BasketItem(13,"Chicken",4.00, R.drawable.chicken));
        recommendedItemsList.add(new BasketItem(13,"Chicken",4.00, R.drawable.chicken));
        recommendedItemsList.add(new BasketItem(13,"Chicken",4.00, R.drawable.chicken));
        recommendedItemsList.add(new BasketItem(13,"Chicken",4.00, R.drawable.chicken));
        recommendedItemsList.add(new BasketItem(13,"Chicken",4.00, R.drawable.chicken));
        recommendedItemsList.add(new BasketItem(13,"Chicken",4.00, R.drawable.chicken));
        recommendedItemsList.add(new BasketItem(13,"Chicken",4.00, R.drawable.chicken));
        recommendedItemsList.add(new BasketItem(13,"Chicken",4.00, R.drawable.chicken));
        recommendedItemsList.add(new BasketItem(13,"Chicken",4.00, R.drawable.chicken));


        //creating recyclerview adapter
        BasketItemAdapter adapterBasket = new BasketItemAdapter(this.getContext(), itemsList);
        RecommendedItemAdapter adapterRecommended = new RecommendedItemAdapter(this.getContext(), recommendedItemsList);

        //setting adapter to recyclerview
        recyclerViewBasket.setAdapter(adapterBasket);
        recyclerViewRecommended.setAdapter(adapterRecommended);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

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
