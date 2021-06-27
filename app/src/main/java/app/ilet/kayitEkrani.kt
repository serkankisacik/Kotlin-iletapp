package app.ilet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import app.ilet.Model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_kayit_ekrani.*

class kayitEkrani : Fragment() {
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
        return inflater.inflate(R.layout.fragment_kayit_ekrani, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnKayitKaydol.setOnClickListener {

            val username = editTextKayitKullaniciAdi.text.toString()
            val email= editTextKayitEposta.text.toString()
            val password = editTextKayitSifre.text.toString()

            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
                if (task.isSuccessful){
                    val firebaseUser = auth.currentUser!!
                    val userid = firebaseUser!!.uid
                    var user = User(userid,username, email)
                    val database = FirebaseDatabase.getInstance()
                    val myRef = database.getReference("users")
                    myRef.child(userid).setValue(user)
                    Toast.makeText(activity, "Kullanıcı başarı ile oluşturuldu", Toast.LENGTH_SHORT).show()
                    val action = kayitEkraniDirections.actionKayitEkraniToKayitTelefon()
                    Navigation.findNavController(it).navigate(action)
                }
            }.addOnFailureListener { exception->
                Toast.makeText(activity, exception.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }

    }
}