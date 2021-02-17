package com.yjpapp.stockportfolio.ui.view

import com.yjpapp.stockportfolio.database.data.IncomeNoteInfo
import com.yjpapp.stockportfolio.ui.adapter.IncomeNoteListAdapter

/**
 * IncomeNoteFragment의 View
 *
 * @author Yoon Jae-park
 * @since 2020.12
 */
interface IncomeNoteView {
    fun bindTotalGainData()

    fun changeFilterText(text: String)

    fun showAddButton()

    fun showFilterDialog()

    fun showInputDialog(editMode: Boolean, incomeNoteInfo: IncomeNoteInfo?)

    fun hideAddButton()

    fun scrollTopPosition(topPosition: Int)

    fun setAdapter(incomeNoteListAdapter: IncomeNoteListAdapter?)

}