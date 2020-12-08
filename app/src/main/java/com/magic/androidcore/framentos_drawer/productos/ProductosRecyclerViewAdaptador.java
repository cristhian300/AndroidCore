package com.magic.androidcore.framentos_drawer.productos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.magic.androidcore.R;

import java.util.List;

public class ProductosRecyclerViewAdaptador extends RecyclerView.Adapter<ProductosRecyclerViewAdaptador.ViewHolder> {


    public List<ProductoModelo>  ProductoList;
    private LayoutInflater inflador;
    Context micontext;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



        View v = inflador.from(parent.getContext()).inflate(R.layout.option_producto,null,false);
        //View v = inflador.inflate(R.layout.option_producto, parent, false);
        //entra a la clase ViewHolder
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imgProduct.setImageResource(ProductoList.get(position).getFotoProducto()) ;
        holder.txtProduct.setText(ProductoList.get(position).getNombreProducto());
    }

    @Override
    public int getItemCount() {
        return ProductoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgProduct;
        TextView txtProduct;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.imgProducto);
            txtProduct = itemView.findViewById(R.id.txtProduct);

        }
    }


    public ProductosRecyclerViewAdaptador(List<ProductoModelo> productoList) {


        ProductoList = productoList;
      //  inflador = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      //  micontext=context;
    }
}
