package app.ilet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class sendOffer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_offer)
    }



    fun paymentConfirm(view: View) {
        val intent = Intent(applicationContext, PaymentQRActivity::class.java)
        startActivity(intent)
    }
}