package com.example.michelpatty_20411110_projectakhir

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private var listlagu = mutableListOf <itemData>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logout = findViewById<ImageButton>(R.id.btn_logout)
        logout.setOnClickListener {
            logout()
        }

//Lagu R&B
        val RecyclerView = findViewById<RecyclerView>(R.id.lagurnbRV)

        listlagu = ArrayList()

        listlagu.add(itemData(R.drawable.theweeknd, "After Hours", "The Weeknd",R.drawable.theweeknd2, "Is There Someone Else","The Weeknd", R.drawable.theweeknd3, "Blinding Light", "The Weekend", R.drawable.theweeknd, "Save Your Tears", "The Weekend & Ariana Grande"))
        listlagu.add(itemData(R.drawable.drake, "Scorpion", "Drake",R.drawable.drake2, "God's Plan","Drake", R.drawable.drake3, "Hotline Bling", "Drake", R.drawable.drake, "Laugh Now Cry Later", "Drake ft. Lil Durk"))
        listlagu.add(itemData(R.drawable.postmalone, "Stoney", "Post Malone",R.drawable.postmalone2, "Circles","Post Malone", R.drawable.postmalone3, "GoodByes", "Post Malone ft. Youngthug", R.drawable.postmalone, "Sunflower", "Post Malone, Swaelee"))
        listlagu.add(itemData(R.drawable.akon, "Trouble", "Akon",R.drawable.akon2, "Be With You","Akon", R.drawable.akon3, "Lonely", "Akon", R.drawable.akon, "Let It Go", "Akon & Wiz Khalifa"))
        listlagu.add(itemData(R.drawable.brunomars,"24K Magic", "Bruno Mars",R.drawable.brunomars2, "Too Good To Say Goodbye","Bruno Mars", R.drawable.brunomars3, "Versace On The Floor", "Bruno Mars", R.drawable.brunomars, "When I Was Your Man", "Bruno Mars"))

        RecyclerView.setHasFixedSize(true)
        RecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)

        RecyclerView.adapter = MyAdapter(this, listlagu){
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }

//Lagu Indo Pop
        val RecyclerView1 = findViewById<RecyclerView>(R.id.laguindopopRV)
        listlagu = ArrayList()

        listlagu.add(itemData(R.drawable.lyodra, "Lyodra", "Lyodra",R.drawable.lyodra2, "Egois","Lyodra", R.drawable.lyodra2, "Sang Dewi", "Lyodra", R.drawable.lyodra2, "Pesan Terakhir", "Lyodra"))
        listlagu.add(itemData(R.drawable.tiaraandini, "Tiara Andini", "Tiara Andini",R.drawable.tiaraandini2, "Janji Setia","Tiara Andini", R.drawable.tiaraandini3, "Usai", "Tiara Andini", R.drawable.tiaraandini2, "Merasa Indah", "Tiara Andini"))
        listlagu.add(itemData(R.drawable.mahalini, "Fabula", "Mahalini",R.drawable.mahalini2, "Kisah Sempurna","Mahalini", R.drawable.mahalini3, "Melawan Restu", "Mahalini", R.drawable.mahalini2, "Sisa Rasa", "Mahalini"))
        listlagu.add(itemData(R.drawable.ziva, "Magnoliya", "Ziva",R.drawable.ziva2, "Terlukis Indah","Ziva & Rizky Febian", R.drawable.ziva3, "Pilihan Terbaik", "Ziva", R.drawable.ziva2, "Peri Cintaku", "Ziva"))
        listlagu.add(itemData(R.drawable.glenn,"Kembali", "Glenn Fredly",R.drawable.glenn2, "Sedih Tak Berujung","Glenn Fredly", R.drawable.glenn3, "Kasih Putih", "Glenn Fredly", R.drawable.glenn, "Sekali Ini Saja", "Glenn Fredly"))

        RecyclerView1.setHasFixedSize(true)
        RecyclerView1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)

        RecyclerView1.adapter = MyAdapter(this, listlagu){
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }

