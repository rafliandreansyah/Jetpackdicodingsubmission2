package com.azhara.jetpackdicodingsubmission2.ui

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.azhara.jetpackdicodingsubmission2.R
import com.azhara.jetpackdicodingsubmission2.ui.movies.MoviesFragment
import com.azhara.jetpackdicodingsubmission2.ui.tvshow.TvShowFragment

class SectionPagerAdapter(private val context: Context, fm: FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val TABS_TITLE = intArrayOf(R.string.movies, R.string.tvshow)

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position){
            0 -> fragment = MoviesFragment()
            1 -> fragment = TvShowFragment()
        }
        return fragment as Fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context?.resources.getString(TABS_TITLE[position])
    }

    override fun getCount(): Int  = 2
}