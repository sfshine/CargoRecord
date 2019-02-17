package cn.su.cargorecord.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cn.su.cargorecord.R
import cn.su.cargorecord.databinding.ListItemCargoRecordBinding
import cn.su.cargorecord.db.entity.CargoRecord
import cn.su.cargorecord.model.CargoRecordModel

class CargoRecordAdapter :
    ListAdapter<CargoRecord, CargoRecordAdapter.ViewHolder>(CargoRecordDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_cargo_record, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).let { plantings ->
            with(holder) {
                itemView.tag = plantings
                bind(createOnClickListener(plantings.id), plantings)
            }
        }
    }

    private fun createOnClickListener(id: Long): View.OnClickListener {
        return View.OnClickListener {

        }
    }

    class ViewHolder(private val binding: ListItemCargoRecordBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: View.OnClickListener, cargoRecord: CargoRecord) {
            with(binding) {
                clickListener = listener
                viewModel = CargoRecordModel(cargoRecord)
                executePendingBindings()
            }
        }
    }
}

private class CargoRecordDiffCallback : DiffUtil.ItemCallback<CargoRecord>() {

    override fun areItemsTheSame(
        oldItem: CargoRecord,
        newItem: CargoRecord
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: CargoRecord,
        newItem: CargoRecord
    ): Boolean {
        return oldItem.id == newItem.id
    }
}