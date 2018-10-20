package tech.owly.owly

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sign_in.setOnClickListener {
            val username = username.text.toString()
            val password = password.text.toString()
            if (validateCredentials(username,password)){
                Toast.makeText(this,"Login successful!",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"Invalid credentials",Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun validateCredentials(username: String, password: String) =
        username == "admin" && password == "admin"

}
