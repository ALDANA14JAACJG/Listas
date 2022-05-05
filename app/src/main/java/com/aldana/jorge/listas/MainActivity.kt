package com.aldana.jorge.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aldana.jorge.listas.adaptador.PersonajeAdapter
import com.aldana.jorge.listas.modelo.Personaje
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    lateinit var miRecycler:RecyclerView
    lateinit var listaPersonajes:ArrayList<Personaje>
    lateinit var adaptador:PersonajeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaPersonajes = ArrayList<Personaje>()

        //listaPersonajes.add(Personaje("Goku","https://elcomercio.pe/resizer/pfVziOV4X8Vu9nwknDc-oNItlB8=/1200x900/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/6Y2EDIISGFGVFANEVDCR5LCG34.jpg"))
        //listaPersonajes.add(Personaje("Gohan","https://laverdadnoticias.com/__export/1623265859027/sites/laverdad/img/2021/06/09/gohan_dragon_ball_super_pelicula_2022.jpg_2065693783.jpg"))
        //listaPersonajes.add(Personaje("Goten","https://gruposaedal.com/wp-content/uploads/2022/02/El-pequeno-papel-de-Goten-en-Dragon-Ball-Super-es.jpg"))
        //listaPersonajes.add(Personaje("Vegeta","https://elcomercio.pe/resizer/fb2jKqQ4PoUl4R7SxuFSOLhn5C0=/1200x1200/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/YVDKLIO6LVBB5BF2CN5DYPEYGA.jpg"))
        //listaPersonajes.add(Personaje("Trunks","https://imgmedia.aweita.pe/1200x660/aweita/original/2021/02/23/60356f2474d45a12577dd19c.jpg"))
        //listaPersonajes.add(Personaje("Pan","https://www.cultture.com/pics/2022/01/9-cosas-que-queremos-que-haga-pan-en-dragon-ball-super-super-hero.jpg"))
        //listaPersonajes.add(Personaje("Bra","https://i.ytimg.com/vi/ijxgozZaYgc/mqdefault.jpg"))



        miRecycler= findViewById(R.id.RecyclerPersonajes)

        adaptador = PersonajeAdapter(listaPersonajes)

        miRecycler.adapter= adaptador

        getPersonajes()

        miRecycler.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
                                //GridLayoutManager
                                //StaggeredGridLayoutManager

    }

    fun getPersonajes(){
        val queue = Volley.newRequestQueue(this)
        val url = "https://rickandmortyapi.com/api/character"

        val objectRequest = JsonObjectRequest(Request.Method.GET,url,null,
            Response.Listener { respuesta ->
                val personajesJson = respuesta.getJSONArray("results")

                for (indice in 0..personajesJson.length()-1){
                    val personajeIndJson = personajesJson.getJSONObject(indice)
                    val personaje = Personaje(personajeIndJson.getString("name"),personajeIndJson.getString("image"))
                    listaPersonajes.add(personaje)
                }

                adaptador.notifyDataSetChanged()
            },
            Response.ErrorListener {
                Log.e("PersonajesApi", "Error")
            })

        queue.add(objectRequest)

    }

}