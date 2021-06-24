package app.ilet

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter
import kotlinx.android.synthetic.main.activity_send_offer.*
import kotlinx.android.synthetic.main.fragment_payment_confirmed.*

class sendOffer : AppCompatActivity() {

    private lateinit var ivQRcode : ImageView
    private lateinit var etData : EditText
    private lateinit var btnGenerateQRcode : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_offer)
        val intent = intent
        val data = intent.getStringExtra("price")
        val userdata = intent.getStringExtra("user")
        priceTextOffer.setText(data);

        ivQRcode = findViewById(R.id.ivQRCode)
        etData = findViewById(R.id.kartAd)
        btnGenerateQRcode = findViewById(R.id.btnOde)



        btnGenerateQRcode.setOnClickListener {
            val data = etData.text.toString().trim()
            if(data.isEmpty()){
                Toast.makeText(this, "Kart Sahibini giriniz", Toast.LENGTH_SHORT).show()
            }else{
                val writer = QRCodeWriter()
                try {
                    val bitMatrix =writer.encode(data, BarcodeFormat.QR_CODE, 512 , 512)
                    val width =bitMatrix.width
                    val height = bitMatrix.height
                    val bmp = Bitmap.createBitmap(width, height , Bitmap.Config.RGB_565)
                    for(x in 0 until width){
                        for(y in 0 until height){
                            bmp.setPixel(x, y, if(bitMatrix[x, y]) Color.BLACK else Color.WHITE)
                        }
                    }
                    ivQRcode.setImageBitmap(bmp)

                }catch (e: WriterException){
                    e.printStackTrace()
                }

                textView19.setText("Ödeme Onaylandı");
            }
        }
    }



    fun paymentConfirm(view: View) {


    }
}