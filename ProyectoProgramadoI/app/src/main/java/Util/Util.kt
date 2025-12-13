package Util

import android.content.Context
import android.content.Intent
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

class Util {
    companion object{
        fun openActivity(context: Context, objClassActivity: Class<*>){
            val objIntent = Intent(context, objClassActivity)
            context.startActivity(objIntent)
        }
    }

}