package cesar.landaverde.validacionesyspinner

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtEdad = findViewById<EditText>(R.id.txtEdad)
        val txtCorreo = findViewById<EditText>(R.id.txtCorreoElectronico)
        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtContrasena = findViewById<EditText>(R.id.txtContrasena)
        val txtDui = findViewById<EditText>(R.id.txtDui)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)

        btnAgregar.setOnClickListener {
            if(txtEdad.text.isEmpty() || txtCorreo.text.isEmpty() || txtNombre.text.isEmpty() || txtContrasena.text.isEmpty() || txtDui.text.isEmpty()){
                Toast.makeText(this, "Por favor llenar todos los campos!", Toast.LENGTH_LONG).show()
            }else if(txtEdad.text.matches("[0-9]+".toRegex())){
                Toast.makeText(this, "Campos agregados exitosamente!", Toast.LENGTH_LONG).show()
            } else{
                Toast.makeText(this, "Verifique los campos", Toast.LENGTH_LONG).show()
            }

            if(txtCorreo.text.matches("[a-zA-Z0-0._-]+@[a-z]+\\\\.+[a-z]+]°".toRegex())){
                Toast.makeText(this, "Correo real", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Correo no real", Toast.LENGTH_LONG).show()
            }

            if(txtContrasena.text.length <= 6){
                Toast.makeText(this, "Debe de tener más de 6 dígitos", Toast.LENGTH_LONG).show()
            }

            if(txtDui.text.matches("[0-9]+-[0-9]".toRegex()) && txtDui.text.length <= 10){

            }else{

            }

            if(txtNombre.text.matches("[a-zA-Z]=".toRegex())){
                
            }
        }
    }
}