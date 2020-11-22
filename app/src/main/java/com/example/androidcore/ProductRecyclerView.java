package com.example.androidcore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ProductRecyclerView extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ProductosRecyclerViewAdaptador adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_recycler_view);

        recyclerView = findViewById(R.id.recycler_view);
//        misdatos = new Vector<String>();
//        misdatos.add("123000 Wilson Callisaya");
//        misdatos.add("123000 Pepito Domingez");
//        misdatos.add("123000 Pepito Domingez");
//        misdatos.add("111000 Pedro Martinez");
//        misdatos.add("011000 Paco Pérez");
//        misdatos.add("123000 Pepito Domingez");
//        misdatos.add("123000 Pepito Domingez");
//        misdatos.add("123000 Pepito Domingez");
//        misdatos.add("111000 Pedro Martinez");
//        misdatos.add("011000 Paco Pérez");
//        misdatos.add("123000 Pepito Domingez");
//        misdatos.add("123000 Pepito Domingez");
//        misdatos.add("123000 Pepito Domingez");
//        misdatos.add("111000 Pedro Martinez");
//        misdatos.add("011000 Paco Pérez");
//        misdatos.add("123000 Pepito Domingez");
//        misdatos.add("123000 Pepito Domingez");
//        misdatos.add("123000 Pepito Domingez");
//        misdatos.add("111000 Pedro Martinez");
//        misdatos.add("011000 Paco Pérez");
        adaptador = new ProductosRecyclerViewAdaptador(this,
                ObtenerProductos());
        recyclerView.setAdapter(adaptador);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }


public List<ProductoModelo>  ObtenerProductos(){

    List<ProductoModelo>  listaProducto = new ArrayList<>();
    listaProducto.add(new  ProductoModelo("Pizza1",R.drawable.pizza1 ));
    listaProducto.add(new  ProductoModelo("Pizza2",R.drawable.americana ));
    listaProducto.add(new  ProductoModelo("Pizza3",R.drawable.pan_al_ajo ));
    listaProducto.add(new  ProductoModelo("Pizza4",R.drawable.menu_total));
    return listaProducto;
}

}