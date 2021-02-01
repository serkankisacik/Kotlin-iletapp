package app.ilet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_giris_ekrani.*

class girisEkrani : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_giris_ekrani, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parolamiUnuttum.setOnClickListener {
            val action = girisEkraniDirections.actionGirisEkraniToHesabiKurtar()
            Navigation.findNavController(it).navigate(action)
        }

        btnOturumAc.setOnClickListener {
            val action = girisEkraniDirections.actionGirisEkraniToHosgeldiniz()
            Navigation.findNavController(it).navigate(action)
        }
    }

}