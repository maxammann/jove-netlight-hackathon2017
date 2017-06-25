package de.hackathon.jove.swipe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Toast;

import com.daprlabs.aaron.swipedeck.SwipeDeck;

import cn.pedant.SweetAlert.SweetAlertDialog;
import de.hackathon.jove.R;
import de.hackathon.jove.login.LoginActivity;

public class SwipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        setContentView(R.layout.activity_swipe);

        final SwipeDeck cardStack = (SwipeDeck) findViewById(R.id.swipe_deck);
        assert cardStack != null;

        findViewById(R.id.message_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SwipeActivity.this, "Not yet implemented", Toast.LENGTH_LONG).show();
            }
        });

        final Adapter adapter = new AllCompaniesCardsAdapter(this);
        cardStack.setAdapter(adapter);
        cardStack.setCallback(new SwipeDeck.SwipeDeckCallback() {
            @Override
            public void cardSwipedLeft(long stableId) {
                Log.i("MainActivity", "card was swiped left, position in adapter: " + stableId);
            }

            @Override
            public void cardSwipedRight(long stableId) {
                if (Math.random() > 0.9) {  // <--- Super scientific machine learning
                    new SweetAlertDialog(SwipeActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("You got a match!")
                            .setContentText("...but we'll ignore it! :) Just in case!")
                            .show();
                }
                Log.i("MainActivity", "card was swiped right, position in adapter: " + stableId);
            }
        });
    }
}
