import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.rajkishorbgp.onlineshopping.ItemClass

class CartAdapter(private val context: Context, private val cartArrayList: ArrayList<ItemClass>) : BaseAdapter() {
    override fun getCount(): Int { return cartArrayList.size }
    override fun getItem(position: Int): Any { return cartArrayList[position] }
    override fun getItemId(position: Int): Long { return position.toLong() }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.your_layout, parent, false)
        // Populate your views here.
        return view
    }
}