package com.dicoding.gunma

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.submissionproyekaplikasisederhana.R

class ListPhoneAdapter(private val listPhone: ArrayList<Phone>) : RecyclerView.Adapter<ListPhoneAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_phone, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listPhone.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val phone = listPhone[position]
        Glide.with(holder.itemView.context)
            .load(phone.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvName.text = phone.name
        holder.tvDetail.text = phone.detail

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listPhone[holder.adapterPosition]) }
    }

    inner  class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Phone)
    }
}