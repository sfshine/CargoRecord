package cn.su.cargorecord.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment.findNavController
import cn.su.cargorecord.adapters.CargoRecordAdapter
import cn.su.cargorecord.databinding.FragmentCargoRecordBinding
import cn.su.cargorecord.model.CargoRecordListModel
import java.util.*


/**
 * Created by sfshine@qq.com on 2019/2/17 0017.
 */
class CargoRecordListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCargoRecordBinding.inflate(inflater, container, false)
        val adapter = CargoRecordAdapter()
        binding.cargoRecordList.adapter = adapter
        binding.fab.setOnClickListener {
            findNavController(this).navigate(cn.su.cargorecord.R.id.action_cargoRecordListFragment_to_cargoRecordAddFragment)
        }
        subscribeUi(adapter, binding)
        return binding.root
    }

    private fun subscribeUi(adapter: CargoRecordAdapter, binding: FragmentCargoRecordBinding) {
        val viewModel = ViewModelProviders.of(this).get(CargoRecordListModel::class.java)
        viewModel.getCargoRecords(Date(1550373836000)).observe(viewLifecycleOwner, Observer { result ->
            binding.hasPlantings = (result != null && result.isNotEmpty())
            if (binding.hasPlantings) {
                adapter.submitList(result)
            }
        })
    }
}