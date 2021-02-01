package app.ilet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_kayit_ekrani.*

class kayitEkrani : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kayit_ekrani, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnKayitKaydol.setOnClickListener {
            // TODO: Abbas kanka burada giriş yapmayı felan denesene

            val action = kayitEkraniDirections.actionKayitEkraniToKayitTelefon()
            Navigation.findNavController(it).navigate(action)
        }
    }
}