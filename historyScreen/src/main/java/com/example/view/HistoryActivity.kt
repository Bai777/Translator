package com.example.view

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.core.viewmodel.base.BaseActivity
import com.example.historyscreen.databinding.ActivityHistoryBinding
import com.example.model.data.AppState
import com.example.model.data.userdata.DataModel
import org.koin.android.ext.android.inject
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.activityScope
import org.koin.core.scope.Scope

class HistoryActivity : BaseActivity<AppState, HistoryInteractor>(), AndroidScopeComponent {
    override val scope : Scope by activityScope()
    override lateinit var model: HistoryViewModel

    private lateinit var binding: ActivityHistoryBinding
    private val adapter: HistoryAdapter by lazy { HistoryAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        iniViewModel()
        initViews()
    }

    override fun onResume() {
        super.onResume()
        model.getData("", false)
    }

    override fun setDataToAdapter(data: List<DataModel>) {
        adapter.setData(data)
    }

    private fun iniViewModel() {
        if (binding.historyActivityRecyclerview.adapter != null) {
            throw IllegalStateException("The ViewModel should be initialised first")
        }
        val viewModel: HistoryViewModel by inject()
        model = viewModel
        model.subscribe().observe(this@HistoryActivity, Observer<AppState> { renderData(it) })
    }

    private fun initViews() {
        binding.historyActivityRecyclerview.adapter = adapter
    }
}