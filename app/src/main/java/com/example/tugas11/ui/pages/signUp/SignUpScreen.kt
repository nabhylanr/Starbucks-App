package com.example.tugas11.ui.pages.signUp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.Tugas11Theme
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.ui.platform.LocalContext

@Composable
fun SignUpScreen(
    onSignUpClick: () -> Unit,
    onSignInClick: () -> Unit,
) {
    val (email, setEmail) = rememberSaveable { mutableStateOf("") }
    val (password, setPassword) = rememberSaveable { mutableStateOf("") }
    val (name, setName) = rememberSaveable { mutableStateOf("") }
    val (address, setAddress) = rememberSaveable { mutableStateOf("") }
    val (mobileNumber, setMobileNumber) = rememberSaveable { mutableStateOf("") }
    val (birthDate, setBirthDate) = rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Sign Up",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF01A29D),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.size(10.dp))

            SectionTitle(title = "Login Details")
            OutlinedTextField(
                value = email,
                onValueChange = setEmail,
                label = { Text(text = "Email Address") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            )

            OutlinedTextField(
                value = password,
                onValueChange = setPassword,
                label = { Text(text = "Password") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            )

            Spacer(modifier = Modifier.size(16.dp))

            SectionTitle(title = "Personal Details")

            OutlinedTextField(
                value = name,
                onValueChange = setName,
                label = { Text(text = "Name") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            )

            OutlinedTextField(
                value = birthDate,
                onValueChange = setBirthDate,
                label = { Text(text = "Birth Date (DD/MM/YYYY)") },
                placeholder = { Text("25/03/2004") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            )

            OutlinedTextField(
                value = address,
                onValueChange = setAddress,
                label = { Text(text = "Address") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            )

            OutlinedTextField(
                value = mobileNumber,
                onValueChange = setMobileNumber,
                label = { Text(text = "Mobile Number") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            )

            Spacer(modifier = Modifier.size(20.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onSignUpClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF01A29D)
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(text = "Register", fontWeight = FontWeight.SemiBold)
            }

            Spacer(modifier = Modifier.size(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Already have an account?",
                    fontSize = 14.sp
                )
                TextButton(onClick = onSignInClick) {
                    Text(
                        text = "Sign In",
                        fontSize = 14.sp,
                        color = Color(0xFF01A29D)
                    )
                }
            }
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.Start)
            .padding(vertical = 8.dp)
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SignUpScreenPreview() {
    Tugas11Theme {
        SignUpScreen({}, {})
    }
}
