package raidmahdy.platform.bestpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.google.android.material.navigation.NavigationView
import raidmahdy.platform.bestpractice.R

class MainActivity : AppCompatActivity() {
    private lateinit var tblMakanan : ImageView;
    private lateinit var tblRumah : ImageView;
    private lateinit var tblIbuAnak : ImageView;
    private lateinit var tblKesehatan : ImageView;
    private lateinit var tblExit : ImageView;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val imgMenu = findViewById<ImageView>(R.id.imgMenu)

        val navView = findViewById<NavigationView>(R.id.navDrawer)
        navView.itemIconTintList = null
        imgMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        val navController = Navigation.findNavController(this, R.id.fragment)
        NavigationUI.setupWithNavController(navView,navController)

        val textTitle = findViewById<TextView>(R.id.title)
        navController
            .addOnDestinationChangedListener { controller, destination, arguments ->
                textTitle.text = destination.label
            }

        //image slider
        val imageSlider = findViewById<ImageSlider>(R.id.imageSlider)
        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel("https://images.tokopedia.net/img/cache/500-square/product-1/2020/9/1/70323958/70323958_13a1f456-0769-4486-9a83-a1cede533a61_303_303"))
        imageList.add(SlideModel("https://id-test-11.slatic.net/p/420d1778f4a2af41d48ea786aa9a026c.jpg"))
        imageList.add(SlideModel("https://cf.shopee.co.id/file/b601018c9ccf396075ae7cd634c78dfc"))

        imageSlider.setImageList(imageList, ScaleTypes.FIT)

        //button
        tblMakanan = findViewById<ImageView>(R.id.imageView1)
        tblRumah = findViewById<ImageView>(R.id.imageView2)
        tblIbuAnak = findViewById<ImageView>(R.id.imageView3)
        tblKesehatan = findViewById<ImageView>(R.id.imageView4)

        tblMakanan.setOnClickListener{
            val intent = Intent(this, Makanan::class.java)
            startActivity(intent)
        }

        tblRumah.setOnClickListener{
            val intent = Intent(this, Rumah::class.java)
            startActivity(intent)
        }

        tblIbuAnak.setOnClickListener{
            val intent = Intent(this, IbuAnak::class.java)
            startActivity(intent)
        }

        tblKesehatan.setOnClickListener{
            val intent = Intent(this, Kesehatan::class.java)
            startActivity(intent)
        }
    }
}