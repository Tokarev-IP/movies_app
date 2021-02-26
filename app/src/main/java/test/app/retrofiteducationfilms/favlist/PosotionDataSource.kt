package test.app.retrofiteducationfilms.favlist

import androidx.paging.PositionalDataSource
import test.app.retrofiteducationfilms.db.Movies

class PosotionDataSource: PositionalDataSource<Movies>() {

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Movies>) {
        TODO("Not yet implemented")
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Movies>) {
        TODO("Not yet implemented")
    }
}