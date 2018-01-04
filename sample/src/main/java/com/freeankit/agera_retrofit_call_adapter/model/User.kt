package com.freeankit.agera_retrofit_call_adapter.model

import com.google.gson.annotations.SerializedName
import java.security.acl.Owner

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 04/01/2018 (MM/DD/YYYY )
 */
class User {
    @SerializedName("name")
    val repoName: String = ""
    @SerializedName("full_name")
    val repoFullName: String = ""
    @SerializedName("Owner")
    val owner: Owner = Owner()

    class Owner {
        @SerializedName("login")
        val login: String = ""
    }
}