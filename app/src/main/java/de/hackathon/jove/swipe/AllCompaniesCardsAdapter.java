package de.hackathon.jove.swipe;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hackathon.jove.R;
import de.hackathon.jove.rest.Callback;
import de.hackathon.jove.rest.HttpContext;
import de.hackathon.jove.rest.tasks.AllCompaniesTask;
import de.hackathon.jove.rest.tasks.models.Company;

class AllCompaniesCardsAdapter extends BaseAdapter {

    private List<Company> data = new ArrayList<>();
    private Context context;

    AllCompaniesCardsAdapter(Context context) {
        this.context = context;

        new AllCompaniesTask().exectute(new HttpContext(), new Callback<List<Company>>() {
            @Override
            public void onSuccess(List<Company> result) {
                AllCompaniesCardsAdapter.this.data = result;
                AllCompaniesCardsAdapter.this.notifyDataSetChanged();
            }

            @Override
            public void onFailed(String error) {
                AllCompaniesCardsAdapter.this.data = new ArrayList<>();
                AllCompaniesCardsAdapter.this.notifyDataSetChanged();
            }
        });
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
        Company item = (Company) getItem(position);
        ((TextView) cardView.findViewById(R.id.title)).setText(item.name);
        ((TextView) cardView.findViewById(R.id.description)).setText(item.description);
        ((TextView) cardView.findViewById(R.id.email)).setText(item.eMail);
        ((TextView) cardView.findViewById(R.id.phone)).setText(item.phone);
        Picasso.with(context).load(item.image).into((ImageView) cardView.findViewById(R.id.card_image));
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