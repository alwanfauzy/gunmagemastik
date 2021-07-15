package com.dicoding.gunma

import com.dicoding.submissionproyekaplikasisederhana.R

object PhonesData {
    private val phoneIds = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

    private val phoneNames = arrayOf("iPhone 12",
        "Samsung Galaxy Note 20 Ultra 5g",
        "Huawei Mate 40 Pro Plus",
        "Xiaomi Poco X3 NFC",
        "Realme 7 5g",
        "Xiaomi Redmi Note 9 Pro",
        "Xiaomi Mi 10T Pro 5g",
        "Xiaomi Mi Note 10 Lite",
        "OnePlus 8T",
        "Samsung Galaxy M31s")

    private val phoneDetails = arrayOf("6.1\" FHD+, 12MP Camera, Apple A14 Bionic (5nm), 4GB RAM, 64/128/256GB Storage, 2815mAh Battery.",
        "6.9\" 2k+, 108MP Camera, Snapdragon 865+ (7nm), 12GB RAM, 128/256/512GB Storage, 4500mAh Battery.",
        "6.76\" 2k+, 50MP Camera, Kirin 9000 (5nm), 12GB RAM, 256GB Storage, 4400mAh Battery.",
        "6.67\" FHD+, 64MP Camera, Snapdragon 732G, 6GB RAM, 64/128 GB Storage, 5160mAh Battery.",
        "6.5\" FHD+, 48MP Camera, Dimensity 720 5G, 6GB RAM, 128GB Storage, 5000mAh Battery.",
        "6.67\" FHD+, 64MP Camera, Snapdragon 720G, 6GB RAM, 64/128 GB Storage, 5020mAh Battery.",
        "6.67\" FHD+, 108MP Camera, Snapdragon 865, 8GB RAM, 128/256 GB Storage, 5000mAh Battery.",
        "6.47\" FHD+, 64MP Camera, Snapdragon 730G, 6/8GB RAM, 64/128 GB Storage, 5260mAh Battery.",
        "6.55\" FHD+, 48MP Camera, Snapdragon 865, 8/12 GB RAM, 128/256 GB Storage, 4500mAh Battery.",
        "6.5\" FHD+, 64MP Camera, Exynos 9611, 6/8 GB RAM, 128 GB Storage, 6000mAh Battery.")

    private val phonePrices = arrayOf(19450000, 14500000, 15800000, 6799000, 8699000, 3999000, 10999000, 6000000, 9000000, 4599000)

    private val phoneImages = intArrayOf(
        R.drawable.iphone_12,
        R.drawable.samsung_galaxy_note_20_ultra_5g,
        R.drawable.huawei_mate_40_pro_plus,
        R.drawable.xiaomi_poco_x3_nfc,
        R.drawable.realme_7_5g,
        R.drawable.xiaomi_redmi_note_9_pro,
        R.drawable.xiaomi_mi_10t_pro_5g,
        R.drawable.xiaomi_mi_note_10_lite,
        R.drawable.oneplus_8t,
        R.drawable.samsung_galaxy_m31s
    )

    val listData: ArrayList<Phone>
        get() {
            val list = arrayListOf<Phone>()
            for (position in phoneNames.indices) {
                val phone = Phone()
                phone.id = phoneIds[position]
                phone.name = phoneNames[position]
                phone.detail = phoneDetails[position]
                phone.price = phonePrices[position]
                phone.photo = phoneImages[position]
                list.add(phone)
            }
            return list
        }
}