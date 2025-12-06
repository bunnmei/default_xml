package space.webkombinat.defaultviewnavigation.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import space.webkombinat.defaultviewnavigation.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        var rotated = false


        binding.rotateButton.setOnClickListener { button ->
            rotated = !rotated

            val targetRotation = if (rotated) 45f else 0f
            button.animate()
                .rotation(targetRotation)
                .setDuration(100)
                .start()

            if (rotated) {
                // 小さくして消える
                binding.circleButton.animate()
                    .scaleX(0f)
                    .scaleY(0f)
                    .alpha(0f)
                    .setDuration(100)
                    .withEndAction {
                        binding.circleButton.visibility = View.INVISIBLE
                    }
                    .start()
            } else {
                // 表示して大きくなる
                binding.circleButton.visibility = View.VISIBLE
                binding.circleButton.animate()
                    .scaleX(1f)
                    .scaleY(1f)
                    .alpha(1f)
                    .setDuration(100)
                    .start()
            }
        }





        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}