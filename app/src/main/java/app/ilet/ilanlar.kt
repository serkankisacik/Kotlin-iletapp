package app.ilet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_acilis.*
import kotlinx.android.synthetic.main.fragment_ilanlar.*

class ilanlar : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ilanlar, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageIlanEkle.setOnClickListener {
            val action = ilanlarDirections.actionİlanlarToİlanKonum()
            Navigation.findNavController(it).navigate(action)
        }
        imageTicketArka.setOnClickListener {
            val action = ilanlarDirections.actionİlanlarToİlanDetay()
            Navigation.findNavController(it).navigate(action)
        }
    }


}