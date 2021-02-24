package app.ilet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_acilis.*
import kotlinx.android.synthetic.main.fragment_ayarlar.*

class ayarlar : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ayarlar, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageViewSart.setOnClickListener {
            val action = ayarlarDirections.actionAyarlarToKullanimSartlari()
            Navigation.findNavController(it).navigate(action)
        }
        imageViewGizlilik.setOnClickListener {
            val action = ayarlarDirections.actionAyarlarToGizlilikPolitikasi()
            Navigation.findNavController(it).navigate(action)
        }
        imageViewSSS.setOnClickListener {
            val action = ayarlarDirections.actionAyarlarToSss()
            Navigation.findNavController(it).navigate(action)
        }
        imageViewHakkimizda.setOnClickListener {
            val action = ayarlarDirections.actionAyarlarToİletHakkinda()
            Navigation.findNavController(it).navigate(action)
        }
    }
}