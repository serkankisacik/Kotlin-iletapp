package app.ilet

import android.content.ContentValues.TAG
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.fragment_ilan_detay_ekle.*
import kotlinx.android.synthetic.main.fragment_ilan_durak_ekle.*
import kotlinx.android.synthetic.main.fragment_ilan_onay.*
import java.util.*


class ilanOnay : Fragment() {

    var secilenGorsel : Uri? = null
    var secilenBitmap : Bitmap? = null
    private lateinit var auth: FirebaseAuth
    private lateinit var storage : FirebaseStorage
    private lateinit var database: FirebaseDatabase
    private lateinit var db : FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ilan_onay, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        storage = FirebaseStorage.getInstance()
        auth = FirebaseAuth.getInstance()
        val db = FirebaseFirestore.getInstance()
        database = FirebaseDatabase.getInstance()


        buttonGEOnay.setOnClickListener {
            //depo işlemleri
            //UUID -> universal unique id
            val uuid = UUID.randomUUID()
            val gorselIsim = "${uuid}.jpg"
            val reference = storage.reference
            val gorselReference = reference.child("images").child(gorselIsim)
            if (secilenGorsel !=null){

                gorselReference.putFile(secilenGorsel!!).addOnSuccessListener{
                    println("Yükledik")
                    val yuklenenGorselReference =FirebaseStorage.getInstance().reference.child("images").child(gorselIsim)
                    yuklenenGorselReference.downloadUrl.addOnSuccessListener { uri->
                        val downloadUrl = uri.toString()
                        val guncelKullaniciEmail = auth.currentUser!!.email.toString()
                        val tarih = Timestamp.now()
                        //veritabanı işlemleri

                        val postHashMap = hashMapOf<String, Any>()
                        postHashMap.put("gorselurl", "try")
                        postHashMap.put("kullaniciemail", guncelKullaniciEmail)
                        postHashMap.put("tarih", tarih)

                        db.collection("Deneme")
                                .add(postHashMap)
                                .addOnSuccessListener { documentReference ->
                            Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                        }
                                .addOnFailureListener { e ->
                                    Log.w(TAG, "Error adding document", e)
                                }
                    }
                }
            }
        }
    }
}