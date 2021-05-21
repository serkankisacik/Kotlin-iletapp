package app.ilet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_ayarlar.*
import kotlinx.android.synthetic.main.fragment_ilan_detay.*
import kotlinx.android.synthetic.main.fragment_ilan_detay_ekle.*

class ilanDetay : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ilan_detay, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

<<<<<<< HEAD
        imageViewIDKapat.setOnClickListener {
          //  val action = ilanDetayDirections.actionIlanDetayToIlanlar()
          //  Navigation.findNavController(it).navigate(action)
        }
=======
>>>>>>> e79e532142d5e1fa09000a654b63e1073a9a484d
    }
}