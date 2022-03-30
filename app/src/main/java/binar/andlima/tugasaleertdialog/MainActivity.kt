package binar.andlima.tugasaleertdialog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.andlima.tugasaleertdialog.tugas.CustomFragment
import binar.andlima.tugasaleertdialog.tugas.CustomLayoutBiasa
import binar.andlima.tugasaleertdialog.tugas.CustomLayoutDialogFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Alert_dialog_custom_biasa.setOnClickListener {
            startActivity(Intent(this, CustomLayoutBiasa::class.java))
        }

        Alert_dialog_custom_fragment.setOnClickListener {
            startActivity(Intent(this, CustomLayoutDialogFragment::class.java))
        }


    }
}