package app.ilet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_acilis.*
import kotlinx.android.synthetic.main.fragment_ayarlar.*

class ayarlar : Fragment() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth

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
        imageViewProfilAyar.setOnClickListener {
            val action = ayarlarDirections.actionAyarlarToProfilAyarlari()
            Navigation.findNavController(it).navigate(action)
        }
        textViewAyar2.setOnClickListener {

        }
        textViewAyar4.setOnClickListener {

        }
        textViewAyar5.setOnClickListener {
            val action = ayarlarDirections.actionAyarlarToKullanimSartlari()
            Navigation.findNavController(it).navigate(action)
        }
        textViewAyar6.setOnClickListener {
            val action = ayarlarDirections.actionAyarlarToGizlilikPolitikasi()
            Navigation.findNavController(it).navigate(action)
        }
        textViewAyar8.setOnClickListener {
            val action = ayarlarDirections.actionAyarlarToSss()
            Navigation.findNavController(it).navigate(action)
        }
        textViewAyar3.setOnClickListener {
            val action = ayarlarDirections.actionAyarlarToİletHakkinda()
            Navigation.findNavController(it).navigate(action)
        }

        textViewCikisYap.setOnClickListener {
            auth.signOut()
            val action = ayarlarDirections.actionAyarlarToMainActivity2()
            Navigation.findNavController(it).navigate(action)
        }

        textViewProfilAyar.setOnClickListener {

            val action = ayarlarDirections.actionAyarlarToProfilAyarlari()
            Navigation.findNavController(it).navigate(action)
        }

    }
}