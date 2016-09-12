package com.example.dig.dig_t1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;


public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder> {

    private Context mContext;
    private List<Album> albumList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count, namePerson, infoAboveName, locationPerson, smallReview;
        public ImageView thumbnail, overflow;
        public Button btnComment;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.small_review);
            //count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            // overflow = (ImageView) view.findViewById(R.id.overflow);

            namePerson = (TextView) view.findViewById(R.id.name_person);
            infoAboveName = (TextView) view.findViewById(R.id.date_info);
            locationPerson = (TextView) view.findViewById(R.id.location_info);
            smallReview = (TextView) view.findViewById(R.id.small_review);
            btnComment = (Button) view.findViewById(R.id.btnComment);
        }
    }


    public AlbumsAdapter(Context mContext, List<Album> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Album album = albumList.get(position);
        holder.title.setText(album.getName());
        //holder.count.setText(album.getNumOfSongs() + " songs");

        holder.namePerson.setText("André Bon Odori");
        holder.infoAboveName.setText("Há 3 minutos, 1km longe de você em:");
        holder.locationPerson.setText("Choperia de Flango");
        holder.smallReview.setText("Um ótimo local para passar as férias, descansar e voltar com todo gás para casa.");


        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

        // setando o listener do botão "Comentários'
        holder.btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CommentActivity.class);

                v.getContext().startActivity(intent);
            }
        });


        /*holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //showPopupMenu(holder.overflow);
            }
        });*/
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
/*
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }
*/

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
