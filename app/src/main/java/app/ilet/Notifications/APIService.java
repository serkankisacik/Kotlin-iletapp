package app.ilet.Notifications;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=\tAAAAT1KX480:APA91bEFPP_tU-cGXHLXy-i-WkJH4SjSqNQCNbH66ASxA-gYeov6hyiX7_hwEG-xMT9kJvt-AjfpVDI_zsJ6xnCkNVhg4uKY7FjR2qqr5me9LWfwqWrR5LqO0E0Hji7335Y7KP2DjCvn"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
