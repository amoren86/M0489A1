package cat.institutmarianao.layouts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ConstraintLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_layout)

        findViewById<Button>(R.id.linearButton).setOnClickListener {
            // Call TableLayoutActivity
            startActivity(Intent(this, LinearLayoutActivity::class.java))
        }

        findViewById<Button>(R.id.tableButton).setOnClickListener {
            // Call TableLayoutActivity
            startActivity(Intent(this, TableLayoutActivity::class.java))
        }

        findViewById<Button>(R.id.relativeButton).setOnClickListener {
            // Call TableLayoutActivity
            startActivity(Intent(this, RelativeLayoutActivity::class.java))
        }
    }
}