package com.acompany.photoi;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.acompany.photoi.model.Product;

public class ProductSearchActivity extends AppCompatActivity implements ProductSearchActivityFragment.OnListFragmentInteractionListener {

    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        username = savedInstanceState.getString(UsersService.USERNAME).toString();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onListFragmentInteraction(Product product) {

        /*Intent intent = new Intent(this, PaymentRequestService.class);
        intent.putExtra(UsersService.USERNAME,username);
        intent.putExtra(PaymentRequestService.PRODUCT_ID,product.getId());
        startService(intent);*/
    }
}
