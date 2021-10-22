
import kotlin.math.roundToInt

const val HOUR = 60*60

fun main(){
    val inputTime = 61 //Входные данные в секундах

    val inputText = agoToText(inputTime)
    println("В сети был(а) $inputText")
}

fun agoToText(inputTime: Int): String {
    val callPeriod: String
    when (inputTime) {
        in 0..60 -> callPeriod = "только что" //только что
        in 61..HOUR -> callPeriod = correctMinutes(inputTime) // Х минут назад
        in HOUR+1..24*HOUR -> callPeriod = correctHours(inputTime) // Х часов назад
        in 24*HOUR..2*24*HOUR -> callPeriod = "сегодня" // сегодня
        in 2*24*HOUR..3*24*HOUR -> callPeriod = "вчера" // вчера
        in 3*24*HOUR..Int.MAX_VALUE -> callPeriod = "давно" // давно
        else -> callPeriod = "никогда не была"
    }
    return callPeriod
}

fun correctMinutes(inputTime: Int): String {
    val minutes: String
    var m = (inputTime / 60.0).roundToInt()
    when(m){
        1,21,31,41,51 -> minutes = "$m минуту назад"
        in 2..4 -> minutes = "$m минуты назад"
        in 5..20, -> minutes = "$m минут назад"
        in 22..24, -> minutes = "$m минуты назад"
        in 25..30, -> minutes = "$m минут назад"
        in 32..34, -> minutes = "$m минуты назад"
        in 35..40, -> minutes = "$m минут назад"
        in 42..44, -> minutes = "$m минуты назад"
        in 45..50, -> minutes = "$m минут назад"
        in 52..54, -> minutes = "$m минуты назад"
        in 55..60, -> minutes = "$m минут назад"
        else -> minutes = "$m минут назад"
    }
    return minutes
}

fun correctHours(inputTime: Int): String {
    val hours: String
    var h = (inputTime / HOUR)
    when (h){
        1,21 -> hours = "$h час назад"
        in 2..4 -> hours = "$h часа назад"
        in 5..20 -> hours = "$h часов назад"
        else -> hours ="$h часа назад"
    }
    return hours
}

