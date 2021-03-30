package app.ilet

import com.google.firebase.Timestamp
import kotlinx.android.synthetic.main.fragment_ilan_detay_ekle.*
import kotlinx.android.synthetic.main.fragment_ilan_durak_ekle.*

class Travel {
    var startPosition:String = ""
    var finishPosition:String = ""
    var userVehicle:String = ""
    var createDate:String = ""
    var arrivalDate:String = ""
    var departureDate:String = ""
    var estimatedTime:String = ""
    var stations:String = ""
    var userName:String = ""
    var userId:Int = 0

    constructor(startPosition:String, finishPosition:String, userVehicle:String, createDate:String, arrivalDate:String, departureDate:String, estimatedTime:String, stations:String, userName:String, userId:Int){
        this.startPosition = startPosition
        this.finishPosition = finishPosition
        this.userVehicle = userVehicle
        this.createDate = createDate
        this.arrivalDate = arrivalDate
        this.departureDate = departureDate
        this.estimatedTime = estimatedTime
        this.stations = stations
        this.userName = userName
        this.userId = userId
    }
}