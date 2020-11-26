package com.example.androidcore.framentos_drawer.productos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidcore.ProductoModelo;
import com.example.androidcore.ProductosRecyclerViewAdaptador;
import com.example.androidcore.R;

import java.util.ArrayList;
import java.util.List;

public class ProductosActivity extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ProductosRecyclerViewAdaptador adaptador;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_productos, container, false);
        recyclerView =(RecyclerView)  vista.findViewById(R.id.recycler_view);

       layoutManager = new LinearLayoutManager(getContext());
       recyclerView.setLayoutManager(layoutManager);

       adaptador = new ProductosRecyclerViewAdaptador(  ObtenerProductos());
       recyclerView.setAdapter(adaptador);
        return vista;
    }


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProductosActivity() {
        // Required empty public constructor
    }


    public List<ProductoModelo> ObtenerProductos() {

        List<ProductoModelo> listaProducto = new ArrayList<>();

        listaProducto.add(new ProductoModelo("Pizza Hawaiana", R.drawable.pizza_hawaiana));
        listaProducto.add(new ProductoModelo("Pizza Americana", R.drawable.pizza_americana));
        listaProducto.add(new ProductoModelo("Pizza Vegetariana", R.drawable.pizza_vegetariana));
        listaProducto.add(new ProductoModelo("Pizza Napolitana", R.drawable.pizza1));
        listaProducto.add(new ProductoModelo("Pizza Suprema", R.drawable.americana));
        listaProducto.add(new ProductoModelo("Pan al ajo", R.drawable.pan_al_ajo));

        return listaProducto;
    }
}