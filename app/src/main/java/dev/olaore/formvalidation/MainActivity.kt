package dev.olaore.formvalidation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import dev.olaore.formvalidation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: FormValidationViewModel by lazy {
        ViewModelProvider(this).get(FormValidationViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
                this, R.layout.activity_main
        )

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.saveButton.setOnClickListener {
            Toast.makeText(applicationContext,
                    "Save Clicked with email: ${ binding.emailControl.text }",
                    Toast.LENGTH_LONG).show()
        }

    }
}