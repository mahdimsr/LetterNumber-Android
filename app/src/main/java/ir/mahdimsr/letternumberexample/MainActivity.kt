package ir.mahdimsr.letternumberexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import ir.mahdimsr.letternumber.LetterNumber
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity()
{

    private lateinit var editText: EditText
    private lateinit var textView: TextView
    private lateinit var button: Button

    private final val TAG = "Test"

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)

        button.setOnClickListener { v ->

            val number = editText.text.toString()


            if (number.isNotEmpty())
            {
                textView.text = number

                try
                {
                    val convertedNumber = LetterNumber(number.toLong()).convertNumberToLetter()


                    textView.text = convertedNumber
                }
                catch (e: Exception)
                {
                    Log.e("MyApp", e.toString())
                }


            }
        }
    }
}