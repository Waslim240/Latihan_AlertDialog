package binar.andlima.tugasaleertdialog.tugas

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import binar.andlima.tugasaleertdialog.R
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_custom_layout_biasa.*
import kotlinx.android.synthetic.main.custom_dialog.*
import kotlinx.android.synthetic.main.custom_dialog.view.*

class CustomLayoutBiasa : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_layout_biasa)

        prosesnya.setOnClickListener {
            val barang = masukan_barang.text.toString()
            val jumlah = masukan_jumlah.text.toString()
            val harga = masukan_harga.text.toString()


            val total = jumlah.toInt() * harga.toInt()

            val custom = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null, false)
            val a = AlertDialog.Builder(this)
                .setView(custom)
                .setMessage("Total Belanja = Rp. $total")
                .create()

            custom.proses_bayar.setOnClickListener {
                val bayar = a.masukan_bayar.text.toString()
                val kembalian = bayar.toInt() - total

                if (bayar < total.toString() ){
                    Toast.makeText(this, "Uang tidak cukup", Toast.LENGTH_LONG).show()
                } else {
                    a.dismiss()
                    hasil_semua.text = "Nama Barang : $barang\n" +
                            "Jumlah Beli : $jumlah\n" +
                            "Harga Beli : $harga\n" +
                            "Total Belanja : $total\n" +
                            "Kembalian : $kembalian"
                }

            }
            a.show()
        }

    }
}
