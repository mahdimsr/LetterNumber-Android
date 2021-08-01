package ir.mahdimsr.letternumber

import android.util.Log


class LetterNumber constructor(val number: Long) : PersianNumber()
{

    fun convertNumberToLetter(): String
    {
        val digitsCount = countDigits(number)

        when
        {
            digitsCount > 9     ->
            {
                return calculateBillion(number)
            }

            digitsCount in 7..9 ->
            {
                return calculateMillion(number.toInt())
            }

            digitsCount in 4..6 ->
            {
                return calculateThousand(number.toInt())
            }

            digitsCount in 1..3 ->
            {
                return calculateNormal(number.toInt())
            }

            else                -> throw Exception("Undefine number...!!! try less digits dude :)")
        }

    }

    private fun countDigits(number: Long): Int
    {
        var digits = 1;
        var loopNumber = number

        while (loopNumber / 10 != 0.toLong())
        {
            digits += 1

            loopNumber /= 10
        }

        return digits
    }

    private fun calculateBillion(number: Long): String
    {

        // billion
        val billionNumber = number / Unit.BILLION.basicValue.toInt()
        val billionLetter = getNumberByUnit(billionNumber.toInt(), Unit.BILLION)

        // million
        val millionNumber = number % Unit.BILLION.basicValue.toInt()
        Log.d("MyApp","millionNumber: $millionNumber")
        val millionLetter = calculateMillion(millionNumber.toInt())



        return if (billionNumber > 0 && millionNumber > 0)
        {
            "$billionLetter و $millionLetter"
        }
        else if (billionNumber.toInt() == 0)
        {
            millionLetter
        }
        else
        {
            billionLetter
        }
    }

    private fun calculateMillion(number: Int): String
    {

        // million
        val millionNumber = number / Unit.MILLION.basicValue.toInt()
        val millionLetter = getNumberByUnit(millionNumber, Unit.MILLION)

        // thousand
        val thousandNumber = number % Unit.MILLION.basicValue.toInt()
        val thousandLetter = calculateThousand(thousandNumber)


        return if (millionNumber > 0 && thousandNumber > 0)
        {
            "$millionLetter و $thousandLetter"
        }
        else if (millionNumber < 0)
        {
            thousandLetter
        }
        else
        {
            millionLetter
        }
    }

    private fun calculateThousand(number: Int): String
    {

        // thousand
        val thousandNumber = number / Unit.THOUSAND.basicValue.toInt()
        Log.d("myApp", "thousand $thousandNumber")
        val thousandLetter = getNumberByUnit(thousandNumber, Unit.THOUSAND)

        // less than thousand
        val normalNumber = number % Unit.THOUSAND.basicValue.toInt()
        Log.d("myApp", "normal $normalNumber")
        val normalLetter = getNumberByUnit(normalNumber, Unit.NORMAL)


        return if (thousandNumber > 0 && normalNumber > 0)
        {
            "$thousandLetter و $normalLetter"
        }
        else if (thousandNumber == 0)
        {
            normalLetter
        }
        else
        {
            thousandLetter
        }
    }

    private fun calculateNormal(number: Int): String
    {

        // less than thousand
        val normalLetter = getNumberByUnit(number, Unit.NORMAL)


        return normalLetter
    }

    private fun getNumberByUnit(number: Int, unit: Unit): String
    {
        val convertedNumber = getHundredDigitLetter(number)

        return "$convertedNumber ${unit.persianUnit}"
    }

    private fun getSingleDigitLetter(number: Int): String
    {
        if (number < 10)
        {

            return singleDigits[number]
        }
        else
        {

            throw Exception("number most be less than 10")
        }
    }

    private fun getDecimalDigitsLetter(number: Int): String
    {

        if (number >= 20)
        {
            val decimal = number / 10;
            val decimalDigitLetter = decimalDigitsAfterTwenty[decimal];

            val singleDigit = number % 10;
            val singleDigitLetter = getSingleDigitLetter(singleDigit)

            return if (singleDigit in 1..9)
            {

                "$decimalDigitLetter و $singleDigitLetter"
            }
            else
            {
                decimalDigitLetter
            }

        }
        else if (number in 10..19)
        {
            val mode = number % 10

            val decimalLetter = decimalDigitsToTwenty[mode]


            return decimalLetter
        }
        else if (number in 0..9)
        {
            return getSingleDigitLetter(number)
        }
        else
        {
            throw Exception("number has more than two digits")
        }

    }

    private fun getHundredDigitLetter(number: Int): String
    {

        if (number >= 100)
        {
            val hundred = number / 100

            val hundredLetter = hundredDigits[hundred]

            val decimal = number % 100
            val decimalLetter = getDecimalDigitsLetter(decimal)

            return if (decimal > 0)
            {
                "$hundredLetter و $decimalLetter"
            }
            else
            {
                hundredLetter
            }
        }
        else
        {
            return getDecimalDigitsLetter(number)
        }
    }
}