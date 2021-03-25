package id.bitecode.telkom.ui.best

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import id.bitecode.telkom.R
import id.bitecode.telkom.databinding.FragmentBestBinding
import id.bitecode.telkom.ui.base.BaseFragment

@AndroidEntryPoint
class BestFragment : BaseFragment() {

    private var _binding: FragmentBestBinding? = null
    private val binding get() = _binding!!
    private val newsViewModel:BestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBestBinding.inflate(inflater, container, false)
        return binding.root
    }

}