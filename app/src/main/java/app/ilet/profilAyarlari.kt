package app.ilet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_kayit_ekrani.*
import kotlinx.android.synthetic.main.fragment_profil_ayarlari.*


class profilAyarlari : Fragment() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil_ayarlari, container, false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonPDKaydet.setOnClickListener {
            val userName = editTextTextPDkullaniciAdi.text.toString()
            val user = Firebase.auth.currentUser

            val profileUpdates = UserProfileChangeRequest.Builder()
                .setDisplayName(userName)
                .build()

            user!!.updateProfile(profileUpdates)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(activity,"Degişiklikler Başarı ile güncellerndi",Toast.LENGTH_SHORT ).show()

                        val action = profilAyarlariDirections.actionProfilAyarlariToAyarlar()
                        Navigation.findNavController(it).navigate(action)
                    }
                }
        }
        buttonPDIptal.setOnClickListener {

            val action = profilAyarlariDirections.actionProfilAyarlariToAyarlar()
            Navigation.findNavController(it).navigate(action)
        }
    }
}