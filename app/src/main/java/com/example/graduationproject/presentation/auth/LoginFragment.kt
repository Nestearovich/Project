package com.example.graduationproject.presentation.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.androidproject.presentation.auths.LoginState
import com.example.androidproject.presentation.auths.LoginViewModel
import com.example.graduationproject.databinding.FragmentLoginBinding
import com.example.graduationproject.utils.NavigateHalper.replaceGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()


    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signIn.setOnClickListener {
            val username = binding.etName.text.toString()
            val password = binding.etPassword.text.toString()
            viewModel.validateCredentials(username, password)
        }

        viewModel.loginState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is LoginState.Success -> {
                    viewModel.loginUser(binding.etName.toString(),
                        binding.etPassword.toString())
                }
                is LoginState.Error -> {
                    val message = getString(state.messageResId)
                    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
                }
                else -> {}
            }
        }

        viewModel.error.observe(viewLifecycleOwner) { errorMsg ->
            Toast.makeText(context, getString(errorMsg), Toast.LENGTH_SHORT).show()
        }

        viewModel.navigation.observe(viewLifecycleOwner) { nav ->
            if (nav != null) {
                replaceGraph(nav)
                viewModel.userNavigated()
            }
        }
    }
}