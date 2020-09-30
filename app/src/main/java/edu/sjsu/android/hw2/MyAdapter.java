package edu.sjsu.android.hw2;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private static final int INTENT_GET_MSG = 1;
    private List<String>values;
    private List<Integer>imageValues;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder{
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView imgHeader;
        public View layout;
        public ViewHolder(View v){
            super(v);
            layout=v;
            txtHeader=(TextView)v.findViewById(R.id.penguinName);
            imgHeader=(ImageView)v.findViewById(R.id.icon);
        }
    }
    public void add(int position,String item) {
        values.add(position,item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<String> myDataset, List<Integer> imgData) {
        values = myDataset;
        imageValues = imgData;
    }
    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        //set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // -get element from your dataset at this position
        // -replace the contents of the view with that element
        final String name = values.get(position);
        holder.txtHeader.setText(name);
        holder.imgHeader.setImageResource(imageValues.get(position));
        holder.txtHeader.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View view) {
                if (position == 4)
                {
                    if (position == 4)
                    {
                        AlertDialog aD = new AlertDialog.Builder(view.getContext()).create();
                        aD.setTitle(view.getContext().getString(R.string.warningheader));
                        aD.setMessage(view.getContext().getString(R.string.warningmessage));
                        aD.setButton(AlertDialog.BUTTON_NEGATIVE, "NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                        aD.setButton(AlertDialog.BUTTON_POSITIVE, "YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent detailIntent = new Intent(view.getContext(), DetailActivity.class);
                                detailIntent.putExtra("name", name);
                                detailIntent.putExtra("picture", imageValues.get(position));
                                detailIntent.putExtra("desc", position);
                                view.getContext().startActivity(detailIntent);

                            }
                        });
                        aD.show();
                    }
                }
                else {
                    Intent detailIntent = new Intent(view.getContext(), DetailActivity.class);
                    detailIntent.putExtra("name", name);
                    detailIntent.putExtra("picture", imageValues.get(position));
                    detailIntent.putExtra("desc", position);
                    view.getContext().startActivity(detailIntent);
                }
            }
        });
        holder.imgHeader.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View view) {

                if (position == 4)
                {
                    AlertDialog aD = new AlertDialog.Builder(view.getContext()).create();
                    aD.setTitle(view.getContext().getString(R.string.warningheader));
                    aD.setMessage(view.getContext().getString(R.string.warningmessage));
                    aD.setButton(AlertDialog.BUTTON_NEGATIVE, "NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    aD.setButton(AlertDialog.BUTTON_POSITIVE, "YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent detailIntent = new Intent(view.getContext(), DetailActivity.class);
                            detailIntent.putExtra("name", name);
                            detailIntent.putExtra("picture", imageValues.get(position));
                            detailIntent.putExtra("desc", position);
                            view.getContext().startActivity(detailIntent);

                        }
                    });
                    aD.show();
                }
                else {
                    Intent detailIntent = new Intent(view.getContext(), DetailActivity.class);
                    detailIntent.putExtra("name", name);
                    detailIntent.putExtra("picture", imageValues.get(position));
                    detailIntent.putExtra("desc", position);
                    view.getContext().startActivity(detailIntent);
                }

            }
        });

    }
    //Return the size of your dataset (invoker by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }
}


