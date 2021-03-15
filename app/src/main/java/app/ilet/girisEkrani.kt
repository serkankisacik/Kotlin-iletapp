package app.ilet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_giris_ekrani.*

class girisEkrani : Fragment() {
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
        return inflater.inflate(R.layout.fragment_giris_ekrani, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parolamiUnuttum.setOnClickListener {
            val action = girisEkraniDirections.actionGirisEkraniToHesabiKurtar()
            Navigation.findNavController(it).navigate(action)
        }

        btnOturumAc.setOnClickListener {

            val email = editTexteposta.text.toString()
            val password = editTextSifre.text.toString()
            if(password !="" && email !=""){
                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener { task->
                    if(task.isSuccessful)
                    {
                        val guncelKullanici = auth.currentUser?.email.toString()

                        Toast.makeText(activity, "Hoş geldin: ${guncelKullanici}Başarı ile giriş yaptınız", Toast.LENGTH_SHORT).show()
                        val action = girisEkraniDirections.actionGirisEkraniToHosgeldiniz()
                        Navigation.findNavController(it).navigate(action)
                    }
                }.addOnFailureListener { exception->
                    Toast.makeText(activity, exception.localizedMessage, Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(activity, "Lütfen istenilen alanları doldurunuz.", Toast.LENGTH_SHORT).show()
            }
        }
    }

}