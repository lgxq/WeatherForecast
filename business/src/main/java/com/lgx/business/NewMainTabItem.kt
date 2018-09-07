package com.lgx.business

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by liugaoxin on 2018/9/7.
 * 新闻主页的title
 */
class NewMainTabItem(var title: String = "", var id: Int = 0): Parcelable {
    constructor(parcel: Parcel) : this() {
        title = parcel.readString()
        id = parcel.readInt()
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(title)
        dest?.writeInt(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NewMainTabItem> {
        override fun createFromParcel(parcel: Parcel): NewMainTabItem {
            return NewMainTabItem(parcel)
        }

        override fun newArray(size: Int): Array<NewMainTabItem?> {
            return arrayOfNulls(size)
        }
    }

}