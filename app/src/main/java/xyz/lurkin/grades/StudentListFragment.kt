package xyz.lurkin.grades


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import xyz.lurkin.grades.databinding.FragmentStudentListBinding

/**
 * A simple [Fragment] subclass.
 */
class StudentListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_student_list, container, false)
        val binding: FragmentStudentListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_student_list, container, false)

        return binding.root
    }


}
