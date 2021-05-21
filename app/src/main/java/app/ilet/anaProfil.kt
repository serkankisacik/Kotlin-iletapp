package app.ilet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import app.ilet.Model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_acilis.*
import kotlinx.android.synthetic.main.fragment_ana_profil.*
import kotlinx.android.synthetic.main.fragment_profil_ayarlari.*

class anaProfil : Fragment() {
    private lateinit var auth: FirebaseAuth
    var reference: DatabaseReference? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        val currentuser = auth.currentUser

        reference = FirebaseDatabase.getInstance().getReference("users").child(currentuser.uid)

        reference!!.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val user = dataSnapshot.getValue(User::class.java)
                textViewKullaniciAd.text = user!!.username
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
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