package id.bitecode.telkom.ui.news

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import id.bitecode.telkom.R
import id.bitecode.telkom.adapter.NewsAdapter
import id.bitecode.telkom.databinding.FragmentNewBinding
import id.bitecode.telkom.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_new.*

@AndroidEntryPoint
class NewFragment : BaseFragment() {

    private var _binding: FragmentNewBinding? = null
    private val binding get() = _binding!!
    private val newsViewModel:NewsViewModel by viewModels()
    var adapter:NewsAdapter? = null

    override fun onStart() {
        super.onStart()
        newsViewModel.fetchNews()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewBinding.inflate(inflater, container, false)

        newsViewModel.listTask.observe(viewLifecycleOwner, {
            adapter = activity?.let { it1 -> NewsAdapter(it1, it) }
            binding.rvNews.adapter = adapter
            binding.rvNews.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
        })

        return binding.root
    }

}