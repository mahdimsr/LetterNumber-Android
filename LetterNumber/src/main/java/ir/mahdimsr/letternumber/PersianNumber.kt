package ir.mahdimsr.letternumber

open class PersianNumber
{

    protected val singleDigits: Array<String>
        get()
        {
            return arrayOf("صفر", "یک", "دو", "سه", "چهار", "پنج", "شیش", "هفت", "هشت", "نه")
        }

    protected val decimalDigitsToTwenty: Array<String>
        get()
        {
            return arrayOf("ده", "یازده", "دوازده", "سیزده", "چهارده", "پانزده", "هفتده", "هجده", "نوزده")
        }

    protected val decimalDigitsAfterTwenty: Array<String>
        get()
        {
            return arrayOf("صفز", "ده", "بیست", "سی", "چهل", "پنجاه", "شصت", "هفتاد", "هشتاد", "نود")
        }

    protected val hundredDigits: Array<String>
        get()
        {
            return arrayOf("صفز", "صد", "دویست", "سیصد", "چهارصد", "پانصد", "ششصد", "هفتصد", "هشتصد", "نهصد")
        }
}