//Lagu EDM
        val RecyclerView2 = findViewById<RecyclerView>(R.id.laguedmRV)
        listlagu = ArrayList()

        listlagu.add(itemData(R.drawable.diplo, "Revolution", "Diplo",R.drawable.diplo2, "Revolution","Diplo ft Faustix & Kai", R.drawable.diplo3, "Mind", "Diplo & Skrillex", R.drawable.diplo4, "Take U There", "Diplo ft Kiesza"))
        listlagu.add(itemData(R.drawable.djsnake,"Encore", "Dj Snake",R.drawable.djsnake2, "Turn Down For What","Dj Snake, Lil John", R.drawable.djsnake2, "Lean On", "Dj Snake & Major Lazer", R.drawable.djsnake2, "Propaganda", "Dj Snake"))
        listlagu.add(itemData(R.drawable.skrillex, "Recess", "Skrillex",R.drawable.skrillex2, "Bangarang","Skrillex ftt Sirah", R.drawable.skrillex3, "Make It Bun Dem", "Skrillex & Damian", R.drawable.skrillex2, "Purple Lamborghini", "Skrillex & Rick Ross"))
        listlagu.add(itemData(R.drawable.martingarrix, "Martin Garrix", "Martin Garrix",R.drawable.martingarrix2, "Animal","Marin Garrix", R.drawable.martingarrix3, "There For You", "Marin Garrix & Troyne", R.drawable.martingarrix4, "Scared To Be Lonely", "Marin Garrix & Dua Lipa"))
        listlagu.add(itemData(R.drawable.yellowclaw, "New Blood", "Yellow Claw",R.drawable.yellowclaw2, "Till It Hurts","Yellow Claw ft Ayden", R.drawable.yellowclaw3, "Shotgun", "Yellow Claw ft Rochelle", R.drawable.yellowclaw4, "Both Of Us", "STORi"))

        RecyclerView2.setHasFixedSize(true)
        RecyclerView2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)

        RecyclerView2.adapter = MyAdapter(this, listlagu){
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }

//Lagu RAP
        val RecyclerView3 = findViewById<RecyclerView>(R.id.lagurapRV)
        listlagu = ArrayList()

        listlagu.add(itemData(R.drawable.travisscott, "Astroworld", "Travis Scott",R.drawable.travis2, "Butterfly Effect","Travis Scott", R.drawable.travis3, "Highest In The Room", "Travis Scott", R.drawable.travis4, "Sicko Mode", "Travis Scott ft. Drake"))
        listlagu.add(itemData(R.drawable.tyga, "Last King", "Tyga",R.drawable.tyga2, "Taste","Tyga ft Offset", R.drawable.tyga3, "Girls Have Fun", "Tyga ft G-Eazy", R.drawable.tyga4, "Kream", "Tyga ft Iggy Azalea"))
        listlagu.add(itemData(R.drawable.eminem,"MTBMB", "Eminem",R.drawable.eminem2, "Godzilla","Eminem", R.drawable.eminem3, "Venom", "Eminem ft Juice Wrld", R.drawable.eminem4, "Without Me", "Eminem"))
        listlagu.add(itemData(R.drawable.kendricklamar, "Damn", "Kendrick Lamar",R.drawable.kendricklamar2, "Humble","Kendrick Lamar", R.drawable.kendricklamar3, "N95", "Kendrick Lamar", R.drawable.kendricklamar2, "Love", "Kendrick Lamar"))
        listlagu.add(itemData(R.drawable.migos, "Culture II", "Migos",R.drawable.migos2, "Ba and Boujee","Migos ft LUF", R.drawable.migos3, "Walk It Talk It", "Migos ft Drake", R.drawable.migos4, "Narco", "Migos"))

        RecyclerView3.setHasFixedSize(true)
        RecyclerView3.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)

        RecyclerView3.adapter = MyAdapter(this, listlagu){
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }

    }
    //    Function signOut dari akun dan berpindah halaman dengan memangggil function navigateToLoginPage
    private fun logout() {
        FirebaseAuth.getInstance().signOut()
        navigateToLoginPage()
    }

    //    Function untuk berpindah halaman
    private fun navigateToLoginPage() {
        val intent = Intent(this, Login::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}