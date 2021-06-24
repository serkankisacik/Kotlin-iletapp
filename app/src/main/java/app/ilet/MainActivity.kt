package app.ilet

import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import app.ilet.Activity.ChatList
import app.ilet.Adapter.poatAdapter
import app.ilet.Model.Post
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var reference: DatabaseReference
    val postList = ArrayList<Post>()
    var contex: Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = Firebase.auth
        val notificationManager =
            applicationContext.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.cancelAll()
        val currentUser = auth.currentUser
        if (currentUser == null) {
            val intent = Intent(applicationContext, giris::class.java)
            startActivity(intent)
        }

        reference = FirebaseDatabase.getInstance().reference.child("post")

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                postList.clear()
                for (ds in dataSnapshot.children) {
                    var po = ds.getValue(Post::class.java)

                    postList.add(po as Post)
                }
                if (postList.size > 0)
                    liste.adapter = poatAdapter(contex,postList)

            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        }
        reference.addValueEventListener(postListener)


    }

    fun gitProfil(view: View) {
        val intent = Intent(applicationContext, ProfilActivity::class.java)
        startActivity(intent)
    }

    fun gitKargo(view: View) {
        val intent = Intent(applicationContext, KargoActivity::class.java)
        startActivity(intent)
    }

    fun gitSohbet(view: View) {
        val intent = Intent(applicationContext, ChatList::class.java)
        startActivity(intent)
    }

    fun postAdd(view: View) {
        val intent = Intent(applicationContext, postSet::class.java)
        startActivity(intent)
    }


}