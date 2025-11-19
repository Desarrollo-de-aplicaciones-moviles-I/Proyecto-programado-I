package com.example.proyectoprogramadoi

import Entity.Alert
import Interfaces.OnItemClickListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.time.format.DateTimeFormatter

class CustomViewHolder (view: View): RecyclerView.ViewHolder(view){
    var txtViewDate: TextView = view.findViewById(R.id.txtViewDate)
    var txtViewHour: TextView = view.findViewById(R.id.txtViewHour)
    var txtViewCustomMessage: TextView = view.findViewById(R.id.txtViewCustomMessage)
    //var mapView: ImageView = view.findViewById(R.id.mapView2)

    fun bind (item: Alert, clickListener: OnItemClickListener){
        // Formatear fecha
        val dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        txtViewDate.text = item.DateAlert.format(dateFormatter)

        // Formatear hora
        val timeFormatter = DateTimeFormatter.ofPattern("HH:mm a")
        txtViewHour.text = item.DateAlert.toLocalTime().format(timeFormatter)

        txtViewCustomMessage.setText(item.Message.toString())
        //Aquí va la línea del mapa, aún no sé como hacerlo

        itemView.setOnClickListener{
            clickListener.onItemClicked(item)
        }
    }
}

class AlertListAdapter (private var itemList: List<Alert>, val itemClickListener: OnItemClickListener): RecyclerView.Adapter<CustomViewHolder>() {

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