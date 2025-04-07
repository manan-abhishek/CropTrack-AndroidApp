package com.example.croptrack

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.textfield.TextInputEditText

class SoilData : Fragment() {

    private lateinit var inputPh: TextInputEditText
    private lateinit var inputNitrogen: TextInputEditText
    private lateinit var inputPhosphorus: TextInputEditText
    private lateinit var inputPotassium: TextInputEditText
    private lateinit var inputMoisture: TextInputEditText
    private lateinit var inputTexture: TextInputEditText
    private lateinit var inputEC: TextInputEditText
    private lateinit var buttonUploadReport: Button

    private lateinit var filePL: ActivityResultLauncher<Intent> //File PickerLauncher

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_soil_data, container, false)

//        then a custom dialogBox to show:
//        Crop Suitability Recommendation if ph is not good for crops then an alert dialogBox, Fertilizer Suggestions, download a report
        inputPh = view.findViewById(R.id.inputPh)
        inputNitrogen = view.findViewById(R.id.inputNitrogen)
        inputPhosphorus = view.findViewById(R.id.inputPhosphorus)
        inputPotassium = view.findViewById(R.id.inputPotassium)
        inputMoisture = view.findViewById(R.id.inputMoisture)
        inputTexture = view.findViewById(R.id.inputTexture)
        inputEC = view.findViewById(R.id.inputEC)

        val ph: Float = inputPh.text.toString().toFloat()
        val moisture: Float = inputMoisture.text.toString().toFloat()

        buttonUploadReport = view.findViewById(R.id.buttonUploadReport)

        if(ph in 6.5..8.5 && moisture in 20.0..60.0)
            showSuitable()
        else
            showUnSuitable()

        filePL = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){result ->
            if(result.resultCode == Activity.RESULT_OK){
                val fileUri: Uri? = result.data?.data
                if(fileUri != null){
                    val saved = saveFileToInternal(requireContext(), fileUri, "report.pdf")
                    if(saved){
                        Toast.makeText(requireContext(), "We get your File successfully!", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(requireContext(), "No file selected", Toast.LENGTH_SHORT).show()
                }
            }
        }
        buttonUploadReport.setOnClickListener {
            openFileChooser()
        }

        return view
    }
    private fun showSuitable(){
        val view = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_suitable, null)
        AlertDialog.Builder(requireContext()).setView(view).show()
    }
    private fun showUnSuitable(){
        val view = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_unsuitable, null)
        AlertDialog.Builder(requireContext()).setView(view).show()
    }

    private fun openFileChooser(){
        val intent = Intent(Intent.ACTION_GET_CONTENT).apply{
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "*/*"
            putExtra(Intent.EXTRA_MIME_TYPES, arrayOf("application/pdf", "image/*"))
        }
        filePL.launch(intent)
    }

    private fun saveFileToInternal(context: Context, uri: Uri, fileNme: String): Boolean{
        return try{
            val input = context.contentResolver.openInputStream(uri)
            val output = context.openFileOutput(fileNme, Context.MODE_PRIVATE)

            input?.copyTo(output)
            input?.close()
            output.close()

            true
        }catch(e : Exception){
            Toast.makeText(requireContext(), "We didn't get the file", Toast.LENGTH_SHORT).show()

            false
        }
    }
}