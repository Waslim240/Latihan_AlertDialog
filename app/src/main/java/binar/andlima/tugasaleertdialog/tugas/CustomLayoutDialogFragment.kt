package binar.andlima.tugasaleertdialog.tugas

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.andlima.tugasaleertdialog.R
import kotlinx.android.synthetic.main.activity_custom_layout_dialog_fragment.*

class CustomLayoutDialogFragment : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_layout_dialog_fragment)

        val bund = intent.extras
        val barang1 = bund?.getString("BR")
        val jumlah1 = bund?.getString("JM")
        val harga1 = bund?.getString("HR")
        val total1 = bund?.getString("TL")
        val kembalian1 = bund?.getString("KM")

        if (kembalian1 == null){
            hasil1.text = "Belum ada data"
        } else{
            hasil2.text = "Nama Barang : $barang1\n" +
                    "Jumlah Beli : ${jumlah1.toString()}\n" +
                    "Harga Beli : ${harga1.toString()}\n" +
                    "Total Belanja : ${total1.toString()}\n" +
                    "Kembalian : $kembalian1"
        }


        prosesnya1.setOnClickListener {

            val barang = masukan_barang1.text.toString()
            val jumlah = masukan_jumlah1.text.toString().toInt()
            val harga = masukan_harga1.text.toString().toInt()

            val dialog = CustomFragment()
            val bundle = Bundle()
            bundle.putString("BR", barang)
            bundle.putString("JM", jumlah.toString())
            bundle.putString("HR", harga.toString())
            dialog.arguments = bundle
            dialog.show(supportFragmentManager, "fragment")

        }



    }
}