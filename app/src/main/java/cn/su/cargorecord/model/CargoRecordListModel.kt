package cn.su.cargorecord.model

import androidx.lifecycle.ViewModel
import cn.su.cargorecord.db.dao.AppDatabase
import java.util.*

/**
 * Created by sfshine@qq.com on 2019/2/17 0017.
 */
class CargoRecordListModel internal constructor() : ViewModel() {
    fun getCargoRecords(orderTime: Date) = AppDatabase.INSTANCE.cargoRecordDao().getCargoRecordSince(orderTime)
}