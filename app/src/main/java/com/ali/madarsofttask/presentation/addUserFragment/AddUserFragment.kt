package com.ali.madarsofttask.presentation.addUserFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ali.madarsofttask.R
import com.ali.madarsofttask.entity.source.model.User
import com.ali.madarsofttask.presentation.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_add_user.*

@AndroidEntryPoint
class AddUserFragment : Fragment(R.layout.fragment_add_user) {

    private val viewModel: UserViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSave.setOnClickListener {
            val gender = when {
                male.isChecked -> {
                    "male"
                }
                female.isChecked -> {
                    "female"
                }
                else -> ""
            }

            var age = 0
            try {
                age = ageEditText.text.toString().toInt()
            } catch (e: NumberFormatException) {
                // Log error, change value of temperature, or do nothing
            }




                val user = User(
                    name = userName.text.toString(),
                    age = age,
                    gender = gender,
                    jobTitle = jobTitleEdit.text.toString()
                )
                if (isValidForm(user)) {
                    viewModel.saveUser(user)
                    findNavController().navigate(R.id.action_addUserFragment_to_showUsersFragment)
                }

            }

    }


    private fun isValidForm(
        user: User
    ): Boolean {
        var isValid = true
        if (user.name.isNullOrEmpty()) {
            userName.error = "Required"
            isValid = false
        } else userName.error = null
        if (user.gender.isNullOrEmpty()) {
            gender.error = "Required"
            isValid = false
        } else gender.error = null
        if (user.jobTitle.isNullOrEmpty()) {
            jobTitleEdit.error = "Required"
            isValid = false
        } else jobTitleEdit.setError(null)

        if (user.age==0) {
            ageEditText.setError("Required")
            isValid = false
        } else ageEditText.setError(null)

        return isValid
    }


}