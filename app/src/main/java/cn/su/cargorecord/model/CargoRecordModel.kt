package cn.su.cargorecord.model

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import cn.su.cargorecord.db.entity.CargoRecord

/**
 * Created by sfshine@qq.com on 2019/2/17 0017.
 */
class CargoRecordModel(record: CargoRecord) :
    ViewModel() {
    val recordStr = ObservableField<String>(record.toString())
}