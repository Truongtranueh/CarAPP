package com.example.carapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Switch;

import com.example.carapp.Account.FragmentAccount;
import com.example.carapp.Chat.FragmentChat;
import com.example.carapp.Discount.FragmentDiscount;
import com.example.carapp.Home.FragmentHome;
import com.example.carapp.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomnavmenu.setOnItemSelectedListener(this);
        binding.bottomnavmenu.setSelectedItemId(R.id.home);

    }

    FragmentHome fragmentHome = new FragmentHome();
    FragmentDiscount fragmentDiscount = new FragmentDiscount();
    FragmentChat fragmentChat = new FragmentChat();
    FragmentAccount fragmentAccount = new FragmentAccount();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.framemain,fragmentHome).commit();
                return true;
            case R.id.discount:
                getSupportFragmentManager().beginTransaction().replace(R.id.framemain,fragmentDiscount).commit();
                return true;
            case R.id.chat:
                getSupportFragmentManager().beginTransaction().replace(R.id.framemain,fragmentChat).commit();
                return true;
            case R.id.account:
                getSupportFragmentManager().beginTransaction().replace(R.id.framemain,fragmentAccount).commit();
                return true;
        }
        return false;
    }
}