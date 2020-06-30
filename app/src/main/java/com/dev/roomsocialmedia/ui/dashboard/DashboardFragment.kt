package com.dev.roomsocialmedia.ui.dashboard

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.dev.roomsocialmedia.R
import com.dev.roomsocialmedia.databinding.FragmentDashboard2Binding
import com.dev.roomsocialmedia.db.model.Post
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.bottom_sheet_layout.view.*

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    var backcolor: String? = null

    val dashboardViewModel: DashboardViewModel by viewModels()
    lateinit var dashboard2Binding: FragmentDashboard2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dashboard2Binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard2, container, false)
        dashboard2Binding.lifecycleOwner = this
        dashboard2Binding.sendpost = dashboardViewModel

        dashboard2Binding.fab.setOnClickListener {
            showBottomSheetDialog()
        }
        // check the status of post request
        dashboardViewModel.status.observe(viewLifecycleOwner, Observer {
            when (it) {
                true -> Toast.makeText(activity, "success", Toast.LENGTH_SHORT).show()
                false -> Toast.makeText(activity, "success", Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(activity, "not available", Toast.LENGTH_SHORT).show()
            }
        })


        return dashboard2Binding.root
    }

    private fun showBottomSheetDialog() {
        val btnsheet = layoutInflater.inflate(R.layout.bottom_sheet_layout, null)
        val dialog = BottomSheetDialog(this.requireContext())
        dialog.setContentView(btnsheet)
        btnsheet.setOnClickListener {
            dialog.dismiss()
        }

        btnsheet.snapbtn.setOnClickListener {
            dashboardViewModel.getpost.observe(viewLifecycleOwner, Observer {
                it
            })
        }

        // android:onClick="@{() -> sendpost.sendpost()}"
        btnsheet.postnbtn.setOnClickListener {
            val pst = Post()
            pst.post = btnsheet.post_message.text.toString()
            pst.background_color = backcolor
            dashboardViewModel.sendpost(pst)
        }

        btnsheet.black.setOnClickListener {
            btnsheet.post_message.setBackgroundColor(Color.parseColor("#000060"))
            backcolor = "#000060"
        }

        btnsheet.yellow.setOnClickListener {
            btnsheet.post_message.setBackgroundColor(Color.parseColor("#ffd700"))
            backcolor = "#ffd700"
        }

        btnsheet.red.setOnClickListener {
            btnsheet.post_message.setBackgroundColor(Color.parseColor("#FF0000"))
            backcolor = "#FF0000"
        }
        btnsheet.blue.setOnClickListener {
            btnsheet.post_message.setBackgroundColor(Color.parseColor("#00FFFF"))
            backcolor = "#00FFFF"
        }
        btnsheet.orange.setOnClickListener {
            btnsheet.post_message.setBackgroundColor(Color.parseColor("#FFA500"))
            backcolor = "#FFA500"
        }


        dialog.show()
    }

}