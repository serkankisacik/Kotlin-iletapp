package app.ilet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.fragment_acilis.*

class acilisFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_acilis, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnUyeol.setOnClickListener {
            val action = acilisFragmentDirections.actionAcilisFragmentToKayitEkrani()

            Navigation.findNavController(it).navigate(action)
       }
        btnGirisYap.setOnClickListener {
            val action = acilisFragmentDirections.actionAcilisFragmentToGirisEkrani()
            Navigation.findNavController(it).navigate(action)
        }
    }

}
