package com.example.ibmcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.ibmcalculator.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.calculateBtn.setOnClickListener {
            try {
            val weight = binding.weightContent.text.toString().toDouble()
            val height = binding.heightContent.text.toString().toDouble()

            val result = weight / Math.pow(height, 2.00)

            binding.bmiId.text = "BMI: %.2f".format(result)


                if (result > 25) {
                    binding.imageView.setImageResource(R.drawable.over)
                } else if (result >= 18.5 && result <= 24.9) {
                    binding.imageView.setImageResource(R.drawable.normal)
                } else if (result < 18.5) {
                    binding.imageView.setImageResource(R.drawable.under)
                }

                binding.resetBtn.setOnClickListener {
                    binding.bmiId.text = ""
                    binding.weightContent.setText("")
                    binding.heightContent.setText("")
                    binding.imageView.setImageResource(R.drawable.empty)
                }
            }
            catch(ex:Exception)
            {
                val toast:Toast=Toast.makeText(this, "No input detected",Toast.LENGTH_LONG)

                toast.setGravity(Gravity.CENTER,0,0)
                toast.show()

            }
        }


    }







}
