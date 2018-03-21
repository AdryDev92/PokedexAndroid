package org.adry.pokedex;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by adry on 21/3/18.
 */

public class PokedexRecyclerViewAdapter extends RecyclerView.Adapter<PokedexRecyclerViewHolder> {

    private static final String LOG_TAG = PokedexRecyclerViewAdapter.class.getSimpleName();

    private List<Photo> mPhotoList;
    private Context mContext;

    public PokedexRecyclerViewAdapter(Context context, List<Photo> photoList) {
        mPhotoList = photoList;
        mContext = context;
    }

    @Override
    public PokedexRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.browse, null, false);

        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        view.setLayoutParams(lp);

        PokedexRecyclerViewHolder pokedexRecyclerViewHolder =
                new PokedexRecyclerViewHolder(view);

        return pokedexRecyclerViewHolder;
    }

    @Override
    public int getItemCount() {
        return (mPhotoList != null ? mPhotoList.size() : 0 );
    }

    @Override
    public void onBindViewHolder(PokedexRecyclerViewHolder holder, int position) {
        // Obtenemos el elemento que va a estar en la posición pedida
        Photo photoItem = mPhotoList.get(position);

        Log.d(LOG_TAG, "Processing: " +photoItem.getTitle() + " -> " + Integer.toString(position));

        // Pintamos el thumbnail en la pantalla
        Picasso.with(mContext).load(photoItem.getImage())
                .error(R.drawable.placeholder)      // En caso de error
                .placeholder(R.drawable.placeholder)// Mientras descarga
                .into(holder.getThumbnail());

        holder.mTitle.setText(photoItem.getTitle());
    }

    public void loadNewData(List<Photo> photos){
        mPhotoList = photos;

        notifyDataSetChanged();
    }

    public Photo getPhoto(int position) {
        return (mPhotoList != null ? mPhotoList.get(position) : null );
    }
}