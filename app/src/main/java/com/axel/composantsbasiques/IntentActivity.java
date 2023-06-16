package com.axel.composantsbasiques;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.axel.composantsbasiques.databinding.ActivityIntentBinding;

public class IntentActivity extends AppCompatActivity {
    private int newCount;
    private ActivityIntentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_intent);
        newCount = getIntent().getIntExtra("COUNT", 0);
        binding.setCount("" + newCount);

        registerForContextMenu(binding.menuContextuel);
        binding.menuPopup.setOnClickListener(view -> showPopupMenu(view));
    }

    /**
     * Menu d'activité
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    /*    switch (item.getItemId()){
            case R.id.action_home:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_notification:
                Toast.makeText(this, "Notification", Toast.LENGTH_SHORT).show();
                return true;
        }*/
        if (item.getItemId() == R.id.action_home) {
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.action_notification) {
            Toast.makeText(this, "Notification", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Menu contextuel
     */
    @Override
    public void onCreateContextMenu(
            ContextMenu menu, View v,
            ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_contextuel, menu);
        menu.setHeaderTitle("Mon menu contextuel");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.action_bleu) {
            setBackgroundActivity(IntentActivity.this, R.color.bleu);
        } else if (item.getItemId() == R.id.action_yellow) {
            setBackgroundActivity(IntentActivity.this, R.color.yellow);
        } else if (item.getItemId() == R.id.action_white) {
            setBackgroundActivity(IntentActivity.this, R.color.white);
        }

        return true;
    }

    private void setBackgroundActivity(Context context, int color) {
        binding.container
                .setBackgroundColor(ContextCompat.getColor(context, color));
    }

    /**
     * Menu popup
     */

    private void showPopupMenu(View view){
        PopupMenu popupMenu = new PopupMenu(IntentActivity.this, view);
        MenuInflater menuInflater = popupMenu.getMenuInflater();
        menuInflater.inflate(R.menu.menu_contextuel, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if (item.getItemId() == R.id.action_bleu) {
                    setBackgroundActivity(IntentActivity.this, R.color.bleu);
                } else if (item.getItemId() == R.id.action_yellow) {
                    setBackgroundActivity(IntentActivity.this, R.color.yellow);
                } else if (item.getItemId() == R.id.action_white) {
                    setBackgroundActivity(IntentActivity.this, R.color.white);
                }

                return true;
            }
        });
        popupMenu.show();
    }
}





























