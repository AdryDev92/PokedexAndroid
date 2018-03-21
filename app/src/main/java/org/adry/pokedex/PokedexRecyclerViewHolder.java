package org.adry.pokedex;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by adry on 21/3/18.
 */

public class PokedexRecyclerViewHolder extends RecyclerView.ViewHolder {

    private ImageView mThumbnail;
    public TextView mTitle;

    public PokedexRecyclerViewHolder(View itemView) {
        super(itemView);
        mThumbnail = itemView.findViewById(R.id.imageViewThumbnail);
        mTitle = itemView.findViewById(R.id.textViewTitle);
    }

    public ImageView getThumbnail() {
        return mThumbnail;
    }
}