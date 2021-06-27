package com.devventure.todayscocktail.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devventure.todayscocktail.R
import com.devventure.todayscocktail.data.model.Drink
import de.hdodenhof.circleimageview.CircleImageView

class DrinkAdapter(private val interaction: Interaction?) : RecyclerView.Adapter<DrinkAdapter.MyViewHolder>() {
    var drinkList = listOf<Drink>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val drinkImage: CircleImageView = itemView.findViewById(R.id.imageView_drink)
        private val drinkTitle: TextView = itemView.findViewById(R.id.tvDrinkTitle)

        fun bind(drink: Drink) {
            itemView.setOnClickListener {
                interaction?.onItemSelected(drink)
            }
            drinkTitle.text = drink.strDrink
            Glide.with(itemView.context).load(drink.strDrinkThumb).into(drinkImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_drink, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val drink = drinkList[position]
        holder.bind(drink)
    }

    override fun getItemCount(): Int {
        return drinkList.size
    }

    interface Interaction {
        fun onItemSelected(item: Drink)
    }
}
