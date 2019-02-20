package cn.su.cargorecord.fragment

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import cn.su.cargorecord.R
import cn.su.cargorecord.databinding.FragmentCargoRecordAddBinding
import cn.su.cargorecord.db.entity.CargoRecord
import cn.su.cargorecord.model.CargoRecordAddModel
import java.util.*

class CargoRecordAddFragment : Fragment(), View.OnClickListener {
    private val TAG: String = "CargoRecordAddFragment"
    private lateinit var mViewModel: CargoRecordAddModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewModel = ViewModelProviders.of(this@CargoRecordAddFragment).get(CargoRecordAddModel::class.java)
        val binding = FragmentCargoRecordAddBinding.inflate(inflater, container, false)
        binding.apply {
            viewModel = mViewModel
            clickListener = this@CargoRecordAddFragment
            executePendingBindings()
        }
        return binding.root
    }


    override fun onClick(v: View?) {
        Log.d(TAG, "note: ${mViewModel.note.get()} \n money: ${mViewModel.money.get()}")
        var cargoRecord = CargoRecord(mViewModel.note.get(), mViewModel.money.get()?.toDouble(), Date())
        mViewModel.addCargoRecord(cargoRecord)
        NavHostFragment.findNavController(this).popBackStack()
        closeIME()
    }

    private fun closeIME() {
        val view = activity?.window?.peekDecorView()
        val inputManger = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        inputManger?.hideSoftInputFromWindow(view?.windowToken, 0)
    }
}
