
import kotlin.math.roundToInt

const val HOUR = 60*60

fun main(){
    val inputTime = 600 //Входные данные в секундах

    val inputText = agoToText(inputTime)
    println("В сети был(а) $inputText")
}

fun agoToText(inputTime: Int): String {

    val callPeriod = when (inputTime) {
        in 0..60 -> "только что" //только что
        in 61..HOUR ->  correctMinutes(inputTime) // Х минут назад
        in HOUR+1..24*HOUR -> correctHours(inputTime) // Х часов назад
        in 24*HOUR..2*24*HOUR -> "сегодня" // сегодня
        in 2*24*HOUR..3*24*HOUR -> "вчера" // вчера
        in 3*24*HOUR..Int.MAX_VALUE -> "давно" // давно
        else -> "никогда не была"
    }
    return callPeriod
}

fun correctMinutes(inputTime: Int): String {
    val m = (inputTime / 60.0).roundToInt()
    val minutes = when(m%10){
        1 -> "$m минуту назад"
        in 2..4 -> "$m минуты назад"
        in 5..9, -> "$m минут назад"
        else -> "$m минут назад"
    }
    return minutes
}

fun correctHours(inputTime: Int): String {
    val h = (inputTime / HOUR)
    val hours = when (h){
        1,21 -> "$h час назад"
        in 2..4 -> "$h часа назад"
        in 5..20 -> "$h часов назад"
        else -> "$h часа назад"
    }
    return hours
}

