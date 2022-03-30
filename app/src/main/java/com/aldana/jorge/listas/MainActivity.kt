package com.aldana.jorge.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aldana.jorge.listas.adaptador.PersonajeAdapter
import com.aldana.jorge.listas.modelo.Personaje

class MainActivity : AppCompatActivity() {
    lateinit var miRecycler:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listaPersonajes = ArrayList<Personaje>()

        listaPersonajes.add(Personaje("Goku","https://elcomercio.pe/resizer/pfVziOV4X8Vu9nwknDc-oNItlB8=/1200x900/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/6Y2EDIISGFGVFANEVDCR5LCG34.jpg"))
        listaPersonajes.add(Personaje("Gohan","https://laverdadnoticias.com/__export/1623265859027/sites/laverdad/img/2021/06/09/gohan_dragon_ball_super_pelicula_2022.jpg_2065693783.jpg"))
        listaPersonajes.add(Personaje("Goten","https://gruposaedal.com/wp-content/uploads/2022/02/El-pequeno-papel-de-Goten-en-Dragon-Ball-Super-es.jpg"))
        listaPersonajes.add(Personaje("Vegeta","https://elcomercio.pe/resizer/fb2jKqQ4PoUl4R7SxuFSOLhn5C0=/1200x1200/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/YVDKLIO6LVBB5BF2CN5DYPEYGA.jpg"))
        listaPersonajes.add(Personaje("Trunks","https://imgmedia.aweita.pe/1200x660/aweita/original/2021/02/23/60356f2474d45a12577dd19c.jpg"))
        listaPersonajes.add(Personaje("Pan","https://www.cultture.com/pics/2022/01/9-cosas-que-queremos-que-haga-pan-en-dragon-ball-super-super-hero.jpg"))
        listaPersonajes.add(Personaje("Bra","https://i.ytimg.com/vi/ijxgozZaYgc/mqdefault.jpg"))



        miRecycler= findViewById(R.id.RecyclerPersonajes)

        miRecycler.adapter=PersonajeAdapter(listaPersonajes)
        miRecycler.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
                                //GridLayoutManager
                                //StaggeredGridLayoutManager


    }
}