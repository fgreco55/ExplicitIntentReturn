package com.example.explicitintentreturn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.explicitintentreturn.databinding.ActivityFrankSecondBinding

class FrankSecondActivity : AppCompatActivity() {

    private lateinit var frankbinding: ActivityFrankSecondBinding
    private lateinit var doneButton: Button
    private lateinit var msgText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("FrankSecondActivity:onCreate", "Before inflate")
        frankbinding = ActivityFrankSecondBinding.inflate(this.layoutInflater)
        doneButton = frankbinding.doneButton

        setContentView(frankbinding.root)
        msgText = frankbinding.msgText

        val myIntent = getIntent()
        val msg = myIntent.getStringExtra(MainActivity.INPUT_NAME)
        msgText.setText(msg)

        doneButton.setOnClickListener {
            Log.i("FrankSecondActivity.onCreate", "doneButton onClick called")

            val name = msgText.getText().toString()
            Log.i("FrankSecondActivity.onCreate", "value is [$name]")

            Log.i("FrankSecondActivity.onCreate", "Creating Intent to return")

            var resultIntent = Intent()
            resultIntent.putExtra(MainActivity.RETURNED_NAME, name)
            resultIntent.putExtra(MainActivity.FRANK_DATA, "frank greco")   // send other data...
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}