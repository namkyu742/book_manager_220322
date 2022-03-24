package kr.ac.kumoh.ce.book_manager_220322.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kr.ac.kumoh.ce.book_manager_220322.AppDatabase
import kr.ac.kumoh.ce.book_manager_220322.Book
import kr.ac.kumoh.ce.book_manager_220322.R
import kr.ac.kumoh.ce.book_manager_220322.databinding.FragmentHomeBinding
import kotlin.concurrent.thread

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    lateinit var db: AppDatabase
    private var libraryList: MutableList<Book> = mutableListOf()
    lateinit var bookListAdapter: BookListAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView: RecyclerView = binding.recyclerView
        val testButton: Button = binding.testButton

        thread {
            db = Room.databaseBuilder(
                root.context,
                AppDatabase::class.java,
                "BookDB"
            ).build()
        }.run()

        testButton.setOnClickListener {
            var tempBook = Book(null, "tempbook")
            Thread(Runnable {
                db.bookDao().insertBook(tempBook)
                libraryList = db.bookDao().getAll().toMutableList()
            }).start()
        }


        // 리사이클러뷰 설정
        bookListAdapter = BookListAdapter(root.context)
//        recyclerView.layoutManager = LinearLayoutManager(root.context)
        recyclerView.adapter = bookListAdapter



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}