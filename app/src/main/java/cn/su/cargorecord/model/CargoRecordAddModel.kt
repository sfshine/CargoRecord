package cn.su.cargorecord.model

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import cn.su.cargorecord.db.dao.AppDatabase
import cn.su.cargorecord.db.entity.CargoRecord

/**
 * Created by sfshine@qq.com on 2019/2/17 0017.
 */
class CargoRecordAddModel : ViewModel() {
    val note = ObservableField<String>("")
    val money = ObservableField<String>("")
    fun addCargoRecord(cargoRecord: CargoRecord) {
        Thread {
            AppDatabase.INSTANCE.cargoRecordDao().add(cargoRecord)
        }.start()
    }
}