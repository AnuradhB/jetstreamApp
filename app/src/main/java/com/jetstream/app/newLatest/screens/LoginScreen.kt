package com.jetstream.app.newLatest.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetstream.app.R
import com.jetstream.app.ui.theme.ZenceyNewTheme

@Composable
fun LoginScreen() {

    // ✅ State (ONLY ONCE)
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // ✅ Font family (fixed mapping)
    val fontF = FontFamily(
        Font(R.font.acid_grotesk_bold, FontWeight.Normal),
        Font(R.font.acid_grotesk_medium, FontWeight.Bold)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo), modifier = Modifier.size(120.dp),
            contentDescription = "App Logo"
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Login",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = fontF
        )

        Spacer(modifier = Modifier.height(40.dp))

        // ✅ Email Field
        CustomField(
            value = email,
            onValueChange = { email = it },
            label = "Email",
            placeholder = "Enter your email",
            fontFamily = fontF
        )

        Spacer(modifier = Modifier.height(20.dp))

        // ✅ Password Field
        CustomField(
            value = password,
            onValueChange = { password = it },
            label = "Password",
            placeholder = "Enter your password",
            fontFamily = fontF
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                // Handle login
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }
    }
}

@Composable
fun CustomField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    fontFamily: FontFamily
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF5F5F5), RoundedCornerShape(12.dp))
            .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
            .padding(14.dp)
    ) {

        Text(
            text = label,
            fontSize = 14.sp,
            color = Color.Gray,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(4.dp))

        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            textStyle = androidx.compose.ui.text.TextStyle(
                fontSize = 16.sp,
                fontFamily = fontFamily
            ),
            decorationBox = { innerTextField ->
                if (value.isEmpty()) {
                    Text(
                        text = placeholder,
                        color = Color.LightGray,
                        fontFamily = fontFamily,
                        fontSize = 16.sp
                    )
                }
                innerTextField()
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLogin() {
    ZenceyNewTheme {
        LoginScreen()
    }
}