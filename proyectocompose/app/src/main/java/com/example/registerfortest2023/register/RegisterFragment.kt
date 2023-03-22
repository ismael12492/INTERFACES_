package com.example.registerfortest2023.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.login.data.User
import com.example.login.data.UserDataSource
import com.example.registerfortest2023.R
import com.example.registerfortest2023.databinding.FragmentRegisterBinding
import com.example.registerfortest2023.register.RegisterViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private lateinit var viewModel: RegisterViewModel;
    private lateinit var user:User;
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        UserDataSource.initUser()
        addchangesListener()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



       binding.btRegister.setOnClickListener {
           var todoBien=true;


           if(viewModel.nombreRepetido(binding.etName.text.toString())==true){
               binding.tilName.error="Name registered"
               todoBien=false;
           }


           if(!viewModel.correoMalformado(binding.etEmail.text.toString())==true){
               binding.tilEMail.error="Malformed email";
               todoBien=false;
           }else if(viewModel.correoExistente(binding.etEmail.text.toString())==true){
               binding.tilEMail.error="Email registered";
               todoBien=false;
           }

           if(viewModel.passLength(binding.etPass.text.toString())==true){
               binding.tilPass.error="Minimun length 8 characters";
               todoBien=false;
           }else if(viewModel.passworMatch(binding.etPass2.text.toString(),binding.etPass.text.toString())==true){
               binding.tilPass2.error="Password doesnt mactch";
               todoBien=false;
           }
           if(viewModel.camposVacios(binding.etName.text.toString())==true){
               binding.tilName.error="Need data";
               todoBien=false;
           }
           if(viewModel.camposVacios(binding.etEmail.text.toString())==true){
               binding.tilEMail.error="Need data";
               todoBien=false;
           }
           if(viewModel.camposVacios(binding.etPass.text.toString())==true){
               binding.tilPass.error="Need data";
               todoBien=false;
           }
           if(viewModel.camposVacios(binding.etPass2.text.toString())==true){
               binding.tilPass2.error="Need data";
               todoBien=false;
           }
           if(todoBien==true){
               user=User(binding.etName.text.toString() , binding.etEmail.text.toString() ,binding.etPass2.text.toString())
               viewModel.addUser(user);
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
           }
        }
    }
    fun addchangesListener(){
        binding.etName.addTextChangedListener{
            binding.tilName.error=null
        }
        binding.etEmail.addTextChangedListener{
            binding.tilEMail.error=null
        }
        binding.etPass.addTextChangedListener{
            binding.tilPass.error=null
        }
        binding.etPass2.addTextChangedListener{
            binding.tilPass2.error=null
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


