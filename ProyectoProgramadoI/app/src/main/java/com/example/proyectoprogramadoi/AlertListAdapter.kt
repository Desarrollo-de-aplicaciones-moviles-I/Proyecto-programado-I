package com.example.proyectoprogramadoi

import Entity.Alert
import Entity.DTOAlert
import Interfaces.OnItemClickListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

class CustomViewHolder (view: View): RecyclerView.ViewHolder(view) {
    var txtViewDate: TextView = view.findViewById(R.id.txtViewDate)
    var txtViewHour: TextView = view.findViewById(R.id.txtViewHour)
    var txtViewCustomMessage: TextView = view.findViewById(R.id.txtViewCustomMessage)
    //var mapView: ImageView = view.findViewById(R.id.mapView2)

    fun bind(item: DTOAlert, clickListener: OnItemClickListener) {
        val dateTime: LocalDateTime? = parseLocalDateTime(item.DateAlert)

        val dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val timeFormatter = DateTimeFormatter.ofPattern("hh:mm a")

        txtViewDate.text = dateTime?.format(dateFormatter) ?: ""
        txtViewHour.text = dateTime?.toLocalTime()?.format(timeFormatter) ?: ""

        txtViewCustomMessage.text = item.Message ?: ""

        itemView.setOnClickListener {
            clickListener.onItemClicked(item)
        }
    }

    private fun parseLocalDateTime(value: String?): LocalDateTime? {
        if (value.isNullOrEmpty()) return null
        return try {
            // Esto intenta parsear ISO 8601
            LocalDateTime.parse(value, DateTimeFormatter.ISO_DATE_TIME)
        } catch (e: DateTimeParseException) {
            e.printStackTrace()
            null
        }
    }
}

class AlertListAdapter (private var itemList: List<DTOAlert>, val itemClickListener: OnItemClickListener): RecyclerView.Adapter<CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_alert_history, parent, false)
        return CustomViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        var item = itemList[position]
        holder.bind(item, itemClickListener)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}