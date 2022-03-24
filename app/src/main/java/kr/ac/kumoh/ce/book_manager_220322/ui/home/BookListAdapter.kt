package kr.ac.kumoh.ce.book_manager_220322.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kr.ac.kumoh.ce.book_manager_220322.Book
import kr.ac.kumoh.ce.book_manager_220322.R


class BookListAdapter(private val context: Context) : RecyclerView.Adapter<BookListAdapter.ViewHolder>() {

    var datas = mutableListOf<Book>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_row_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val txtName: TextView = itemView.findViewById(R.id.item_textView)
//        private val imgProfile: ImageView = itemView.findViewById(R.id.img_rv_photo)

        fun bind(item: Book) {
            txtName.text = item.name
//            Glide.with(itemView).load(item.img).into(imgProfile)

        }
    }


}