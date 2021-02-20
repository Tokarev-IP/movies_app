package test.app.retrofiteducationfilms.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import test.app.retrofiteducationfilms.R
import test.app.retrofiteducationfilms.api.Movie

class ItemFragment(private val current: Movie) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val mInflater = inflater.inflate(R.layout.fragment_item, container, false)

        val mImageView: ImageView = mInflater.findViewById(R.id.image_view)
        val mTitleView: TextView = mInflater.findViewById(R.id.title_view)
        val mOverView: TextView = mInflater.findViewById(R.id.overview_view)
        val languageView: TextView = mInflater.findViewById(R.id.original_language_view)
        val mRData: TextView = mInflater.findViewById(R.id.releas_data_view)


        Picasso.get()
            .load(current.backdropPath)
            .placeholder(R.drawable.ic_baseline_image_search_24)
            .error(R.drawable.ic_baseline_image_search_24)
            .into(mImageView)

        mTitleView.text = current.title
        mOverView.text = current.overview
        languageView.text = "Original language: "+current.originalLanguage
        mRData.text = "Release data: "+ current.releaseDate

        return mInflater
    }

}