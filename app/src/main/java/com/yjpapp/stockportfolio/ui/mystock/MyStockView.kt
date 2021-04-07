package com.yjpapp.stockportfolio.ui.mystock

import com.yjpapp.stockportfolio.database.data.MyStockInfo

/**
 * MyStockFragment의 View
 *
 * @author Yoon Jae-park
 * @since 2020.12
 */
interface MyStockView {
    fun addButtonClick()

    fun showInputDialog(editMode: Boolean, myStockInfo: MyStockInfo?)

    fun showAddButton()

    fun hideAddButton()

    fun showEditButton()

    fun hideEditButton()

    fun setAdapter(myStockListAdapter: MyStockListAdapter)

    fun scrollTopPosition(topPosition: Int)

    fun bindTotalGainData()

    fun changeFilterText(text: String)

    fun showFilterDialog()
}