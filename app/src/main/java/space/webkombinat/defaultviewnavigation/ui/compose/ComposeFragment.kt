package space.webkombinat.defaultviewnavigation.ui.compose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import space.webkombinat.defaultviewnavigation.databinding.FragmentComposeBinding
import space.webkombinat.defaultviewnavigation.databinding.FragmentDashboardBinding
import space.webkombinat.defaultviewnavigation.jetpack.ReText

class ComposeFragment : Fragment() {

    private var _binding: FragmentComposeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =  ComposeView(requireContext()).apply {
        setContent {
            Column(
                modifier = Modifier.fillMaxSize()
                    .background(color = Color.Black),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                ReText()
            }
        }
    }

//    {
//        val dashboardViewModel =
//            ViewModelProvider(this).get(ComposeViewModel::class.java)
//
//        _binding = FragmentComposeBinding.inflate(inflater, container, false)
//            .apply {
//                composeView.setContent {
//                    ReText()
//                }
//            }
//        val root: View = binding.root
//
//        val textView: TextView = binding.textDashboard
//        dashboardViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }



//        return root
//    }

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View = ComposeView(requireContext()).apply {
//        setContent {
//            MyComposeScreen()
//        }
//    }
//
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}