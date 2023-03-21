package com.omersungur.lifecycle_androidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) { // savedInstance > aktivitenin durumunu kaydeden bir bilgi bohçasıdır.
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Uygulama ilk açıldığında sırasıyla onCreate, onStart ve onResume metodları çağrılır. Kullanıcı daha işlem yapmadan bu 3 metod çalışır.
        // Uygulama arka plana alınırsa sırasıyla onPause ve onStop metodları çağrılır eğer tekrar uygulamaya dönülürse sırasıyla onRestart onStart onResume çağrılır.
        // Uygulama oryantasyonu değişirse uygulama direkt destroy olur ve onCreate ile yeniden oluşturulur.
        // Uygulama tamamen kapandığında onDestroy çağrılır.
        // Ekran oryantasyonu değiştiğinde onRestart çağrılmıyor, uygulamaya dönüş yaptığında çağrılıyor.
        // Intent yapıldığında ise sırasıyla onPause onStop ve onSaveInstanceState çağrılır. Geri dönüldüğünde onStart ve onResume metodları çağrılır.

        Log.d(
            TAG,
            "onCreate"
        )  //Log.d = Metodun, döngünün veya herhangi bir kod bloğunun çalışıp çalışmadığını kontrol eder.
    }


    override fun onSaveInstanceState(outState: Bundle) { // onPause ve onStop'tan sonra'çalışan bir metoddur.
        super.onSaveInstanceState(outState)

        Log.d(TAG, "onSaveInstanceState")

        //Aktivite, oryantasyon değiştiğinde textView bilgilerini taşımıyor bu yüzden manuel taşıma işlemi yapıyoruz.
        outState.putString(
            "deger",
            textView.text.toString()
        ) // Uygulama destroy edilmeden önce değerimizi kaydediyoruz.
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) { // onStart ile onResume arasında çalışan bir metoddur.(Ekran oryantasyonunu değiştirdikten sonra)
        super.onRestoreInstanceState(savedInstanceState)

        Log.d(TAG, "onRestoreInstanceState")
        
        val savedString =
            savedInstanceState.getString("deger") // Uygulama onCreate ile yeniden oluşturuluyor ve onStart'tan sonra bu metod çalışıyor ve burada üstte koyduğumuz değeri alıyoruz.
        textView.text = savedString
    }

    override fun onStart() {
        super.onStart()

        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.d(TAG, "onStop")
    }

    override fun onRestart() {
        super.onRestart()

        Log.d(TAG, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d(TAG, "onDestroy")
    }

    fun save(view: View) {

        val name = editText.text.toString()
        textView.text = name

    }
}