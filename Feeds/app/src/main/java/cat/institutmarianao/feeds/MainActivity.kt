package cat.institutmarianao.feeds

import android.content.ContentValues
import android.os.Bundle
import android.provider.BaseColumns
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cat.institutmarianao.feeds.FeedReaderContract.FeedEntry

class MainActivity : AppCompatActivity() {

    val dbHelper = FeedReaderDbHelper(this)
    lateinit var titleEditText: EditText
    lateinit var subtitleEditText: EditText
    lateinit var entryListView: ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleEditText = findViewById(R.id.titleEditText)
        subtitleEditText = findViewById(R.id.subtitleEditText)
        entryListView = findViewById(R.id.entryListView)

        updateListView()
    }

    fun insert(view: View) {
        var title = titleEditText.text.toString()
        var subtitle = subtitleEditText.text.toString()

        val db = dbHelper.writableDatabase

        // Create a new map of values, where column names are the keys
        val values = ContentValues().apply {
            put(FeedEntry.COLUMN_NAME_TITLE, title)
            put(FeedEntry.COLUMN_NAME_SUBTITLE, subtitle)
        }

        // Insert the new row, returning the primary key value of the new row
        if (db?.insert(FeedEntry.TABLE_NAME, null, values) == -1L) {
            Toast.makeText(this, "Error adding", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Entry added", Toast.LENGTH_SHORT).show()
        }

        updateListView()
    }

    fun updateListView() {
        var items = getAllEntries()
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            items
        )
        entryListView.adapter = adapter
    }

    fun getAllEntries(): List<String> {
        val db = dbHelper.readableDatabase

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        val projection =
            arrayOf(BaseColumns._ID, FeedEntry.COLUMN_NAME_TITLE, FeedEntry.COLUMN_NAME_SUBTITLE)

        // How you want the results sorted in the resulting Cursor
        val sortOrder = "${FeedEntry.COLUMN_NAME_TITLE} ASC"

        val cursor = db.query(
            FeedEntry.TABLE_NAME,   // The table to query
            projection,             // The array of columns to return (pass null to get all)
            null,              // The columns for the WHERE clause
            null,          // The values for the WHERE clause
            null,                   // don't group the rows
            null,                   // don't filter by row groups
            sortOrder               // The sort order
        )

        val itemTitles = mutableListOf<String>()
        with(cursor) {
            while (moveToNext()) {
                val itemTitle = getString(getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_TITLE))
                itemTitles.add(itemTitle)
            }
        }
        cursor.close()
        return itemTitles
    }
}