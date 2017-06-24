package de.hackathon.jove.swipe;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import de.hackathon.jove.R;

class DummyCardsAdapter extends BaseAdapter {

    private List<String> data = new ArrayList<>();
    private Context context;

    DummyCardsAdapter(Context context) {
        this.context = context;

        data.add("0");
        data.add("1");
        data.add("2");
        data.add("3");
        data.add("4");
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.card, parent, false);
        }

        CardView cardView = (CardView) view;
        cardView.setPreventCornerOverlap(true);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Layer type: ", Integer.toString(v.getLayerType()));
                Log.i("Hardware Accel type:", Integer.toString(View.LAYER_TYPE_HARDWARE));
            }
        });
        return cardView;
    }
}