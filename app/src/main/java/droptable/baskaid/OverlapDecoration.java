package droptable.baskaid;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Class to make cards overlap in recylcler view
 * code from
 * https://stackoverflow.com/questions/32319541/android-recyclerview-overlap-items-card-stacks
 */
public class OverlapDecoration extends RecyclerView.ItemDecoration {

    private final static int horOverlap = -120;

    @Override
    public void getItemOffsets (Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        final int itemPosition = parent.getChildAdapterPosition(view);
        if (itemPosition == 0) {
            return; }
        outRect.set(horOverlap, 0, 0, 0);
    }
}