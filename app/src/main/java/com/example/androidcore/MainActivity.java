package com.example.androidcore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.androidcore.framentos_drawer.productos.ProductosActivity;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawerlayout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
// Navigation Drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);



        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawer, toolbar, R.string.drawer_open, R.string. drawer_close);


        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_product )
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
//        navigationView.setNavigationItemSelectedListener(this);
    }

   //Incrustar menu cabecera
    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true; /** true -> el menú ya está visible */
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.accion_compartir) {
            Intent paramView;
            paramView = new Intent("android.intent.action.SEND");
            paramView.setType("text/plain");
//            paramView.putExtra("android.intent.extra.TEXT", "Descarga nuestra app de la PlayStore" +
//                    " \n" + "https://play.google.com/store/apps/details?id=app.product.ditec.ditec_pasajero");
            paramView.putExtra("android.intent.extra.TEXT", "Visita Nuestra Pagina" +
                    " \n" + "https://www.facebook.com/lapamplonera");


            startActivity(Intent.createChooser(paramView, "Comparte Nuestro aplicativo"));
            return true;
        }
//        if (id == R.id.accion_salir) {
//            finish();
//            return true;
//        }
//        if (id == R.id.activity_comunicacion) {
//            startActivity(new Intent(this, Comunicacion1.class));
//            return true;
//        }
//        if (id == R.id.activity_intenciones) {
//            startActivity(new Intent(this, Intenciones.class));
//            return true;
//        }
//        if (id == R.id.activity_multimedia) {
//            startActivity(new Intent(this, Multimedia.class));
//            return true;
//        }
//        if (id == R.id.activity_permisos) {
//            startActivity(new Intent(this, Permisos.class));
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }

    //Ventana de navagacion Lateral
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
        switch (menuItem.getItemId()) {
            case R.id.nav_compartir:
                Intent paramView;
                paramView = new Intent("android.intent.action.SEND");
                paramView.setType("text/plain");
                paramView.putExtra("android.intent.extra.TEXT", "Descarga nuestra app de la PlayStore" +
                        " \n" + "https://play.google.com/store/apps/details?id=app.product.demarktec.alo14_pasajero");
                startActivity(Intent.createChooser(paramView, "Comparte Nuestro aplicativo"));
                break;
            case R.id.nav_salir:
                finish();
                break;

            case R.id.nav_ubicacion:
                startActivity(new Intent(this, Ubicacion.class));
                break;
            case R.id.nav_menu:
                startActivity(new Intent(this, ProductRecyclerView.class));
                break;

            case R.id.nav_product:
                startActivity(new Intent(this, ProductosActivity.class));
                break;
            default:
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(
                R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}