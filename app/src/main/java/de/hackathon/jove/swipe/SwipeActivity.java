package de.hackathon.jove.swipe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Adapter;

import com.daprlabs.aaron.swipedeck.SwipeDeck;

import de.hackathon.jove.R;
import de.hackathon.jove.login.LoginActivity;
import de.hackathon.jove.rest.Callback;
import de.hackathon.jove.rest.RESTClient;
import de.hackathon.jove.rest.tasks.LoginTask;
import de.hackathon.jove.rest.tasks.models.Account;

public class SwipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new RESTClient().execute(new LoginTask(), new Callback<Account>() {
            @Override
            public void onSuccess(Account result) {
                System.out.println(result);
            }

            @Override
            public void onFailed(String error) {

            }
        });

        Intent intent = new Intent(this, LoginActivity.class);
        //startActivity(intent);
        setContentView(R.layout.activity_swipe);

        final SwipeDeck cardStack = (SwipeDeck) findViewById(R.id.swipe_deck);
        assert cardStack != null;

        final Adapter adapter = new DummyCardsAdapter(this);
        cardStack.setAdapter(adapter);
        cardStack.setCallback(new SwipeDeck.SwipeDeckCallback() {
            @Override
            public void cardSwipedLeft(long stableId) {
                Log.i("MainActivity", "card was swiped left, position in adapter: " + stableId);
            }

            @Override
            public void cardSwipedRight(long stableId) {
                Log.i("MainActivity", "card was swiped right, position in adapter: " + stableId);
            }
        });
    }
}
