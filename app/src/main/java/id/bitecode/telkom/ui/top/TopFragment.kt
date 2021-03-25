package id.bitecode.telkom.ui.top

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import id.bitecode.telkom.R
import id.bitecode.telkom.databinding.FragmentTopBinding
import id.bitecode.telkom.ui.base.BaseFragment

@AndroidEntryPoint
class TopFragment : BaseFragment() {

    private var _binding: FragmentTopBinding? = null
    private val binding get() = _binding!!
    private val newsViewModel:TopViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTopBinding.inflate(inflater, container, false)
        return binding.root
    }

}