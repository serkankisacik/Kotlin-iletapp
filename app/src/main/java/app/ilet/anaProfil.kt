package app.ilet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_acilis.*
import kotlinx.android.synthetic.main.fragment_ana_profil.*

class anaProfil : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ana_profil, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonDuzenle.setOnClickListener {
            val action = anaProfilDirections.actionAnaProfilToAyarlar()
            Navigation.findNavController(it).navigate(action)
        }
        imageViewKullaniciFotograf.setOnClickListener {
            val action = anaProfilDirections.actionAnaProfilToProfilFotografi()
            Navigation.findNavController(it).navigate(action)
        }
        textViewGeziDurum.setOnClickListener {
            val action = anaProfilDirections.actionAnaProfilToYolda()
            Navigation.findNavController(it).navigate(action)
        }
    }
}