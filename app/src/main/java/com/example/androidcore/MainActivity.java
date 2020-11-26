package com.example.androidcore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.androidcore.framentos_drawer.carta.CardFragment;
import com.example.androidcore.framentos_drawer.home.HomeActivity;
import com.example.androidcore.framentos_drawer.productos.ProductosActivity;
import com.google.android.material.navigation.NavigationView;

import java.net.URLEncoder;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
         {

    private AppBarConfiguration mAppBarConfiguration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawerlayout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("Holaa");
       setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawer, toolbar, R.string.drawer_open, R.string. drawer_close);


        drawer.addDrawerListener(toggle);
        toggle.syncState();

        Fragment fragment=new HomeActivity();
        getSupportFragmentManager().beginTransaction().add(R.id.nav_host_fragment,fragment).commit();
        toolbar.setTitle("");

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_product )
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(this);

//        navigationView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
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
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){

        Fragment miFragment=null;
//        ActionBar actionBar = getSupportActionBar();
//        // actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
//        actionBar.setDisplayShowTitleEnabled(true);
//        actionBar.setTitle(mTitle);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
//        setSupportActionBar(toolbar);
//        toolbar.setTitle("escape");

        switch (menuItem.getItemId()) {

            case R.id.nav_salir:
                finish();
//                menuItem.getTitle();

                break;


            case R.id.nav_ubicacion:

                double latitud=-12.139310;
                double longitud= -76.958203;
                String label = "PIZZERIA LA PAMPLONERA";
                String uriBegin ="geo:" +latitud+","+longitud;
                String query = latitud + ","+ longitud+ "("+label+")";
                String encodedQuery = Uri.encode(query);
                String uriString = uriBegin + "?q="+encodedQuery + "&z=16";
                Uri uri = Uri.parse(uriString);
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        uri);
                startActivity(intent);

                break;

            case R.id.nav_carta:
                miFragment=new CardFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,miFragment).commit();

                break;
            case R.id.nav_home:
                miFragment=new HomeActivity();
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,miFragment).commit();
//                toolbar.setTitle(menuItem.getTitle());
           break;

            case R.id.nav_product:
                miFragment=new ProductosActivity();
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,miFragment).commit();
//                toolbar.setTitle(menuItem.getTitle());
               break;
            default:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);


        return true;
    }

    public void Pedidos(View view) {

        PackageManager packageManager = this.getPackageManager();
        Intent i = new Intent(Intent.ACTION_VIEW);
        try {
            String url = "https://api.whatsapp.com/send?phone=" + "+51994057006" + "&text="
                    + URLEncoder.encode("Buen día, me gustaría hacer un pedido ... ", "UTF-8");
            i.setPackage("com.whatsapp");
            i.setData(Uri.parse(url));
            if (i.resolveActivity(packageManager) != null) {
                this.startActivity(i);
            }
            else {
                Toast.makeText(this, "No tiene Whatsapp porfavor instale la app"
                        , Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

             public void OpcionFace(View view) {

                 Intent intent = new Intent(Intent.ACTION_VIEW,
                         Uri.parse("https://www.facebook.com/lapamplonera"));
                 startActivity(intent);

             }

             public void OpcionInstagran(View view) {

                 Intent intent = new Intent(Intent.ACTION_VIEW,
                         Uri.parse("https://www.instagram.com/lapamplonera/"));
                 startActivity(intent);
             }

         }