package binar.andlima.tugasaleertdialog.tugas

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import binar.andlima.tugasaleertdialog.R
import kotlinx.android.synthetic.main.fragment_custom.*

class CustomFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_custom, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val barang = arguments?.getString("BR")
        val jumlah = arguments?.getString("JM")
        val harga = arguments?.getString("HR")

        val total = jumlah!!.toInt() * harga!!.toInt()

        total_belanja1.text = "Total Belanja = Rp. $total"

        proses_bayar1.setOnClickListener {
            val bayar = masukan_bayar1.text.toString()

            val kembalian = bayar.toInt() - total

            if (bayar < total.toString() ){
                Toast.makeText(requireContext(), "Uang tidak cukup", Toast.LENGTH_LONG).show()
            } else{
                val bundle = Bundle()
                bundle.putString("BR", barang)
                bundle.putString("JM", jumlah)
                bundle.putString("HR", harga)
                bundle.putString("TL", total.toString())
                bundle.putString("KM", kembalian.toString())

                val pindah = Intent(requireContext(), CustomLayoutDialogFragment::class.java)
                pindah.putExtras(bundle)
                startActivity(pindah)

                dismiss()
            }
        }

    }
}